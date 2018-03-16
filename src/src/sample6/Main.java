package src.sample6;

public class Main {
	public static void main(String[] args) {
		System.out.println("MAIN BEGIN");
		try {
			CountUpThread t = new CountUpThread();
			t.start();
			
			Thread.sleep(10000);
			
			System.out.println("shutdown");
			t.shutdownRequest();
			
			System.out.println("MAIN join");
			//意思是等待子线程处理完
			t.join();
			
			System.out.println("END"+t.getState());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("END");
	}
}
