package cr.ac.ucr.tarea3.data;

import java.util.Date;

public interface EmpleadoInterface {
	
	public EmpleadoInterface obtenerEmpleado(int cod);
	
	public double obtenerSalarioPorFuncionario(int cod);
	
	public void cambiarFechaSalidaEmpresa(Date fecha);
	
	

}
