package com.ucr.ac.cr.Examen1.exception;

@SuppressWarnings("serial")
public class ExamenException extends RuntimeException {

	public ExamenException() {
		super();
	}

	public ExamenException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ExamenException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ExamenException(String arg0) {
		super(arg0);
	}

	public ExamenException(Throwable arg0) {
		super(arg0);
	}

}
