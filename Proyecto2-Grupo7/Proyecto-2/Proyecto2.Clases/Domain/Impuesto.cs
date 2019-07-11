using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2.Clases.Domain
{
    public class Impuesto
    {

        public Impuesto()
        {

        }

        public Impuesto(double valor, string ultimaModificacion)
        {
            Valor = valor;
            UltimaModificacion = ultimaModificacion;
        }

        private double valor;
        public double Valor
        {
            get
            {
                return valor;
            }
            set
            {
                if (double.IsPositiveInfinity(0.0)) throw new Exception("El valor es requerido");
                valor = value;

            }
        }

        private string ultimaModificacion;
        public string UltimaModificacion
        {
            get
            {
                return ultimaModificacion;
            }
            set
            {
                //if (string.IsNullOrEmpty(null)) throw new Exception("La ultima modificacion n es requerida");
                ultimaModificacion = value;
            }
        }
    }
}