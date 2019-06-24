using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2.Model.Domain
{
    public class Bodega
    {

        private static readonly Bodega instancia = new Bodega();//se inicializa variable de instancia

        private static List<ProductoCantidad> productosBodega = new List<ProductoCantidad>();


        public static void AgregarCantidadBodega(Producto producto)
        {/*
            if (productosBodega.Contains(productoCantidad))
            {
                
                // Busca por ID
                productosBodega.Wh(
                delegate (ProductoCantidad pc)
                {
                    productosBodega.Find(result).Cantidad = ;
                    return pc.Producto.IdProducto == productoCantidad.Producto.IdProducto;
                }
                );
                
                


            }*/
        }


        private Bodega()
        {
        }


        public static Bodega Instacia
        {
            get{
                return instancia;
            }
        }


    }
}
