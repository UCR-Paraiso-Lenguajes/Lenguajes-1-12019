package cr.ac.ucr.exceptions;


public class ProjectExceptions extends RuntimeException{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 789456123L;

	public ProjectExceptions(String message) {
		throw new RuntimeException(message);
	}
	public ProjectExceptions(Exception e) {
		throw new RuntimeException(e);
	}
	
	
}
