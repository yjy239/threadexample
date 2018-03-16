package src.sample2;

public class EatThread extends Thread {
	
	private final Table table;
	private int id = 0;
	private volatile boolean shutdown = false;
	
	public EatThread(Table table,String name){
		super(name);
		this.table = table;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//不断消费
		try {
			while(!shutdown){
				String take = table.get();
				System.out.println("eating"+take);
				Thread.sleep(1000);
				
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}finally {
			doShutDown();
		}
	}
	
	public boolean isInterrupted(){
		return shutdown;
	}
	
	//终止处理
	public void doShutDown(){
		System.out.println("doShutDown:"+Thread.currentThread().getName());
	}	
	
	public void shutdown(){
		shutdown = true;
		interrupt();
	}

}
