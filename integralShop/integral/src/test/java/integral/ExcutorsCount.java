package integral;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExcutorsCount {
	
	public static void main(String[] args) throws InterruptedException {
		int threadCount=5;
		ExecutorService excutor = Executors.newFixedThreadPool(threadCount);
		
		int i = 1;
		List<Future> FutureList = new ArrayList<>();
		while(i<=5){
			Count c = new Count(i, 10);
			Future future = excutor.submit(c);
			FutureList.add(future);
			 i++;
		}
		//Thread.currentThread().sleep(1000);
		FutureList.forEach(a->{
			try {
				System.out.println(a.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		excutor.shutdown();
	}
}
