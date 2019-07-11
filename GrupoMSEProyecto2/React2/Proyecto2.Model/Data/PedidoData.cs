using Proyecto2.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace Proyecto2.Model.Data
{
    public class PedidoData
    {
        private string connectionString;

        private string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";

        public PedidoData()
        {
            this.connectionString = sqlconnect;
        }

        public Pedido ObtenerPedido(int idPedido)
        {
            Pedido pedidos = null;
            
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select p.id, p.email, p.direccion, p.tipo, p.fechaUltimoUso, p.fechaEntrega, p.totalProductosEntregados, p.fechaDespacho from Pedido p where p.id = "+idPedido;
                
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string email = reader.GetString(1);
                            string direccion = reader.GetString(2);
                            string tipo = reader.GetString(3);
                            DateTime fechaUltimo= reader.GetDateTime(4);
                            DateTime fechaEntrega = reader.GetDateTime(5);
                            int totalProductosEntregados = reader.GetInt32(6);
                            DateTime fechaDespacho = reader.GetDateTime(7);

                            List<ProductoCantidad> listaProducto = ordenCompra(idPedido);
                            OrdenDeCompra orden = new OrdenDeCompra(listaProducto);

                            if (fechaUltimo.Year.Equals(1850) && fechaEntrega.Year.Equals(1850) && totalProductosEntregados == 0)
                                pedidos=(new PedidoDespachado(id, email, direccion, orden, fechaDespacho, orden.TotalCompra));
                            else if (fechaUltimo.Year.Equals(1850) && fechaDespacho.Year.Equals(1850))
                                pedidos=(new PedidoEntregado(id, email, direccion, orden, fechaEntrega, orden.TotalCompra, totalProductosEntregados));
                            else if (fechaEntrega.Year.Equals(1850) && totalProductosEntregados == 0 && fechaDespacho.Year.Equals(1850))
                                pedidos=(new PedidoPendiente(id,email,direccion,orden,fechaUltimo));
                            
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }
            return pedidos;
        }

        private List<ProductoCantidad> ordenCompra(int idPedido) {
            List<ProductoCantidad> orden = new List<ProductoCantidad>();
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sqlOrden = "select p.id, p.impuesto, p.nombre, p.descripcion, p.precio, p.cantidadDisponible, p.imagen, pe.cantidadComprado  from Producto p join PedidoProducto pe on p.id=pe.idProducto where pe.idPedido = " + idPedido;
                using (SqlCommand command = new SqlCommand(sqlOrden, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            Decimal impuesto = reader.GetDecimal(1);
                            string nombre = reader.GetString(2);
                            string descripcion = reader.GetString(3);
                            Double precio = (Double)reader.GetDouble(4);
                            int cantidadDis = reader.GetInt32(5);
                            string imagen = reader.GetString(6);
                            int cantidadComprado = reader.GetInt32(7);
                            Producto producto = new Producto((float)precio, id, (double)impuesto, nombre, descripcion, cantidadComprado, imagen);
                            orden.Add(new ProductoCantidad(producto, cantidadComprado));
                        }
                    };
                }
                connection.Close();
            }

            return orden;
        }

        public IEnumerable<Pedido> ObtenerPedidoRango(int indice)
        {
            List<Pedido> pedidos = new List<Pedido>();

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select p.id, p.email, p.direccion, p.tipo, p.fechaUltimoUso, p.fechaEntrega, p.totalProductosEntregados, p.fechaDespacho from Pedido p where p.id between " + indice + " and " + indice + 49;

                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string email = reader.GetString(1);
                            string direccion = reader.GetString(2);
                            string tipo = reader.GetString(3);
                            DateTime fechaUltimo = reader.GetDateTime(4);
                            DateTime fechaEntrega = reader.GetDateTime(5);
                            int totalProductosEntregados = reader.GetInt32(6);
                            DateTime fechaDespacho = reader.GetDateTime(7);

                            List<ProductoCantidad> listaProducto = ordenCompra(indice);
                            OrdenDeCompra orden = new OrdenDeCompra(listaProducto);

                            if (fechaUltimo.Year.Equals(1850) && fechaEntrega.Year.Equals(1850) && totalProductosEntregados == 0)
                                pedidos.Add(new PedidoDespachado(id, email, direccion, orden, fechaDespacho, orden.TotalCompra));
                            else if (fechaUltimo.Year.Equals(1850) && fechaDespacho.Year.Equals(1850))
                                pedidos.Add(new PedidoEntregado(id, email, direccion, orden, fechaEntrega, orden.TotalCompra, totalProductosEntregados));
                            else if (fechaEntrega.Year.Equals(1850) && totalProductosEntregados == 0 && fechaDespacho.Year.Equals(1850))
                                pedidos.Add(new PedidoPendiente(id, email, direccion, orden, fechaUltimo));

                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }
            return pedidos;
        }

        public void InsertarPedido(Pedido pedido)
        {
            string tipo = "";
            DateTime ultimo,entregado,despachado;
            Object salida = pedido;
            if (salida is PedidoDespachado)
            {
                tipo = "Despachado";
                ultimo = DateTime.Parse("01-01-1850");
                entregado = DateTime.Parse("01-01-1850");
                pedido.FechaUltimoUso = ultimo;
                pedido.FechaEntrega = entregado;
            }
            else if (salida is PedidoEntregado)
            {
                tipo = "Entregado";
                ultimo = DateTime.Parse("01-01-1850");
                pedido.FechaUltimoUso = ultimo;
                despachado = DateTime.Parse("01-01-1850");
                pedido.FechaDespacho = despachado;
            }
            else if (salida is PedidoPendiente)
            {
                tipo = "Pendiente";
                entregado = DateTime.Parse("01-01-1850");
                despachado = DateTime.Parse("01-01-1850");
                pedido.FechaEntrega = entregado;
                pedido.FechaDespacho = despachado;
            }
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                //id,email,direccion,tipo,fechaUltimoUso,fechaEntrega,totalProductosEntregados,fechaDespacho
                string sql = "insert into Pedido(id, email, direccion, tipo, fechaUltimoUso, fechaEntrega, totalProductosEntregados, fechaDespacho) values(@id, @email, @direccion, @tipo, @fechaUltimoUso, @fechaEntrega, @totalProductosEntregados, @fechaDespacho)";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.Add(new SqlParameter("@id", pedido.Id));
                    command.Parameters.Add(new SqlParameter("@email", pedido.Email));
                    command.Parameters.Add(new SqlParameter("@direccion", pedido.Direccion));
                    command.Parameters.Add(new SqlParameter("@tipo", tipo));
                    command.Parameters.Add(new SqlParameter("@fechaUltimoUso", pedido.FechaUltimoUso));
                    command.Parameters.Add(new SqlParameter("@fechaEntrega", pedido.FechaEntrega));
                    command.Parameters.Add(new SqlParameter("@totalProductosEntregados", pedido.TotalProductosEntregados));
                    command.Parameters.Add(new SqlParameter("@fechaDespacho", pedido.FechaDespacho));
                    command.ExecuteNonQuery();
                }
                connection.Close();
            }
            insertarPedidoProducto(pedido.Id,pedido.OrdenDeCompra.ProductosCantidad);
        }

        public void ActualizaEstado(Pedido pedido)
        {

            using (SqlConnection connection = new SqlConnection(connectionString))
            {

                connection.Open();
                Object tipoPedido = pedido;
                string sqlActualiza = "";
                DateTime ultimo = new DateTime();
                int id = 0;
                string email = "";
                string direccion = "";
                string tipo = "";
                DateTime fechaUltimo = new DateTime();
                DateTime fechaEntrega = new DateTime();
                int totalProductosEntregados = 0;
                DateTime fechaDes = new DateTime();
                DateTime actual = new DateTime();

                TimeSpan ts = new TimeSpan();
                if (tipoPedido is PedidoDespachado)
                {
                    sqlActualiza = "update Pedido set email=@email, direccion=@direccion, tipo=@tipo, fechaUltimoUso=@fechaUltimoUso, fechaEntrega=@fechaEntrega,totalProductosEntregados=@totalProductosEntregados, fechaDespacho=@fechaDespacho where tipo = 'Despachado' and id = " + pedido.Id;
                    ultimo = DateTime.Parse("01-01-1850");
                }
                string buscaDespachados = "select p.id, p.email, p.direccion, p.tipo, p.fechaUltimoUso, p.fechaEntrega,p.totalProductosEntregados, p.fechaDespacho from Pedido p  where p.tipo = 'Despachado' and p.id=" + pedido.Id;
                using (SqlCommand command = new SqlCommand(buscaDespachados, connection))
                {

                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            id = reader.GetInt32(0);
                            email = reader.GetString(1);
                            direccion = reader.GetString(2);
                            tipo = reader.GetString(3);
                            fechaUltimo = reader.GetDateTime(4);
                            fechaEntrega = reader.GetDateTime(5);
                            totalProductosEntregados = reader.GetInt32(6);
                            fechaDes = reader.GetDateTime(7);
                            actual = DateTime.Now;
                            ts = actual - fechaDes;


                        }
                        reader.Close();
                    };

                }

                using (SqlCommand command = new SqlCommand(sqlActualiza, connection))
                {
                    int cantidadDias = ts.Days;
                    string tipoE = "Entregado";
                    if (cantidadDias >= 12)
                    {


                        DateTime nueva = DateTime.Now;
                        int total = ObtenerTotalProductoEntregado(id);
                        command.Parameters.AddWithValue("email", email);
                        command.Parameters.AddWithValue("direccion", direccion);
                        command.Parameters.AddWithValue("tipo", tipoE);
                        command.Parameters.AddWithValue("fechaUltimoUso", ultimo);
                        command.Parameters.AddWithValue("fechaEntrega", nueva);
                        command.Parameters.AddWithValue("totalProductosEntregados", total);
                        command.Parameters.AddWithValue("fechaDespacho", ultimo);
                        command.ExecuteNonQuery();
                    }
                }
                connection.Close();


            }

        }

        private int ObtenerTotalProductoEntregado(int idPedido)
        {
            int total = 0;
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select sum(cantidadComprado) as totalProductoEntregado from PedidoProducto where idPedido=" + idPedido;

                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            try
                            {
                                total = reader.GetInt32(0);
                            }
                            catch (Exception e)
                            {
                            }


                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }
            return total;
        }

        private void insertarPedidoProducto(int idPedido, List<ProductoCantidad> listaProductosCant)
        {
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                    foreach (ProductoCantidad productoCantidad in listaProductosCant)
                    {
                
                        string sql = "insert into PedidoProducto(idPedido,idProducto,cantidadComprado) values(@idPedido,@idProducto,@cantidadComprado)";
                        using (SqlCommand command = new SqlCommand(sql, connection))
                        {
                            command.Parameters.Add(new SqlParameter("@idPedido", idPedido));
                            command.Parameters.Add(new SqlParameter("@idProducto", productoCantidad.Producto.IdProducto));
                            command.Parameters.Add(new SqlParameter("@cantidadComprado", productoCantidad.Cantidad));
                            command.ExecuteNonQuery();
                        }
                        
                    }
                connection.Close();
            }
        }
        


        public void BorrarPedido(int Id)
        {

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = @"DELETE FROM Pedido 
                   WHERE id = @Id";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.AddWithValue("Id", Id);
                    command.ExecuteNonQuery();
                }
                connection.Close();
            }
        }
    }
}
