package mu.bdc.adviser.rules;

import java.util.HashMap;
import java.util.Map;

public class Bindings {
	private Map<String, String> bindings;

	public Bindings(Map<String, String> bindings) {
		this.bindings = bindings;
	}
	
	public Bindings() {
		
		this.bindings =  new HashMap<String,String>();
	}
	public String getValue(String  name)
	{
		String value = bindings.get(name);
		return value;
	}
	public void put(String key, String value)
	{
		this.bindings.put(key, value);
	}
}