using ProyectoDosGrupoCinco.Domain;
using System.Collections.Generic;
using System.Data.SqlClient;

namespace ProyectoDosGrupoCinco.Data
{
    public class CarritoData
    {

        public IEnumerable<Carrito> List()
        {
            List<Carrito> carritos = new List<Carrito>();
            using (SqlConnection connection = new SqlConnection("data source=" +
              "163.178.173.148;initial " +
              "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
              "multipleactiveresultsets=True"))
            {
                connection.Open();
                string sql = "select * from Carrito";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string nombre = reader.GetString(1);

                            
                          //  carritos.Add(new CarritoDisponible(id, nombre));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return carritos;
        }

    }
}
