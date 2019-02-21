package mu.bdc.adviser.rules.arithmetic;

public class BindingVariable implements Variable<String> {

	private String name;
	public BindingVariable(String name) {
		super();
		if (name.startsWith("#")) {
			this.name = name.substring(1);
		} else {
			this.name = name;
		}
	}

	@Override
	public String getValue() {
	
		return name;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Variable equals(Variable right) {
		// TODO Auto-generated method stub
		return null;
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

}
