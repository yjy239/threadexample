package src.sample2;

public class Table {
	private String[] buffers;
	private int tail; //尾部
	private int head; //头部
	private int count; //数量
	
	public Table(int count){
		buffers = new String[count];
		this.head = 0;
		tail = 0;
		count = 0;
	}
	
	public synchronized void put(String cake){
		System.out.println(Thread.currentThread().getName()+" put "+cake);
		while(count >= buffers.length){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		buffers[tail] = cake;
		tail = (tail+1)%buffers.length;
		count++;
		notifyAll();
	}
	
	
	public synchronized String get(){
		while(count <= 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String cake = buffers[head];
		head = (head+1)%buffers.length;
		count--;
//		System.out.println(Thread.currentThread().getName()+" get "+cake);
		notifyAll();
		return cake;
		
		
	}
}
