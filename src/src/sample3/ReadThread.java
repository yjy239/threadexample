package src.sample3;

public class ReadThread extends Thread {
	
	private final Data data;
	
	public ReadThread(Data data){
		this.data = data;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true){
				char[] c = data.read();
				System.out.println(Thread.currentThread().getName()+" read:"+String.valueOf(c));
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}
