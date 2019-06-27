using Model.Domain;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace Model.Data
{
    public class PublicadorData
    {
        private string connectionString;

        public PublicadorData()
        {
        }

        //public PublicadorData(string connectionString)
        //{
        //    this.connectionString = connectionString;
        //}

        public IEnumerable<Publicador> GetAllPublicadores(string connectionString)
        {
           using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "getPublicadoresProcedure";

                SqlDataAdapter daPublicador = new SqlDataAdapter(sql, connection);

                //using (SqlCommand command = new SqlCommand(sql, connection))
                //{
                //    using (SqlDataReader reader = command.ExecuteReader())
                //    {
                //        while (reader.Read())
                //        {
                //            int id = reader.GetInt32(1);
                //            string nombre = reader.GetString(2);
                //            string url = reader.GetString(3);

                //            publicadores.Add(new Publicador(id, nombre, url));
                //        }
                //        reader.Close();
                //    };
                //}

                daPublicador.SelectCommand.CommandType = CommandType.StoredProcedure;
                DataSet dsPublicador = new DataSet();
                daPublicador.Fill(dsPublicador, "Libro");
                List<Publicador> publicadores = new List<Publicador>();
                foreach(DataRow row in dsPublicador.Tables["Libro"].Rows)
                {
                    publicadores.Add(new Publicador(Int32.Parse(row["id_publicador"].ToString()), row["nombre_publicador"].ToString(), row["url_sitio_web"].ToString()));
                }

                connection.Close();
                return publicadores;
            }
            
        }

    }

}
