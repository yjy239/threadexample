package src.sample7;

public class Main {
	
	public static void main(String[] args) {
		ActiveObject object = ActiveObjectFactory.createActiveObject();
		
		new MakerThread("Alice", object).start();
		new MakerThread("Boby", object).start();
		new DisplayThread("Cris", object).start();
	}

}
