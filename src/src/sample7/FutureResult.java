package src.sample7;

public class FutureResult extends Result{
	
	private Result result;
	private boolean ready = false;
	
	public synchronized void setResult(Result result) {
		this.result = result;
		this.ready = true;
		notifyAll();
	}
	
	
	
	@Override
	public synchronized Object getResultValue() {
		// TODO Auto-generated method stub
		try {
			while(!ready){
				wait();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		
		return result.getResultValue();
	}
}
