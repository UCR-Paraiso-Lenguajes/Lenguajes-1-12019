using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
   public class Comprador
    {

        private int idComprador;
        private string nombre;
        private string password;
        private string emailPrincipal;

        public int IdComprador{
            get
            {
                return idComprador;
            }
            set
            {

                idComprador = value;
            }
        }

    }
}
