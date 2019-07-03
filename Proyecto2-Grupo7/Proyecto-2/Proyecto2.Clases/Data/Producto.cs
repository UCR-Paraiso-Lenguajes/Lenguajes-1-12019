using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Common;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto2.Clases.Data
{
    public class Producto
    {
        public Producto()
        {
        }

        public Producto(String connectionString)
        {

          }

        public List<Producto> listaProducto()
        {
            List<Producto> listaProducto = new List<Producto>();

            SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;;" +
           "User id=estudiantesrp;Password=estudiantesrp");

            String sql = "select id_libro,titulo,año,isbn from Libro where id_publicador=";
            SqlDataAdapter daLibro = new SqlDataAdapter();


            daLibro.SelectCommand = new SqlCommand(sql);
            daLibro.SelectCommand.CommandType = System.Data.CommandType.TableDirect;


            DataSet dsLibro = new DataSet();
            daLibro.Fill(dsLibro, "Producto"); //"Estado" seria el nombre del datatable dentro del dataset

            Producto producto = new Producto();

            foreach (DataRow row in dsLibro.Tables["Rol"].Rows)
            {
                /*libro.cod_libro = Int32.Parse(row["cod_libro"].ToString());
                libro.titulo_libro = row["titulo"].ToString();
                libro.ano_publicacion = Int32.Parse(row["año"].ToString());
                libro.isbn = row["isbn"].ToString();*/

            }
            return listaProducto;
        }


    }
}
