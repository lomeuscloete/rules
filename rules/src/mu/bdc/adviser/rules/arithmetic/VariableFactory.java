package mu.bdc.adviser.rules.arithmetic;
/**
 * Factory class for Creating Variable from tokens
 * @author lomeus
 *
 */
public class VariableFactory {
	/**
	 * Create a "Variable" of the correct type.
	 * @param token
	 * @return the value of the token in the variable for the correct type.
	 */
	public Variable<?> getVariable(String token)
	{
		Variable<?> result = null;
		if (token.equalsIgnoreCase("true")||token.equalsIgnoreCase("false"))
		{
			result = new BooleanVariable(Boolean.valueOf(token));
		}else if(token.matches("\\d+"))
		{
			result = new IntegerVariable(Integer.valueOf(token));
		}else if (token.startsWith("#"))
		{
			result = new BindingVariable(token);
		}else if (token.startsWith("'") && token.endsWith("'"))
		{
			result = new StringVariable(token.substring(1, token.length()-1));
		}
		// If it is not one of these it must be a operator of some kind so return null.
		
		return result;
		
	}

}
