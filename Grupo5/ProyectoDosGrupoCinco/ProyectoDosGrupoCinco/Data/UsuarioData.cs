using ProyectoDosGrupoCinco.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace ProyectoDosGrupoCinco.Data
{
    public class UsuarioData
    {

        public void InsertarUsuario(Usuario usuario)
        {




            using (SqlConnection connection = new SqlConnection("data source=" +
                 "163.178.173.148;initial " +
                 "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                 "multipleactiveresultsets=True"))
            {
                String query = "INSERT INTO Usuario (nombre, correo, rol, estado, password) " +

                    "VALUES (@nombre,@correo,@rol, @estado,@password)";

                using (SqlCommand command = new SqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@nombre", usuario.Nombre);
                    command.Parameters.AddWithValue("@correo", usuario.Correo);
                    command.Parameters.AddWithValue("@rol", usuario.Rol);
                    command.Parameters.AddWithValue("@estado", usuario.Estado);
                    command.Parameters.AddWithValue("@password", usuario.Password);



                    connection.Open();
                    int result = command.ExecuteNonQuery();

                    // Check Error
                    if (result < 0)
                        Console.WriteLine("Error inserting data into Database!");
                }
            }



        }

        public void activarUsuario(int id)
        {
            

            using (SqlConnection conn = new SqlConnection("data source=" +
           "163.178.173.148;initial " +
           "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
           "multipleactiveresultsets=True"))
            {
                conn.Open();

                string sql = "UPDATE Usuario SET estado = true WHERE id = " + id;


                using (SqlCommand command = new SqlCommand(sql, conn))
                {

                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {

                        }
                        reader.Close();
                    };
                }
                conn.Close();
            }


        }


        public Usuario UsuarioPorId(int id)
        {

            Usuario usuario = new Usuario();
            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                "multipleactiveresultsets=True"))
            {
                connection.Open();
                string sql = "select nombre, correo, rol, estado, password from Usuario WHERE id = " + id;
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int idUsuario = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            string correo = reader.GetString(2);
                            string rol = reader.GetString(3);
                            bool estado = reader.GetBoolean(4);
                            string password = reader.GetString(5);

                            usuario = new Usuario(id, nombre, correo, rol, estado, password);

                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return usuario;
        }



        public List<Usuario> GetAllUsuarios()
        {

            List<Usuario> usuarios = new List<Usuario>();

            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                "multipleactiveresultsets=True"))
            {
                connection.Open();
                string sql = "select id, nombre, correo, rol, estado, password from Usuario";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int idUsuario = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            string correo = reader.GetString(2);
                            string rol = reader.GetString(3);
                            bool estado = reader.GetBoolean(4);
                            string password = reader.GetString(5);

                            usuarios.Add(new Usuario(idUsuario, nombre, correo, rol, estado, password));

                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }


            return usuarios;
        }
    }
}
