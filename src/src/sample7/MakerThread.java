package src.sample7;

public class MakerThread extends Thread{
	
	private final ActiveObject object;
	private final char filchar;
	
	public MakerThread(String name,ActiveObject object) {
		// TODO Auto-generated constructor stub
		super(name);
		this.object = object;
		filchar = name.charAt(0);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i=0;true;i++){
				Result result = object.makeString(i, filchar);
				Thread.sleep(10);
				String value = (String)result.getResultValue();
				System.out.println(Thread.currentThread().getName()+":value ="+value);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	

}
