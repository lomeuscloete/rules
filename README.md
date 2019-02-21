# rules
A java library that can be used to build a rules engine I extracted it from an adviser I build for a client. It probaly need some work to be used standalone.

it supports basic logical and arithmetic expressions for integer and string types, this can be estended to more types.

#usage:
    Expression expression = new Expression("#BIG > 555 * ( #SMALL + 34 )");
		Bindings bindings = new Bindings();
		bindings.put("BIG", "999999");
		bindings.put("SMALL", "3");
		Variable<?> value;
		try {
			value = expression.proccess(bindings);
			System.out.println("result = " + value.getValue());
		} catch (BindingNotSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
