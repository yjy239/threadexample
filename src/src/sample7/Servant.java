package src.sample7;

public class Servant implements ActiveObject{
	
	

	@Override
	public Result makeString(int count, char filter) {
		// TODO Auto-generated method stub
		char[] buffer = new char[count];
		for(int i=0;i<count;i++){
			buffer[i] = filter;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new RealResult(new String(buffer));
	}

	@Override
	public void displayString(String string) {
		// TODO Auto-generated method stub
		try {
			System.out.println("display: "+string);
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}
