package src.sample2;

public class Main {
	
	public static void main(String[] args) {
		Table table = new Table(3);
		MakerThread m1 = new MakerThread(table, "maker1");
		m1.start();
		MakerThread m2 = new MakerThread(table, "maker2");
		m2.start();
		EatThread e1 = new EatThread(table, "eater1");
		e1.start();
		EatThread e2 = new EatThread(table, "eater2");
		e2.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m1.shutdown();;
		m2.shutdown();
		e1.shutdown();
		e2.shutdown();
		System.out.println("end"+m1.getState());
	}

}
