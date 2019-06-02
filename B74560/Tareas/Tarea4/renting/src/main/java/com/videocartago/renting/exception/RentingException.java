package com.videocartago.renting.exception;

@SuppressWarnings("serial")
public class RentingException extends RuntimeException {

	public RentingException() {
		super();
	}

	public RentingException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public RentingException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public RentingException(String arg0) {
		super(arg0);
	}

	public RentingException(Throwable arg0) {
		super(arg0);
	}

}
