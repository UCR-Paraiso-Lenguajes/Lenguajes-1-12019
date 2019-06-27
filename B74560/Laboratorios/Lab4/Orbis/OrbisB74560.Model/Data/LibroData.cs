using OrbisB74560.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;
using System.Data;
using System.Data.SqlClient;

namespace OrbisB74560.Model.Data
{
    public class LibroData
    {
        private string connectionString;

        public LibroData(string connectiostring)
        {
            this.connectionString = connectiostring;
        }

        public IEnumerable<Libro> GetByCodPublicador(int codPublicador)
        {
            List<Libro> libros = new List<Libro>();
            using (SqlConnection connection = new SqlConnection(connectionString))
            {

                string sql = "SELECT cod_libro, titulo_libro, ano_publicacion,isbn, id_publicador FROM Libro WHERE id_publicador =" + codPublicador;
                
                DataSet librosBD = new DataSet();
                SqlDataAdapter adapter = new SqlDataAdapter();
                adapter.SelectCommand = new SqlCommand(
                    sql, connection);
                adapter.Fill(librosBD);

                foreach (DataRow pRow in librosBD.Tables[0].Rows)
                {
                    int id_Libro = (int)pRow["cod_libro"];
                    string titulo = (string)pRow["titulo_libro"];
                    Int32 ano = (Int16)pRow["ano_publicacion"];
                    String isbn = (string)pRow["isbn"];
                    Int32 id_publicador = (Int32)pRow["id_publicador"];
                    libros.Add(new Libro(id_Libro, titulo, ano, isbn, id_publicador));
                }

            }
            return libros;

        }
    }
}
