using Proyecto2.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace Proyecto2.Model.Data
{

    
    public class CarritoData
    {
        private string connectionString;

        private string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";

        public CarritoData()
        {
            this.connectionString = sqlconnect;
        }

        public Object ObtenerCarritoPorUsuario(int idComprador)
        {
            Carrito carrito;
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select c.id as idCarrito, u.id as userId, u.nombre, u.passwordComprador, u.emailPrincipal, " +
                             "cp.idPedido as pedidoId, p.email as pedidoEmail, p.direccion as pedidoDireccion, " +
                             "p.tipo as pedidoTipo, p.fechaUltimoUso as pedidoFechaUltUso, p.fechaEntrega as pedidoFechaEntrega, " +
                             "p.totalProductosEntregados as pedidoTotalProdEntreg, p.fechaDespacho as pedidoFechaDespacho " +
                             "from  Comprador u inner join Carrito c on  u.id = c.idUser " +
                             "inner join CarritoPedido cp on cp.idCarrito = c.id inner join Pedido p on cp.idPedido = p.id " +
                             "where u.id = " + idComprador;
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            /*idCarrito,userId,nombre,passwordComprador,emailPrincipal,pedidoId*/
                            string idCarrito = reader.GetString(0);

                            int userId = reader.GetInt32(1);
                            string userNombre = reader.GetString(2); 
                            string passwordUser = reader.GetString(3); 
                            string userEmail = reader.GetString(4);

                            int pedidoId = reader.GetInt32(5);
                            string emailPedido = reader.GetString(6);
                            string direccionPedido = reader.GetString(7);
                            string tipoPedido = reader.GetString(8);
                            DateTime pedidoFechaUltUso = reader.GetDateTime(9);
                            DateTime pedidoFechaEntrega = reader.GetDateTime(10);
                            int pedidoTotalProdEntreg = reader.GetInt32(11);
                            DateTime pedidoFechaDespacho = reader.GetDateTime(12);


                            //Procedemos a obtener la lista de productoCantidad
                            List<ProductoCantidad> productosCantidad = getProductosCarritoIdPedido(pedidoId);
                            OrdenDeCompra ordenDeCompra = new OrdenDeCompra(productosCantidad);
                            int productosTotal = 0;
                            foreach (ProductoCantidad productoCantidad in productosCantidad)
                            {
                                productosTotal = productosTotal + productoCantidad.Cantidad;
                            }
                            Pedido pedido;
                            if (tipoPedido.Equals("Entregado"))
                            {
                                pedido = new PedidoEntregado(pedidoId, emailPedido, direccionPedido, ordenDeCompra,
                                    pedidoFechaEntrega,ordenDeCompra.TotalCompra, productosTotal);
                                carrito = new Carrito(idCarrito, new Usuario(userId, userNombre, passwordUser, userEmail), pedido);
                                return carrito;
                            }else if (tipoPedido.Equals("Despachado"))
                            {
                                //int id, string email, string direccion, OrdenDeCompra ordenDeCompra, DateTime fechaDespacho, double totalCompra
                                pedido = new PedidoDespachado(pedidoId, emailPedido, direccionPedido, ordenDeCompra,
                                    pedidoFechaDespacho, productosTotal);
                                carrito = new Carrito(idCarrito, new Usuario(userId, userNombre, passwordUser, userEmail), pedido);
                                return carrito;
                            }
                            else
                            {
                                pedido = new PedidoPendiente(pedidoId, emailPedido, direccionPedido, ordenDeCompra, pedidoFechaUltUso);
                                carrito = new Carrito(idCarrito, new Usuario(userId, userNombre, passwordUser, userEmail), pedido);
                                return carrito;
                            }
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return false;
        }
        private List<ProductoCantidad> getProductosCarritoIdPedido(int idPedido)
        {
            List<ProductoCantidad> productosCantidad = new List<ProductoCantidad>();


            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select p.precio,p.id,p.impuesto,p.nombre,p.descripcion,p.cantidadDisponible,p.imagen, pp.cantidadComprado " +
"FROM PedidoProducto pp inner join Producto p " +
"on pp.idProducto = p.id where pp.idPedido = " + idPedido;
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        Producto producto;
                        ProductoCantidad productoCantidad;
                        while (reader.Read())
                        {
                            //double precioUnitario, int idProducto, double impuestoC, string nombre, string descripcion, int cantidadDisponible, string imagen
                            double precioUnitario = reader.GetDouble(0);
                            double impuestoC = Convert.ToDouble(reader.GetDecimal(2)) / 100;
                            producto = new Producto(precioUnitario, reader.GetInt32(1), impuestoC,
                                reader.GetString(3), reader.GetString(4), reader.GetInt32(5), reader.GetString(6));
                            int cantidadComprado = reader.GetInt32(7);
                            productoCantidad = new ProductoCantidad(producto, cantidadComprado);
                            productosCantidad.Add(productoCantidad);
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }
            return productosCantidad;
        }

        public void InsertarCarrito(Carrito carrito)
        {
            PedidoData pedidoData = new PedidoData();
            pedidoData.InsertarPedido(carrito.Pedido);
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
	//carrito
                connection.Open();
                string sql = "insert into Carrito(id,idUser) values(@id,@idUser)";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.Add(new SqlParameter("@id", carrito.Id));
                    command.Parameters.Add(new SqlParameter("@idUser", carrito.Usuario.IdUsuario));
                    command.ExecuteNonQuery();
                }
                sql = "insert into CarritoPedido(idCarrito,idPedido) values(@idCarrito,@idPedido)";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.Add(new SqlParameter("@idCarrito", carrito.Id));
                    command.Parameters.Add(new SqlParameter("@idPedido", carrito.Pedido.Id));
                    command.ExecuteNonQuery();
                }
                connection.Close();
            }
