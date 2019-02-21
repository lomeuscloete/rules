package mu.bdc.adviser.rules.arithmetic;

public class BooleanVariable implements Variable<Boolean> {

	
private Boolean value;

	
	public BooleanVariable(Boolean value) {
		super();
		this.value = value;
	}
	@Override
	public Boolean getValue() {
		return value;
	}

	@Override
	public Variable and(Variable right) {
		BooleanVariable boolRight = getVar(right);
		Boolean rightBool = (Boolean) boolRight.getValue();
		Boolean result = value && rightBool;
		return new BooleanVariable(result);
	}

	@Override
	public Variable or(Variable right) {
		BooleanVariable boolRight = getVar(right);
		Boolean rightBool = (Boolean) boolRight.getValue();
		Boolean result = value || rightBool;
		return new BooleanVariable(result);
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
		BooleanVariable boolRight = getVar(right);
		Boolean rightBool = (Boolean) boolRight.getValue();
		Boolean result = value != rightBool;
		return new BooleanVariable(result);
	}

	@Override
	public Variable equals(Variable right) {
		BooleanVariable boolRight = getVar(right);
		Boolean rightBool = (Boolean) boolRight.getValue();
		Boolean result = value == rightBool;
		return new BooleanVariable(result);
	}

	@Override
	public Variable plus(Variable right) {
		// TODO Auto-generated method stub
		return null;
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

	private BooleanVariable getVar(Variable right) {
		if (right instanceof BooleanVariable) {

			return (BooleanVariable) right;
		}
		return null;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value.toString();
	}
	

}
