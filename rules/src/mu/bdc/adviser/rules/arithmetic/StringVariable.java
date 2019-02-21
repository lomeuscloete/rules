package mu.bdc.adviser.rules.arithmetic;

public class StringVariable implements Variable<String>{

	private String value;
	
	public StringVariable(String value)
	{
		this.value = value;
	}
	@Override
	public String getValue() {
		
		return value;
	}

	@Override
	public Variable and(Variable right) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Variable or(Variable right) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Variable lessThanEquals(Variable right) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Variable greaterThanEquals(Variable right) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Variable lessThan(Variable right) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Variable greaterThan(Variable right) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Variable notequals(Variable right) {
		StringVariable stringRight = getVar(right);
		String rightString = (String) stringRight.getValue();
		Boolean result = !value.equals(rightString);
		return new BooleanVariable(result);
	}

	@Override
	public Variable equals(Variable right) {
		StringVariable stringRight = getVar(right);
		String rightString = (String) stringRight.getValue();
		Boolean result = value.equals(rightString);
		return new BooleanVariable(result);
	}

	@Override
	public Variable plus(Variable right) {
		StringVariable stringRight = getVar(right);
		String rightString = (String) stringRight.getValue();
		String result = value + (rightString);
		return new StringVariable(result);
	}

	@Override
	public Variable minus(Variable right) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Variable divide(Variable right) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Variable times(Variable right) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private StringVariable getVar(Variable right) {
		if (right instanceof StringVariable) {

			return (StringVariable) right;
		}
		return null;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}

}
