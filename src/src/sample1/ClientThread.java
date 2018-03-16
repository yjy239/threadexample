package src.sample1;

import java.util.Random;

public class ClientThread extends Thread {
	
	private Random random;
	private RequestQueue queue;
	
	public ClientThread(RequestQueue queue,String name,long seed){
		super(name);
		this.queue = queue;
		this.random = new Random(seed);
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<1000;i++){
			
			Request request = new Request("No."+i);
			System.out.println(Thread.currentThread().getName()+"request: "+request.toString());
			queue.putRequest(request);
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
		}
	}
	

}
