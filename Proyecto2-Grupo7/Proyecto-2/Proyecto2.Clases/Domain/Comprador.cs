using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2.Clases.Domain
{
    public class Comprador
    {
      

        public Comprador(string id, string nombre,string password, string emailPrincipal)
        {
            Id = id;
            Nombre = nombre;
            Password = password;
            EmailPrincipal= emailPrincipal;


        }

        public Comprador()
        {

        }

        private string id;
        public string Id
        {
            get
            {
                return id;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("El id es requerido");
                id = value;
            }
        }

        private string nombre;
        public string Nombre
        {
            get
            {
                return nombre;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("El nombre es requerido");
                nombre = value;
            }
        }

        private string password;
        public string Password
        {
            get
            {
                return password;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("La contraseña es requerido");
                password = value;
            }
        }
        private string emailPrincipal;
        public string EmailPrincipal
        {
            get
            {
                return emailPrincipal;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("El email principal es requerido");

                emailPrincipal = value;
            }
        }

    }
}