;
        }

        
        public void Actualiza(int idUser,ProductoCantidad productoCantidad)
        {
            Carrito carrito = (Carrito)ObtenerCarritoPorUsuario(idUser);
            bool encontrado = false;
            foreach (ProductoCantidad prod in carrito.Pedido.OrdenDeCompra.ProductosCantidad)
            {
                if (prod.Producto.IdProducto == productoCantidad.Producto.IdProducto) encontrado = true;
            }
            if (encontrado)
            {
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    connection.Open();
                    string sql = "update PedidoProducto set cantidadComprado = cantidadComprado + @cantidadComprado where idPedido = " + carrito.Pedido.Id+" AND idProducto = "+productoCantidad.Producto.IdProducto;
                    using (SqlCommand command = new SqlCommand(sql, connection))
                    {
                        command.Parameters.Add(new SqlParameter("@cantidadComprado", productoCantidad.Cantidad));
                        command.ExecuteNonQuery();
                    }
                    connection.Close();
                }
            }
            else
            {
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    connection.Open();
                    string sql = "insert PedidoProducto(idPedido,idProducto,cantidadComprado) values(@idPedido,@idProducto,@cantidadComprado)";
                    using (SqlCommand command = new SqlCommand(sql, connection))
                    {
                        command.Parameters.Add(new SqlParameter("@idPedido", carrito.Pedido.Id));
                        command.Parameters.Add(new SqlParameter("@idProducto", productoCantidad.Producto.IdProducto));
                        command.Parameters.Add(new SqlParameter("@cantidadComprado", productoCantidad.Cantidad));
                        command.ExecuteNonQuery();
                    }
                    connection.Close();
                }
            }
            
        }
       

        public void BorrarCarrito(Carrito carrito)
        {

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "DELETE PedidoProducto WHERE idPedido = @idPedido";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.AddWithValue("idPedido", carrito.Pedido.Id);
                    command.ExecuteNonQuery();
                }
                sql = "DELETE CarritoPedido WHERE idPedido = @idPedido";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.AddWithValue("idPedido", carrito.Pedido.Id);
                    command.ExecuteNonQuery();
                }
                sql = "DELETE Pedido WHERE id = @id";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.AddWithValue("id", carrito.Pedido.Id);
                    command.ExecuteNonQuery();
                }
                sql = "DELETE Carrito WHERE id = @id";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.AddWithValue("id", carrito.Id);
                    command.ExecuteNonQuery();
                }
                connection.Close();
            }
        }
        public bool Comprar(Carrito carrito)
        {
            foreach (ProductoCantidad productoCantidad in carrito.Pedido.OrdenDeCompra.ProductosCantidad)
            {
                if (productoCantidad.Producto.CantidadDisponible < productoCantidad.Cantidad) return false;
            }
            Object carritoUsuario = ObtenerCarritoPorUsuario(Convert.ToInt32(carrito.Usuario.IdUsuario));
            if (carritoUsuario is Boolean)
            {
                InsertarCarrito(carrito);
                actualizaCantidadProductos(carrito.Pedido.OrdenDeCompra.ProductosCantidad);
                return true;
            }
            else if(carritoUsuario is Carrito)
            {
                BorrarCarrito((Carrito)carritoUsuario);
                InsertarCarrito((Carrito)carritoUsuario);
                actualizaCantidadProductos(carrito.Pedido.OrdenDeCompra.ProductosCantidad);
                return true;
            }

            return false;
        }
        private void actualizaCantidadProductos(List<ProductoCantidad>productoCantidads)
        {
            Producto productoActualizar = new Producto();
            int cantidad = 0;
            foreach (ProductoCantidad productoCantidad in productoCantidads)
            {
                cantidad = productoCantidad.Producto.CantidadDisponible - productoCantidad.Cantidad;
                if (cantidad <= 0)
                {
                    using (SqlConnection connection = new SqlConnection(connectionString))
                    {
                        connection.Open();
                        string sql = "DELETE PedidoProducto WHERE idPedido = @idPedido";
                        using (SqlCommand command = new SqlCommand(sql, connection))
                        {
                            command.Parameters.AddWithValue("idPedido", productoActualizar.IdProducto);
                            command.ExecuteNonQuery();
                        }
                        sql = "DELETE Producto WHERE id = @id";
                        using (SqlCommand command = new SqlCommand(sql, connection))
                        {
                            command.Parameters.AddWithValue("id", productoActualizar.IdProducto);
                            command.ExecuteNonQuery();
                        }
                        connection.Close();
                    }
                }
                else
                {
                    productoActualizar.CantidadDisponible = cantidad;
                    //double precioUnitario, int idProducto, double impuestoC, string nombre, string descripcion, int cantidadDisponible, string imagen
                    Producto productoActualizado = new Producto(productoCantidad.Producto.PrecioUnitario, productoCantidad.Producto.IdProducto, productoCantidad.Producto.Impuesto,
                        productoCantidad.Producto.Nombre, productoCantidad.Producto.Descripcion, cantidad, productoCantidad.Producto.Imagen);

                    string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
                    ProductoData productoData = new ProductoData(sqlconnect);
                    productoData.Actualiza(productoActualizado);

                }
            }
        }
    }
    
}
