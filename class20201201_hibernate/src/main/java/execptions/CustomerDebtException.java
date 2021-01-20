package execptions;

public class CustomerDebtException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerDebtException(String mensagem) {
		super(mensagem);
	}
}
