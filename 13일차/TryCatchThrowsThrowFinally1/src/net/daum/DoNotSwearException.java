package net.daum;

public class DoNotSwearException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public DoNotSwearException() {
		
	}
	
	public DoNotSwearException(String message) {
		super(message);
	}

}
