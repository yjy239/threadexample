package src.sample4;

import org.omg.PortableServer.RequestProcessingPolicy;

public class Channel {
	private static final int MAX = 10;
	private final Request[] requests;
	private int tail;
	private int head;
	private int count;
	
	private final WorkerThread[] threadPool;
	
	public Channel(int threads){
		this.requests = new Request[MAX];
		this.head = 0;
		this.tail = 0;
		this.count = 0;
		
		threadPool = new WorkerThread[threads];
		for(int i=0;i<threads;i++){
			threadPool[i] = new WorkerThread("WorkThread-"+i, this);
		}
	}
	
	
	public void startWork(){
		for(int i=0;i<threadPool.length;i++){
			threadPool[i].start();
		}
	}
	
	
	public synchronized void putRequest(Request request){
		//数量为最大值则等待
//		System.out.println("c: "+count);
		while(count>=requests.length){
			try {
				System.out.println("put wait");
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		requests[tail] = request;
		tail = (tail+1)%requests.length;
		count++;
		notifyAll();
	}
	
	public synchronized Request takeRequest(){
		while(count <= 0){
			try {
//				System.out.println("take wait");
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
		
		Request request = requests[head];
		head = (head+1)%requests.length;
		count--;
		notifyAll();
		return request;
	}
	
}
