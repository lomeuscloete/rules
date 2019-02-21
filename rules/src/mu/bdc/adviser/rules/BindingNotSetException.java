package mu.bdc.adviser.rules;

public class BindingNotSetException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2305448083381375174L;

	private String binding;
	
	public BindingNotSetException(String binding) {
		super(binding + " not set");
		this.binding=binding;
	}

	public String getBinding() {
		return binding;
	}

	

}
