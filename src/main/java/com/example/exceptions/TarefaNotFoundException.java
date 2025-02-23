package com.example.exceptions;

public class TarefaNotFoundException extends Exception{
	

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1514471202041161264L;

	public TarefaNotFoundException() {
	    super();
	  }

	  public TarefaNotFoundException(String message, Throwable cause, boolean enableSuppression,
	      boolean writableStackTrace) {
	    super(message, cause, enableSuppression, writableStackTrace);
	  }

	  public TarefaNotFoundException(String message, Throwable cause) {
	    super(message, cause);
	  }

	  public TarefaNotFoundException(String message) {
	    super(message);
	  }

	  public TarefaNotFoundException(Throwable cause) {
	    super(cause);
	  }

}
