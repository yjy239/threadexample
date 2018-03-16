package src.sample6;

import org.w3c.dom.css.Counter;

public class CountUpThread extends Thread {
	
	private long counter = 0;
	private volatile boolean shutdownRequest = false;
	
	public void shutdownRequest(){
		shutdownRequest = true;
		interrupt();
	}
	
	public boolean isInterrupted(){
		return shutdownRequest;
	}
	
	public void doWork() throws InterruptedException{
		counter++;
		System.out.println(" counter:"+counter);
		Thread.sleep(500);
	}
	
	//÷’÷π¥¶¿Ì
	public void doShutDown(){
		System.out.println("doShutDown: counter="+counter);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!shutdownRequest) {
				doWork();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}finally {
			doShutDown();
		}
		
	}
	
	

}
