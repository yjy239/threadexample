package src.sample7;

public class RealResult extends Result {
	
	private final Object result;
	
	public RealResult(Object result) {
		this.result = result;
	}
	
	
	@Override
	public Object getResultValue() {
		// TODO Auto-generated method stub
		return result;
	}
}
