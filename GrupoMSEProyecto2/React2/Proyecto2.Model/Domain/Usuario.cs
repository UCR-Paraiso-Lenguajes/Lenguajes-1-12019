using Proyecto2Lenguajes.Model.Exceptions;

namespace Proyecto2.Model.Domain
{
    /// <summary>
    /// Clase que gestiona usuarios
    /// </summary>
    public class Usuario
    {

        private decimal idUsuario;
        public decimal IdUsuario
        {
            get { return idUsuario; }
            set {
                if (value < 0) throw new CompanniaException("El impuesto no puede ser 0 o negativo");
                idUsuario = value;
            }
        }


        private string nombre;
        public string Nombre
        {
            get { return nombre; }
            set {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new CompanniaException("El nombre no puede estar vacío");
                nombre = value; }
        }



        private string password;
        public string Pasword   
        {
            get { return password; }
            set
            {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new CompanniaException("La contraseña no puede estar vacía");
                password = value;
            }
        }


        private string correoPrincipal;
        public string CorreoPrincipal
        {
            get { return correoPrincipal; }
            set
            {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new CompanniaException("El correo no puede estar vacío");
                else if (!value.Contains("@") || !value.Contains(".")) throw new CompanniaException("El correo debe tener la sintaxis xxxxx@xx.xx");
                correoPrincipal = value;
            }
        }





    }
}