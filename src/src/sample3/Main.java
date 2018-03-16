package src.sample3;

public class Main {
	
	public static void main(String[] args) {
		Data data = new Data(10);
		WriteThread w1 = new WriteThread(data, "Hello");
		w1.start();
		WriteThread w2 = new WriteThread(data, "AAAAA");
		w2.start();
		new ReadThread(data).start();
		new ReadThread(data).start();
//		new ReadThread(data).start();
//		new ReadThread(data).start();
//		new ReadThread(data).start();
//		new ReadThread(data).start();
		
	}

}
