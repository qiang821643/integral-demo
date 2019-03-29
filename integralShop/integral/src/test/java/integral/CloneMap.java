package integral;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CloneMap {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> list = new LinkedList<>();
		list.add("s");
		list.add("sa");
		map.put("a", "c");
		Student st = new Student();
		st.setId("1");
		st.setName("sf");
		st.setPwd("123");
		st.setUserName("qwq");
		st.setHashMap(map);
		st.setList(list);
		Student aa  = (Student) st.clone();
		System.out.println(aa);
		System.out.println(aa.hashCode());
		System.out.println(System.identityHashCode(aa));
		System.out.println(st.hashCode());
		System.out.println(System.identityHashCode(st));	
	}
	
}
