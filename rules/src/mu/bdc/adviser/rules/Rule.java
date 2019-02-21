package mu.bdc.adviser.rules;

import java.util.ArrayList;
import java.util.List;

import mu.bdc.adviser.engine.dto.Result;
import mu.bdc.adviser.rules.arithmetic.BooleanVariable;
import mu.bdc.adviser.rules.arithmetic.Expression;
import mu.bdc.adviser.rules.arithmetic.Variable;

public class Rule
{
    private List<Expression> expressions;
    private Result result;

    public static class Builder
    {
        private List<Expression> expressions = new ArrayList<>();
        private Result result ;//= new RecommendationDispatcher();

        public Builder withExpression(Expression expr)
        {
            expressions.add(expr);
            return this;
        }

        public Builder withResult(Result result)
        {
            this.result = result;
            return this;
        }

        public Rule build()
        {
            return new Rule(expressions, result);
        }
    }

    private Rule(List<Expression> expressions, Result result)
    {
        this.expressions = expressions;
        this.result = result;
    }

    public Result eval(Bindings bindings) throws BindingNotSetException
    {
        boolean eval = false;
        Result result = null;
        for (Expression expression : expressions)
        {
            Variable evalVar = expression.proccess(bindings);
            if (evalVar instanceof BooleanVariable)
            {
            	eval = (Boolean)evalVar.getValue();
            }
            if (eval)
            {
                result = this.result;
                
            }
        }
        return result;
    }
}
