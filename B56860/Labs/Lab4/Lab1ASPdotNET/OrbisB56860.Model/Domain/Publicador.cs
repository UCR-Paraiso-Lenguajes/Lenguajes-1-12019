using System;

namespace OrbisB56860.Model.Domain
{
    public class Publicador
    {


        public Publicador(int idPublicador,string nombre,string url)
        {
            IdPublicador = idPublicador;
            Nombre = nombre;
            UrlSitioWeb = url;
        }

        
        private int idPublicador;

        public int IdPublicador
        {
            get { return idPublicador; }
            set {
                if (value < 0) throw new Exception("El id no puede ser negativo.");
                idPublicador = value;
            }
        }


        private string nombre;
        public string Nombre
        {
            get { return nombre; }
            set
            {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new Exception("El nombre no puede ser vacío");
                nombre = value;
            }
        }


        private string urlSitioWeb;
        private int id;
        private string titulo;
        private int precio;

        public string UrlSitioWeb
        {
            get { return urlSitioWeb; }
            set {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new Exception("El nombre no puede ser vacío");
                urlSitioWeb = value;
            }
        }



    }
}