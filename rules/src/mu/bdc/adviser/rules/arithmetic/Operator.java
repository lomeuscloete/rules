package mu.bdc.adviser.rules.arithmetic;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/** enum **/

enum Operator {
	and(0, "&&", (x, y) -> x.and(y)), 
	or(1, "||", (x, y) -> x.or(y)), 
	lessThanEquals(2, "<=",(x, y) -> x.lessThanEquals(y)), 
	greaterThanEquals(3, ">=", (x, y) -> x.greaterThanEquals(y)), 
	lessThan(4, "<",(x, y) -> x.lessThan(y)), 
	greaterThan(5, ">", (x, y) -> x.greaterThan(y)), 
	notequals(6,"!=", (x, y) -> x.notequals(y)), 
	equals(7,"==", (x, y) -> x.equals(x)), 
	plus(8, "+", (x, y) -> x.plus(y)), 
	minus(9, "-", (x, y) -> x.minus(y)), 
	divide(10, "/", (x, y) -> x.divide(y)), 
	times(11, "*", (x, y) -> x.times(y));

	private int index;
	private String symbol;
	private BiFunction<Variable, Variable, Variable> operator;

	private static Map<String, Operator> OPERATOR_MAP;
	private static List<Operator> precedencelist;

	public static List<Operator> getPrecedencelist() {
		return precedencelist;
	}

	static {
		Map<String, Operator> map = new HashMap<String, Operator>();
		for (Operator instance : Operator.values()) {
			map.put(instance.getSymbol(), instance);
		}
		OPERATOR_MAP = Collections.unmodifiableMap(map);
	}

	static {
		Operator.values();
		precedencelist = Arrays.asList(Operator.values());
		precedencelist.sort((left, right) -> right.getIndex() - left.getIndex());
	}

	/*
	 * Get the operator for the symbol
	 */
	public static Operator get(String symbol) {
		return OPERATOR_MAP.get(symbol);
	}

	Operator(int index, String symbol, BiFunction<Variable,Variable,Variable> operator) {

		this.index = index;
		this.symbol = symbol;
		this.operator = operator;

	}

	public int getIndex() {
		return index;
	}

	public String getSymbol() {
		return symbol;
	}

	public BiFunction<Variable, Variable, Variable> getOperator() {
		return operator;
	}

	public Variable applyOp(Variable a, Variable b) {
		return operator.apply(a, b);
	}

}