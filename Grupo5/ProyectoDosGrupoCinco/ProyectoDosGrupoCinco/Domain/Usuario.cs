using ProyectoDosGrupoCinco.Business;
using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
    public class Usuario
    {
        private int idUsuario;
        private string nombre;
        private string correo;
        private string rol;
        private bool estado;
        private string password;

        public Usuario()
        {
        }

        public Usuario(int idUsuario, string nombre, string correo, string rol, bool estado, string password)
        {
            this.idUsuario = idUsuario;
            this.nombre = nombre;
            this.correo = correo;
            this.rol = rol;
            this.estado = estado;
            this.password = password;
        }

        public string Password
        {
            get
            {
                return password;
            }
            set
            {

                password = value;
            }
        }


        public int IdUsuario
        {
            get
            {
                return idUsuario;
            }
            set
            {

                idUsuario = value;
            }
        }

        public string Nombre
        {
            get
            {
                return nombre;
            }
            set
            {

                nombre = value;
            }
        }

        public string Correo
        {
            get
            {
                return correo;
            }
            set
            {

                correo = value;
            }
        }

        public string Rol
        {
            get
            {
                return rol;
            }
            set
            {

                rol = value;
            }
        }


      
        


        public bool Estado
        {
            get
            {
                return estado;
            }
            set
            {

                estado = value;
            }
        }



    }
}
