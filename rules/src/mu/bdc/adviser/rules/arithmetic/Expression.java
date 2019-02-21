package mu.bdc.adviser.rules.arithmetic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import mu.bdc.adviser.rules.BindingNotSetException;
import mu.bdc.adviser.rules.Bindings;

public class Expression {

	private static final String END_B = ")";
	private static final String START_B = "(";
	//private final Logger logger = LoggerFactory.getLogger(Adviser.class);
	private List<?> expression;

	public Expression(String expression) {
		List tokens = new LinkedList(Arrays.asList(expression.split("\\s")));
		VariableFactory factory = new VariableFactory();
		for (int i = 0; i < tokens.size(); i++) {
			String element = (String) tokens.get(i);

			Variable var = factory.getVariable(element);
			if (var != null) {
				tokens.set(i, var);
			}
		}
		this.expression = tokens;

	}

	public Variable proccess(Bindings bindings) throws BindingNotSetException {
		List tokens = new LinkedList(this.expression);
		VariableFactory factory = new VariableFactory();
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i) instanceof BindingVariable) {
				BindingVariable bindingVar = (BindingVariable) tokens.get(i);
				String value = bindings.getValue(bindingVar.getValue());
				if (value == null)
				{
					throw new BindingNotSetException(bindingVar.getValue());
					 //The bindings in the expression has not been set.
				}
				Variable var = factory.getVariable(value);
				tokens.set(i, var);
			}
		}
		List result = proccessExpression(tokens);
		return (Variable) result.get(0);
	}

	
	private List proccessExpression(List tokens) {
//		logger.info("Input: {}" , tokens);
		int sStart = tokens.indexOf(START_B);
		tokens.size();
		int sEnd = tokens.indexOf(END_B);
		if (sStart == -1) {
			if (sEnd == -1) {
				return processSimpleExpression(tokens);
			} else {
				List<String> r = proccessExpression(tokens.subList(0, sEnd - 1));
				return r;
			}
		} else {
			int ssStart = tokens.subList(0, sEnd).lastIndexOf(START_B);
			List<String> r = proccessExpression(tokens.subList(ssStart + 1, sEnd));
			if (ssStart != 0) {
				r.addAll(0, tokens.subList(0, ssStart));

			}
			sEnd = tokens.indexOf(END_B);
			int size = tokens.size();
			if (sEnd < size + 1) {
				r.addAll(tokens.subList(sEnd + 1, tokens.size()));

			}
			return proccessExpression(r);
		}

	}

	private List processSimpleExpression(List tokens) {
		//logger.info("Input:  {}" , tokens);
		if (tokens.size() >= 3) {

			List<Operator> operators = Operator.getPrecedencelist();
			// loop thought all supported operators by precedence
			for (Iterator<Operator> iterator = operators.iterator(); iterator.hasNext();) {
				Operator intOperator = iterator.next();
				String symbol = intOperator.getSymbol();
				// execute all occurrences of this operator in the expression
				int symbolIndex = tokens.indexOf(symbol);
				while ((symbolIndex > 0)) {
//					logger.info(": {}" , tokens);
					Variable left = (Variable) tokens.get(symbolIndex - 1);
					Variable right = (Variable) tokens.get(symbolIndex + 1);
					Variable result = processOperator(left, intOperator, right);
					// replace expression with calculated value
					tokens.remove(symbolIndex + 1);
					tokens.set(symbolIndex, result);
					tokens.remove(symbolIndex - 1);

					symbolIndex = tokens.indexOf(symbol);
				}
			}
		}
		return tokens;
	}

	private Variable processOperator(Variable left, Operator operator, Variable right) {
		// left = replaceBinding(left);
		// right = replaceBinding(right);
		Variable result = operator.applyOp(left, right);
		return result;

	}

}
