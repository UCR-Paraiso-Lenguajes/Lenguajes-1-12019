using Proyecto2.Clases.Domain;
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
    public class ProductoData
    {
        public ProductoData()
        {
        }

        public IEnumerable<Producto> listaProducto()
        {
            List<Producto> listaProducto = new List<Producto>();

            SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;;" +
           "User id=estudiantesrp;Password=estudiantesrp");

            String sql = "select * from Producto";
            SqlDataAdapter daProducto = new SqlDataAdapter();

            daProducto.SelectCommand = new SqlCommand(sql);
            daProducto.SelectCommand.CommandType = System.Data.CommandType.TableDirect;
            
            DataSet dsProducto = new DataSet();
            daProducto.Fill(dsProducto, "Producto"); //"Estado" seria el nombre del datatable dentro del dataset

            Producto producto = new Producto();
           
            foreach (DataRow row in dsProducto.Tables["id_producto"].Rows)
            {
                 producto.Id =""+Int32.Parse(row["id_producto"].ToString());
                 producto.Nombre = row["nombre"].ToString();
                producto.Url_image = row["url_image"].ToString();
                producto.Impuesto = decimal.Parse(row["impuesto"].ToString());
                 producto.Descripcion = row["descripcion"].ToString();
                 producto.CantidadDisponible = Int32.Parse(row["cantidad_disponible"].ToString());

                listaProducto.Add(producto);
            }

            Console.WriteLine(listaProducto);

            return listaProducto.AsEnumerable<Producto>();

        }
        
    }
}
