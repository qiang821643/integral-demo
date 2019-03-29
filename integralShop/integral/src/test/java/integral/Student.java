package integral;


import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Student implements Cloneable{
	
	private String id;
	
	private String name;
	
	private String userName; 
	
	private String pwd;
	
	private Map<String,Object> hashMap;
	
	private List<String> list;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
