using Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AccesoDatos
{
   public  class PublicadorData
    {

        #region variables
        private ConexionDatos conexion = new ConexionDatos();
        #endregion



        #region consultas


        /// <summary>
        /// Priscilla Mena
        /// Efecto: devuelve una lista con todos los Libros
        /// Requiere: -
        /// Modifica: -
        /// Devuelve: lista de Libros
        /// </summary>
        /// <returns></returns>
        public List<Libro> GetByCodPublicador(int codPublicador)
        {

            List<Libro> listaLibros = new List<Libro>();

            SqlConnection sqlConnection = conexion.conexionLab();

            SqlCommand sqlCommand = new SqlCommand("select l.*, e.* from  libro l, editorial e where e.id_editorial=@id_editorial;", sqlConnection);
            sqlCommand.Parameters.AddWithValue("@id_editorial", codPublicador);
            SqlDataReader reader;
            sqlConnection.Open();
            reader = sqlCommand.ExecuteReader();

            while (reader.Read())
            {
                Libro libro = new Libro();
                Publicador publicador = new Publicador();

                libro.idLibro = Convert.ToInt32(reader["id_libro"].ToString());
                libro.titulo = reader["titulo"].ToString();
                libro.anno = Convert.ToInt32(reader["ano"].ToString());
                libro.precio = Convert.ToInt32(reader["precio"].ToString());
                publicador.nombre= reader["nombre"].ToString();
                publicador.direccion = reader["direccion"].ToString();
                publicador.telefono = reader["telefono"].ToString();
                publicador.idPublicador = Convert.ToInt32(reader["id_editorial"].ToString());
                libro.publicador = publicador;
                listaLibros.Add(libro);
            }

            sqlConnection.Close();

            return listaLibros;
        }

        #endregion

    }
}
