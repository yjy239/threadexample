package src.sample4;

public class Main {
	
	
	public static void main(String[] args) {
		Channel channel = new Channel(5);
		channel.startWork();
		new ClientThread("Bob", channel).start();
		new ClientThread("Alice", channel).start();
		new ClientThread("Cris", channel).start();
	}
}
