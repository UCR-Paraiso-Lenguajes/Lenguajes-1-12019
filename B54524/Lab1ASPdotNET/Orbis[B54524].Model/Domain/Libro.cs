using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB54524.Model.Domain
{
    public class Libro
    {
        public int codLibro { get; internal set; }
        public string TituloLibro { get; internal set; }
        public short AnoPublicacion { get; internal set; }
        public string ISBN { get; internal set; }
        public Publicador Publicador { get; internal set; }
        public List<Autor> Autores { get; internal set; }

        public Libro(int codLibro, string tituloLibro, short anoPublicacion, string iSBN, Publicador publicador, List<Autor> autores)
        {
            this.codLibro = codLibro;
            TituloLibro = tituloLibro;
            AnoPublicacion = anoPublicacion;
            ISBN = iSBN;
            Publicador = publicador;
            Autores = autores;
        }
    }
}
