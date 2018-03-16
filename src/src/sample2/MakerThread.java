package src.sample2;

public class MakerThread extends Thread {
	
	private final Table table;
	private int id = 0;
	private volatile boolean shutdown = false;
	public MakerThread(Table table,String name){
		super(name);
		this.table = table;
	
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//不断的生产
		try {
			while(!shutdown){
//				Thread.sleep(1000);
				String cake = "["+"No."+nextid()+"by"+Thread.currentThread().getName()+"]";
				table.put(cake);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			doShutDown();
		}
		
	}
	
	private int nextid(){
		return id++;
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
