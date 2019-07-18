using System;
using System.Collections.Generic;
using System.Text;
using Examen2_Clases.Data;
using Examen2_Clases.Domain;

namespace Examen2_Clases.Business
{
   public  class DepartamentoBusiness
    {
        public DepartamentoBusiness() {
            DepartamentoData departamentoData = new DepartamentoData();
            DepartamentoRaiz gerenciaGeneral = new DepartamentoRaiz("1", "Gerencia general", new OrganigramaJerarquico("1", "empresa nueva"));
            Subdepartamento administracion = new Subdepartamento("2", "Administracion", new OrganigramaJerarquico("1", "empresa nueva"), gerenciaGeneral);
            Subdepartamento profesores = new Subdepartamento("3", "Profesores", new OrganigramaJerarquico("1", "empresa nueva"), administracion);
            Subdepartamento alumnos = new Subdepartamento("4", "Alumnos", new OrganigramaJerarquico("1", "empresa nueva"), profesores);
            departamentoData.Add(gerenciaGeneral);
            departamentoData.Add(administracion);
            departamentoData.Add(profesores);
            departamentoData.Add(alumnos);

        }
        DepartamentoData departamentoData = new DepartamentoData();
        public IEnumerable<Departamento> Listar()
        {
            return departamentoData.Listar();
        }
        public void Actualizar( Departamento departamentoNuevo)
        {
            departamentoData.Update(departamentoNuevo);
        }
        public void Eliminar( Departamento departamento)
        {
            departamentoData.Remove(departamento);
        }
        public void Agregar( Departamento departamento)
        {
            departamentoData.Add(departamento);
        }
    }
}
