package mu.bdc.adviser.rules.arithmetic;

public class IntegerVariable implements Variable<Integer> {

	private Integer value;

	public IntegerVariable(Integer value) {
		super();
		this.value = value;
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
		IntegerVariable intRight = getVar(right);
		Integer rightInt = (Integer) intRight.getValue();
		Boolean result = value <= rightInt;
		return new BooleanVariable(result);
	}

	@Override
	public Variable greaterThanEquals(Variable right) {
		IntegerVariable intRight = getVar(right);
		Integer rightInt = (Integer) intRight.getValue();
		Boolean result = value >= rightInt;
		return new BooleanVariable(result);
	}

	@Override
	public Variable lessThan(Variable right) {
		IntegerVariable intRight = getVar(right);
		Integer rightInt = (Integer) intRight.getValue();
		Boolean result = value < rightInt;
		return new BooleanVariable(result);
	}

	@Override
	public Variable greaterThan(Variable right) {
		IntegerVariable intRight = getVar(right);
		Integer rightInt = (Integer) intRight.getValue();
		Boolean result = value > rightInt;
		return new BooleanVariable(result);
	}

	@Override
	public Variable notequals(Variable right) {
		IntegerVariable intRight = getVar(right);
		Integer rightInt = (Integer) intRight.getValue();
		Boolean result = !value.equals(rightInt);
		return new BooleanVariable(result);
	}

	@Override
	public Variable equals(Variable right) {
		IntegerVariable intRight = getVar(right);
		Integer rightInt = (Integer) intRight.getValue();
		Boolean result = value.equals(rightInt);
		return new BooleanVariable(result);
	}

	@Override
	public Variable plus(Variable right) {
		IntegerVariable intRight = getVar(right);
		Integer rightInt = (Integer) intRight.getValue();
		Integer result = value + rightInt;
		return new IntegerVariable(result);
	}

	@Override
	public Variable minus(Variable right) {
		IntegerVariable intRight = getVar(right);
		Integer rightInt = (Integer) intRight.getValue();
		Integer result = value - rightInt;
		return new IntegerVariable(result);
	}

	@Override
	public Variable divide(Variable right) {
		IntegerVariable intRight = getVar(right);
		Integer rightInt = (Integer) intRight.getValue();
		Integer result = value / rightInt;
		return new IntegerVariable(result);
	}

	@Override
	public IntegerVariable times(Variable right) {

		IntegerVariable intRight = getVar(right);
		Integer rightInt = (Integer) intRight.getValue();
		Integer result = value * rightInt;
		return new IntegerVariable(result);

	}

	private IntegerVariable getVar(Variable right) {
		if (right instanceof IntegerVariable) {

			return (IntegerVariable) right;
		}
		return null;
	}

	@Override
	public Integer getValue() {

		return value;
	}
	
	@Override
	public String toString() {
		
		return value.toString();
	}

}
