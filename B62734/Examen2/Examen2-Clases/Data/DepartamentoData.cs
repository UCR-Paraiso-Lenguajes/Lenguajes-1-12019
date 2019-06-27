using System;
using System.Collections.Generic;
using System.Text;
using Examen2_Clases.Domain;


namespace Examen2_Clases.Data
{
    public class DepartamentoData
    {
        private static List<Departamento> listaDepartamentos = new List<Departamento>();
        public IEnumerable<Departamento> Listar()
        {
            return listaDepartamentos;
        }

        public void Add(Departamento departamento)
        {

            if (departamento == null) throw new Exception("El departamento es requerido.");
            listaDepartamentos.Add(departamento);
        }

        public void Remove(Departamento departamento)
        {

            if (departamento == null) throw new Exception("El departamento es requerido.");
            listaDepartamentos.Remove(departamento);
        }
        public void Update( Departamento departamentoNuevo)
        {

            if (departamentoNuevo == null) throw new Exception("El departamento es requerido.");
            int cont = 0;
            int posicion = 0;
            foreach (var organigrama in listaDepartamentos)
            {
                if (organigrama.Id == departamentoNuevo.Id)
                {
                    posicion = cont;
                }
                cont++;
            }
            listaDepartamentos.Insert(posicion, departamentoNuevo);
        }
    }
}
