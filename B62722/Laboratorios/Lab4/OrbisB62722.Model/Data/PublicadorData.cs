using OrbisB62722.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB62722.Model.Data
{
    public class PublicadorData
    {
        String connectionString;
        public PublicadorData(string connectionString)
        {
            this.connectionString = connectionString;
        }

        public List<Publicador> getAll()
        {

            String sqlSelect = "SELECT  id_publicador, nombre_publicador , url_sitio_web"
                    + " FROM Publicador ";
            Console.Write(sqlSelect);
            SqlDataAdapter daPublicador = new SqlDataAdapter(sqlSelect, new SqlConnection(connectionString));

            DataSet dsPublicador = new DataSet();
            daPublicador.Fill(dsPublicador, "Publicador");
            Dictionary<Int32, Publicador> dictionary = new Dictionary<Int32, Publicador>();
            Publicador publicador = null;
            foreach (DataRow row in dsPublicador.Tables["Publicador"].Rows)
            {
                Int32 id = Int32.Parse(row["id_publicador"].ToString());
                if (dictionary.ContainsKey(id) == false)
                {
                    publicador = new Publicador();
                    publicador.id_publicador = id;
                    publicador.nombre_publicador = row["nombre_publicador"].ToString();
                    publicador.url_sitio_web = row["url_sitio_web"].ToString();
                    dictionary.Add(id, publicador);
                }
            }
            return dictionary.Values.ToList<Publicador>();
        }
    }
}

