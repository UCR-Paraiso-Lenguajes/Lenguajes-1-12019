using ExamenModel.exception;

namespace ExamenModel.domain
{
    public class Pelicula
    {
        private string nombrePelicula;
        private string generoPelicula;
        private int edadMayorDe;
        private string urlPortada;

        public Pelicula(string nombrePelicula, string generoPelicula, int edadMayorDe, string urlPortada)
        {
            if (nombrePelicula.Trim().Equals("") || generoPelicula.Trim().Equals("") || urlPortada.Trim().Equals(""))
                throw new Exceptions("El nombre de la pelicula, genero y la URL son requeridos");
            if (nombrePelicula.Length > 300 || generoPelicula.Length > 300 || urlPortada.Length > 300)
                throw new Exceptions("El nombre de la pelicula, genero y URL tienen restriccion de Longitud");
            if (edadMayorDe < 0 && edadMayorDe < 22)
                throw new Exceptions("La edad mayor para las peliculas es requerido");

            NombrePelicula = nombrePelicula;
            GeneroPelicula = generoPelicula;
            EdadMayorDe = edadMayorDe;
            UrlPortada = urlPortada;

        }

        public string GeneroPelicula
        {
            get
            {
                return generoPelicula;
            }
            set
            {
                
                generoPelicula = value;

            }
        }

        public string NombrePelicula
        {
            get
            {
                
                return nombrePelicula;
            }
            set
            {
                
                
                nombrePelicula = value;

            }
        }

        public int EdadMayorDe
        {
            get
            {
                return edadMayorDe;
            }

            set
            {
                edadMayorDe = value;

            }
        }

        public string UrlPortada
        {
            get {
                return urlPortada;
            }

            set
            {

                urlPortada = value;

            }

        }
    }
}
