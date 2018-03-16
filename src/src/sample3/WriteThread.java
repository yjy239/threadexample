package src.sample3;

import java.util.Random;

public class WriteThread extends Thread {
	
	private static final Random random = new Random();
	
	private final Data data;
	
	private String filter;
	private int index = 0;
	
	public WriteThread(Data data,String filter){
		this.data = data;
		this.filter = filter;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true){
				char c = nextchar();
				data.write(c);
				Thread.sleep(random.nextInt(3000));
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	private char nextchar(){
		char c = filter.charAt(index);
		index++;
		if(index >= filter.length()){
			index = 0;
		}
		return c;
	}
	

}
