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
    class LibroData
    {
       
        public Libro GetByCodPublicador(int codPublicador)
        {
            SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=OrbisB62734_I_2019;" +
           "User id=estudiantesrp;Password=estudiantesrp");

            String sql = "select id_libro,titulo,año,isbn from Libro where id_publicador="+codPublicador;
            SqlDataAdapter daLibro = new SqlDataAdapter();

        
                daLibro.SelectCommand = new SqlCommand(sql, connection);
            daLibro.SelectCommand.CommandType = System.Data.CommandType.TableDirect;
        

            DataSet dsLibro = new DataSet();
            daLibro.Fill(dsLibro, "Libro"); //"Estado" seria el nombre del datatable dentro del dataset

            Libro libro = new Libro();

            foreach (DataRow row in dsLibro.Tables["Rol"].Rows)
            {
                libro.cod_libro = Int32.Parse(row["cod_libro"].ToString());
                libro.titulo_libro = row["titulo"].ToString();
                libro.ano_publicacion = Int32.Parse(row["año"].ToString());
                libro.isbn= row["isbn"].ToString();

            }
            return libro;
        }
    }
}
