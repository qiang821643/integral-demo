package integral;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;


public class Count implements Callable<List<String>>{
	private int taskNum;
	private int number;
	
	public Count(int taskNum,int number){
		this.taskNum=taskNum;
		this.number=number;
	}
	
	@Override
	public List<String> call() throws Exception {
		System.out.println("启动任务序号:"+taskNum);
		Date date1 = new Date();
		List<String> list = new ArrayList<String>();
		
			 int sum=0;
				for(int i = 0;i<=number;i++){
					sum+=i;
					System.out.println("任务序号:"+taskNum+"number:"+number);
				}
				list.add(String.valueOf(sum));
		
		 
		
			
		System.out.println("当前任务序号:"+taskNum+"输出:"+number);
		Date date2 = new Date();
		long time = date2.getTime()-date1.getTime();
		System.out.println("任务结束序号"+taskNum);
		
		
		list.add(String.valueOf(time));
		
		return list;
	}

}
