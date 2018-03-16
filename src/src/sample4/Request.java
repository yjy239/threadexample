package src.sample4;

import java.util.Random;

public class Request {
	
	private final String name;
	private final int number;
	private static final Random random = new Random();
	
	public Request(String name,int number){
		this.name = name;
		this.number = number;
	}
	
	public void excute(){
		System.out.println(Thread.currentThread().getName()+"excute"+this);
		try {
			Thread.sleep(random.nextInt(1000));
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	public String toString(){
		return "[Request from"+name+"No."+number+"]";
	}

}
