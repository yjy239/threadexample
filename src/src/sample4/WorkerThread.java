package src.sample4;

public class WorkerThread extends Thread {

	private final Channel channel;
	private final String name;
	
	public WorkerThread(String name,Channel channel){
		super(name);
		this.name = name;
		this.channel = channel;
	}
	


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
//			System.out.println("excute");
			Request request = channel.takeRequest();
			request.excute();
		}
	}
}
