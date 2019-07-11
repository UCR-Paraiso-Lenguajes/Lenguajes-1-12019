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

        string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";

        public PedidoData(string connectiostring)
        {
            this.connectionString = connectiostring;
        }

        public IEnumerable<Pedido> ObtenerPedido(Pedido pedido)
        {
            List<Pedido> pedidos = new List<Pedido>();
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select p.id, p.email, p.direccion, p.tipo, p.fechaUltimoUso, p.fechaEntrega, p.totalCompra, p.totalProductosEntregados, p.fechaDespacho from Pedido p where p.id = "+pedido.Id;
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
                            int totalCompra = reader.GetInt32(6);
                            int totalProductosEntregados = reader.GetInt32(7);
                            DateTime fechaDespacho = reader.GetDateTime(8);

                            if (fechaUltimo == null && fechaEntrega == null && totalProductosEntregados == 0)
                                pedidos.Add(new PedidoDespachado(id, email, direccion, null, fechaDespacho, totalCompra));
                            else if (fechaUltimo == null && fechaDespacho == null)
                                pedidos.Add(new PedidoEntregado(id, email, direccion, null, fechaEntrega, totalCompra, totalProductosEntregados));
                            else if (fechaEntrega == null && totalCompra == 0 && totalProductosEntregados == 0 && fechaDespacho==null)
                                pedidos.Add(new PedidoPendiente(id,email,direccion,null,fechaUltimo));
                            
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
            Object salida = pedido;
            if (salida is PedidoDespachado)
                tipo = "Despachado";
            else if (salida is PedidoEntregado)
                tipo = "Entregado";
            else if (salida is PedidoPendiente)
                tipo = "Pendiente";

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "insert into Pedido(idProducto,cantidadProducto) values(@idProducto,@cantidadProducto)";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    //command.Parameters.Add(new SqlParameter("@idProducto", idProducto));
                    //command.Parameters.Add(new SqlParameter("@cantidadProducto", cantidadProducto));
                    command.ExecuteNonQuery();
                }
                connection.Close();
            }
        }


        public void Actualiza(Pedido pedido)
        {
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                //connection.Open();
                //string sql = @"UPDATE Pedido SET 
                //          cantidadProducto = @CantidadProducto
                //    WHERE idProducto = " + idProducto;
                //using (SqlCommand command = new SqlCommand(sql, connection))
                //{
                //    command.Parameters.AddWithValue("idProducto", idProducto);
                //    command.Parameters.AddWithValue("cantidadProducto", cantidadProducto);
                //    command.ExecuteNonQuery();
                //}
                //connection.Close();
            }
        }


        public void BorrarPedido(int Id)
        {

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = @"DELETE FROM Pedido 
                   WHERE idProducto = @Id";
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
