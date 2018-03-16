package src.sample7;

public class SchedulerThread extends Thread {
	
	
	private final  ActiveQueue queue;
	
	public SchedulerThread(ActiveQueue queue) {
		// TODO Auto-generated constructor stub
		this.queue = queue;
	}
	
	public void invoke(MethodRequest request){
		queue.putRequest(request);
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			MethodRequest request = queue.takeRequest();
			request.excute();
		}
	}

}
