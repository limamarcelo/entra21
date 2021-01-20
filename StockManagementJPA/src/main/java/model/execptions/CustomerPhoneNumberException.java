package model.execptions;

public class CustomerPhoneNumberException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerPhoneNumberException(String mensagem) {
		super(mensagem);
	}
}
