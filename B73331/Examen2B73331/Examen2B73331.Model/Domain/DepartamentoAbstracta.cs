using System;
using System.Collections.Generic;
using System.Text;

namespace Examen2B73331.Model.Domain
{
    public abstract class DepartamentoAbstracta
    {
        private int id;
        public int Id
        {
            get { return id; }
            set
            {
                if (value <= 0) throw new Exception("El id debe ser mayor a cero");
                id = value;
            }
        }
        private string nombre;
        public string Nombre
        {
            get { return nombre; }
            set
            {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new Exception("El nombre debe ser distinto de vacio o nulo");
                nombre = value;
            }
        }
        private bool marcado;
        public bool Marcado
        {
            get { return marcado; }
            set
            {
                marcado = value;
            }
        }

        public DepartamentoAbstracta(int nid, string nnombre, bool nmarcado)
        {
            Id = nid;
            Nombre = nnombre;
            Marcado = nmarcado;
        }

        public DepartamentoAbstracta()
        {
        }
    }
}
