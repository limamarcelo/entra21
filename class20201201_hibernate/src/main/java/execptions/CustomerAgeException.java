package execptions;

public class CustomerAgeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerAgeException(String mensagem) {
		super(mensagem);
	}
}
