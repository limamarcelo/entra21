package execptions;

public class CustomerCpfException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerCpfException(String mensagem) {
		super(mensagem);
	}
}
