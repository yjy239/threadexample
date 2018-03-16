package src.sample1;

import java.util.LinkedList;

public class RequestQueue {
	
	private final LinkedList<Request> queue = new LinkedList<>();
	
	public RequestQueue(){
		
	}
	
	public synchronized void putRequest(Request request){
		queue.addLast(request);
		System.out.println(Thread.currentThread().getName()+"notify"+queue);
		notifyAll();
	}
	
	public synchronized Request getRequest(){
		while(queue.size() <= 0){
			try {
				System.out.println(Thread.currentThread().getName()+"towait"+queue);
				wait();
				System.out.println(Thread.currentThread().getName()+"waitout"+queue);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
		}
		return (Request)queue.removeFirst();
	}



}
