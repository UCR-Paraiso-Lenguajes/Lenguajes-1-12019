using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2Lenguajes.Model.Exceptions
{
    //Clase que contiene las excepciones de la compañía
    public class CompanniaException: Exception
    {

        /// <summary>
        /// Retorna la excepción con su mensaje.
        /// </summary>
        /// <param name="excepcion" type="string"></param>
        public CompanniaException(string excepcion)
        {
            throw new Exception(excepcion);
        }

    }
}
