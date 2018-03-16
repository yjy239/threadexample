package src.sample1;

import java.util.Random;

public class ServerThread extends Thread{
	
	private Random random;
	private RequestQueue queue;
	
	
	public ServerThread(RequestQueue queue,String name,long seed){
		super(name);
		this.queue = queue;
		this.random = new Random(seed);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<1000;i++){
			Request request = queue.getRequest();
			System.out.println(Thread.currentThread().getName()+" handle"+request);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
