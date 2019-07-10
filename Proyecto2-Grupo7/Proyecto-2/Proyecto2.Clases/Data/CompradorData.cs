using Proyecto2.Clases.Domain;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Text;

namespace Proyecto2.Clases.Data
{
    public class CompradorData
    {

        public List<Comprador> getCompradores()
        {
            List<Comprador> compradores = new List<Comprador>();
            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                connection.Open();
                string sql = "select id_comprador,nombre,password,email_principal from comprador";

                using (SqlCommand command = new SqlCommand(sql, connection))
                {

                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {

                            Comprador comprador = new Comprador();
                            comprador.Id = reader.GetString(0);
                            comprador.Nombre = reader.GetString(1);
                            comprador.Password = reader.GetString(2);
                            comprador.EmailPrincipal = reader.GetString(3);

                            compradores.Add(comprador);
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return compradores;
        }

        public void insertarComprador(Comprador comprador)
        {
            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                using (SqlCommand command = new SqlCommand())
                {
                    command.Connection = connection;
                    command.CommandType = CommandType.Text;
                    command.CommandText = "INSERT into Comprador (nombre,password,email_principal) VALUES (@nombre,@password,@email_principal)";
                    command.Parameters.AddWithValue("@nombre", comprador.Nombre);
                    command.Parameters.AddWithValue("@password", comprador.Password);
                    command.Parameters.AddWithValue("@email_principal", comprador.EmailPrincipal);
                    try
                    {
                        connection.Open();
                        int recordsAffected = command.ExecuteNonQuery();
                    }
                    catch (SqlException)
                    {

                    }
                    finally
                    {
                        connection.Close();
                    }
                }

            }

        }

        public bool validarUsuario(Comprador compradorParam)
        {
            bool validacion = false;
            List<Comprador> compradores = getCompradores();

            foreach (Comprador comprador in compradores)
            {
                if(comprador.Id == compradorParam.Id)
                {
                    validacion = true;
                }
            }

            return validacion;
        }
    }
}

