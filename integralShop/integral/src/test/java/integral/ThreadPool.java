package integral;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池状态
 * 1 runing  线程正在执行中
 * 2 shutingDown  线程池正在关闭中,优雅关闭(线程不再接收新的任务,处理已经接收的任务)
 * 3 terminated  线程池关闭
 * 
 * Executors是顶层类,是执行线程的工具
 * 进程级的重量资源,默认线程池的生命周期和jvm一致.开启后,直到jvm关闭为止
 * shutdown可以关闭线程池,
 * shutdownNow()：立即终止线程池并尝试打断正在执行的任务，并且清空任务缓存队列，返回尚未执行的任务
 * ExecutorService继承了Excutors,ExecutorService是真正的线程池接口
 * ThreadPoolExecutor是ExecutorService的默认实现
 * @author YangTG
 *
 */
public class ThreadPool {
	
	
	   /**
     * 线程池初始化方法
     *
     * corePoolSize 核心线程池大小----1
     * maximumPoolSize 最大线程池大小----3
     * keepAliveTime 线程池中超过corePoolSize数目的空闲线程最大存活时间----30+单位TimeUnit
     * TimeUnit keepAliveTime时间单位----TimeUnit.MINUTES
     * workQueue 阻塞队列----new ArrayBlockingQueue<Runnable>(5)==== 5容量的阻塞队列
     * threadFactory 新建线程工厂----new CustomThreadFactory()====定制的线程工厂
     * rejectedExecutionHandler 当提交任务数超过maxmumPoolSize+workQueue之和时,
     * 							即当提交第9个任务时(前面线程都没有执行完,此测试方法中用sleep(100)),
     * 						          任务会交给RejectedExecutionHandler来处理
     */
 

	
	
	public static void main(String[] args) {
		/*ThreadPool pool = new ThreadPool();
		try {
			pool.simpleThreadPool();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	
	/**
	 * 单线程池,单线程执行所有任务,如果这个线程异常结束会有心的线程替代它
	 * 这个线程保证线程执行顺序是按照认为提交顺序执行
	 * 场景:保证任务顺序执行,秒杀
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public void simpleThreadPool() throws InterruptedException, ExecutionException{
		
		ExecutorService excutor = Executors.newSingleThreadExecutor();
		excutor.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				System.out.println(Thread.currentThread().getState());
				
			}
		});
		//excutor.shutdown();
		System.out.println("是否关闭:"+excutor.isShutdown());
		System.out.println("是否Terminated："+excutor.isTerminated());
		
		//关闭线程池后,不能在执行线程池
		/*excutor.execute(new Runnable() {
			@Override
			public void run() {
				
				System.out.println("shutdown在执行线程池:"+Thread.currentThread().getName());
			}
		});*/
		
		Future<String> future = excutor.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return Thread.currentThread().getName();
			}
		});
		System.out.println(future);
		System.out.println("futur.isDone():"+future.isDone());//查看任务是否执行结束
		System.out.println("future.get():"+future.get());//获取call的返回值
		System.out.println("futur.isDone():"+future.isDone());
	}
	
	/**
	 * 创建一个固定大小的线程池
	 * 每次提交一个认为就会创建一个线程,直到达到线程池最大大小.如果某个线程异常结束,
	 * 那么线程池会补充一个新的线程
	 * 使用的是LinkedBlockingQueue<Runnable>作为任务载体,任务数量大于线程池的数量时候
	 * 没有运行的任务保存在队列里,当有空闲的线程时候,会从队列里去出来
	 * 使用场景:大多数使用的场景首选，os系统的线程数量有限
	 * 一般pc 线程数100 服务器:1000-5000
	 * 并发能力 线程*10到18之间
	 */
	public void fixedThreadPool(){
		
		ExecutorService excutor = Executors.newFixedThreadPool(4);
			 
		 
	}
	
	
	/**
	 * 可以缓冲的线程池,没有上限,自动扩容
	 * 容量管理策略 
	 * 如果线程池大小超过了当前任务所需的线程,就会回收部分空闲线程
	 * 当任务增加后,会智能添加新线程来处理任务。
	 * 此线程池不会限定大小,会依赖当前操作系统能够创建最大线程数
	 * 场景：内部应用,内部数据瞬间处理。测试应用：尝试硬件或者软件的最高负载量
	 */
	public void cachadThreadPool(){
		
		ExecutorService excutor = Executors.newCachedThreadPool();
		excutor.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	/**
	 * 创建大小不限的线程池.这个线程支持定时和周期性任务
	 * 阻塞,效率低下
	 * 场景 :计划任务,数据整理
	 */
	public void scheduleThreadPool(){
		
		ExecutorService excutor = Executors.newScheduledThreadPool(1);
	}
}
