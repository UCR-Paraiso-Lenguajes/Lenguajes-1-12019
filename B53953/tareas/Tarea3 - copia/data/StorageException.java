package data;

public class StorageException extends Exception {
	
	

	public StorageException() {
		super();
	
	}

	public StorageException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public StorageException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public StorageException(String arg0) {
		super(arg0);
		
	}

	public StorageException(Throwable arg0) {
		super(arg0);
		
	}

	public String mensaje(String mensaje) {
		return mensaje;
	}
	
}
