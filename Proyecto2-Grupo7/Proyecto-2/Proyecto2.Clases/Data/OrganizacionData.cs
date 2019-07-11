using Proyecto2.Clases.Domain;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Text;

namespace Proyecto2.Clases.Data
{
    public class OrganizacionData { 

        public OrganizacionData()
        {

        }

        public List<Organizacion> obtenerOrganizacion()
        {
            List<Organizacion> org = new List<Organizacion>();
            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                connection.Open();
                string sql = "select descripcion from organization_info";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            
                            string descripcion = reader.GetString(0);

                            org.Add(new Organizacion(descripcion,null));
                                                           
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }
            return org;
        }

public void Actualizar(Organizacion org)
{
    using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
   "User id=estudiantesrp;Password=estudiantesrp"))
    {
        using (SqlCommand command = new SqlCommand())
        {
            command.Connection = connection;
            command.CommandType = CommandType.Text;
            command.CommandText = "UPDATE Organizacion set descripcion=@descripcion, lastUpdate=GETDATE() where id=1";
            command.Parameters.AddWithValue("@descripcion", org.Descripcion);
            
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
