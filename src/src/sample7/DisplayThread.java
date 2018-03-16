package src.sample7;

public class DisplayThread extends Thread{
	
	private final ActiveObject object;
	
	public DisplayThread(String name,ActiveObject object) {
		// TODO Auto-generated constructor stub
		super(name);
		this.object = object;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i=0;true;i++){
				String s = Thread.currentThread().getName()+" "+i;
				object.displayString(s);
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}
