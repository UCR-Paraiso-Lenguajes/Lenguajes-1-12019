using Orbis_B62734_.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Orbis_B62734_.Model.Data
{
    class PublicadorData
    {
       
        public IEnumerable<Publicador> GetAll()
        {
            SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=OrbisB62734_I_2019;" +
            "User id=estudiantesrp;Password=estudiantesrp" );

            String sql = "select id_publicador,nombre,url_sitio_web from Publicador";


            SqlDataAdapter daPublicador = new SqlDataAdapter();
            daPublicador.SelectCommand = new SqlCommand(sql, connection);
           

            DataSet dsPublicador = new DataSet();
            daPublicador.Fill(dsPublicador, "Publicador"); 

            List<Publicador> publicadores = new List<Publicador>();

            foreach (DataRow row in dsPublicador.Tables["Publicador"].Rows)
            {
                Publicador publicador = new Publicador();
                publicador.id_publicador= Int32.Parse(row["id_publicador"].ToString());
                publicador.nombre_publicador = row["nombre"].ToString();
                publicador.url_sitio_web = row["url_sitio_web"].ToString();

                publicadores.Add(publicador);
            }


            return publicadores;
        }
    }
}
