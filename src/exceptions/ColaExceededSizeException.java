package exceptions;

public class ColaExceededSizeException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ColaExceededSizeException (String m) {
		super(m);
	}
}
