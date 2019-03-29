package integral;

/**
 * 简单死锁
 * 来源https://www.cnblogs.com/mudao/p/5867107.html 
 * @author YangTG
 *  线程 1先锁lock1然后在锁lock2,线程2先锁lock2在锁lock1
 *  线程1锁lock1 线程2锁lock2 线程1就没有办法锁lock2,线程2没有办法锁lock1
 */
public class DeadLock {
	
	 static Object lock1 = new Object();
	 static Object lock2 = new Object();
	
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				
				synchronized (lock1){
					System.out.println(Thread.currentThread().getName()+"调用lock1");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(lock2){
						System.out.println(Thread.currentThread().getName()+"调用lock2");
					}
				}
					
				
				
			}
		}).start();
			
		
			new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				
				synchronized (lock2){
					System.out.println(Thread.currentThread().getName()+"调用lock2");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(lock1){
						System.out.println(Thread.currentThread().getName()+"调用lock1");
					}
					
				}
					
				
			}
		}).start();
		
	}
	
}
