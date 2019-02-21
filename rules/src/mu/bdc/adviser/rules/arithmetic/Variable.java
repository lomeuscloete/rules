package mu.bdc.adviser.rules.arithmetic;

public interface Variable<Value> {

	public Value getValue();
	public Variable and(Variable right);
	public Variable or(Variable right);
	public Variable lessThanEquals(Variable right); 
	public Variable greaterThanEquals(Variable right); 
	public Variable lessThan(Variable right); 
	public Variable greaterThan(Variable right); 
	public Variable notequals(Variable right); 
	public Variable equals(Variable right);
	public Variable plus(Variable right);
	public Variable minus(Variable right);
	public Variable divide(Variable right); 
	public Variable times(Variable right);


}
