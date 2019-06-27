using Orbis_B62734_.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace Orbis_B62734_.Model.Domain
{
    public class Autores
    {
        private List<Autor> autores = new List<Autor>();
    
    internal IEnumerable<Autor> Listar()
    {
        return autores;
    }

    private void Add(Autor autor)
    {
        if (autor == null) throw new Exception("El actor es requerido.");
        autores.Add(autor);
    }
    }

    public class Libro
    {
        public Publicador publicador{ get; set; }
        public int cod_libro { get; set; }
        public string titulo_libro { get; set; }
        public int ano_publicacion { get; set; }
        public string isbn { get; set; }
}
}
