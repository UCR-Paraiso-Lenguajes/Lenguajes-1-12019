using Proyecto2Lenguajes.Model.Exceptions;
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

        private int idProducto;
        public int IdProducto
        {
            get { return idProducto; }
            set { if (value <= 0) throw new CompanniaException("El id producto no debe ser menor a 1"); idProducto = value; }
        }
        private int cantidadProducto;
        public int CantidadProducto
        {
            get { return cantidadProducto; }
            set { if (value <= 0) throw new CompanniaException("La cantidad de productos no puede ser negativo"); cantidadProducto = value; }
        }
        public Bodega(int idProducto, int cantidadProducto)
        {
            IdProducto = idProducto;
            CantidadProducto = cantidadProducto;

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
