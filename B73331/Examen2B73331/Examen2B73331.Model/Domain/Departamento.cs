using System;
using System.Collections.Generic;
using System.Text;

namespace Examen2B73331.Model.Domain
{
    public class Departamento:DepartamentoAbstracta
    {
        private DepartamentoAbstracta jefatura;
        public DepartamentoAbstracta Jefatura
        {
            get { return jefatura; }
            set
            {
                jefatura = value ?? throw new Exception("La jefatura no puede ser nula");
            }
        }

        public Departamento(int nid, string nnombre, bool nmarcado, DepartamentoAbstracta jefatura) : base(nid, nnombre, nmarcado)
        {
            Jefatura = jefatura;
        }

        public Departamento()
        {
        }
    }
}
