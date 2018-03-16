package src.sample7;

public class ActiveQueue {
	//这个是MethodRequest,不是ActiveObject
	private static final int MAX_METHOD_REQUEST = 100;
	private final MethodRequest[] requests;
	private int tail;
	private int head;
	private int count;
	
	public ActiveQueue(){
		this.requests = new MethodRequest[MAX_METHOD_REQUEST];
		this.head=0;
		this.tail=0;
		this.count=0;
	}
	
	public synchronized void putRequest(MethodRequest request){
		while(count >= MAX_METHOD_REQUEST){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		requests[tail] = request;
		tail = (tail+1)%MAX_METHOD_REQUEST;
		count++;
		notifyAll();
	}
	
	public synchronized MethodRequest takeRequest(){
		while(count<=0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		MethodRequest request = requests[head];
		head = (head+1)%MAX_METHOD_REQUEST;
		count--;
		notifyAll();
		return request;
	}

}
