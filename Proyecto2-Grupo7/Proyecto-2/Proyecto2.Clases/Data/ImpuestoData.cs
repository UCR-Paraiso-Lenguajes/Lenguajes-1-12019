using Proyecto2.Clases.Domain;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Text;

namespace Proyecto2.Clases.Data
{
    public class ImpuestoData
    {

        public List<Impuesto> obtenerImpuesto()
        {
            List<Impuesto> imp = new List<Impuesto>();
            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                connection.Open();
                string sql = "select IVA from impuesto";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {

                            double Iva = reader.GetDouble(0);

                            imp.Add(new Impuesto(Iva,null));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }
            return imp;
        }

        public void Actualizar(Impuesto impuesto)
        {
            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                using (SqlCommand command = new SqlCommand())
                {
                    command.Connection = connection;
                    command.CommandType = CommandType.Text;
                    command.CommandText = "UPDATE Impuesto set impuesto=@impuesto, lastUpdate=GETDATE() where id=@id";
                    command.Parameters.AddWithValue("@impuesto",impuesto.Valor);
                    command.Parameters.AddWithValue("@id", 1);
                    try
                    {
                        connection.Open();
                        command.ExecuteNonQuery();
                    }
                    catch (SqlException)
                    {
                        // error here
                    }
                    finally
                    {
                        connection.Close();
                    }
                }
            }

        }

    }
}
