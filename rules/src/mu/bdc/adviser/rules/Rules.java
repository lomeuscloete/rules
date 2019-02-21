package mu.bdc.adviser.rules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mu.bdc.adviser.engine.dto.Result;


public class Rules {

	private List<Rule> rules = new ArrayList<>();

	public void addRule(Rule rule) {
		rules.add(rule);
	}

	public Result eval(Bindings bindings) throws BindingNotSetException {
		Result result = null;
		for (Iterator<Rule> iterator = rules.iterator(); iterator.hasNext();) {
			Rule rule = iterator.next();

			result = rule.eval(bindings);
			if (result != null) {
				return result;
			}

		}
		return result;
	}
}
