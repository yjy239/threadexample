package src.sample1;

public class main {
	
	
	public static void main(String[] args) {
		RequestQueue queue = new RequestQueue();
//		ClientThread t2 = new ClientThread(queue, "alice", 2000);
//		t2.start();
		ServerThread t2 = new ServerThread(queue, "boby", 1000);
		t2.start();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(t2.getState());
//		t2.interrupt();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(t2.getState());
//		int i = 0;
//		while(i<=0){
//			System.out.println(i+"in");
//			i = i+1;
//			System.out.println(i+"out");
//		}
	}
}
