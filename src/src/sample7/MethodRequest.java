package src.sample7;

public abstract class MethodRequest {
	protected final Servant servant;
	protected final FutureResult result;
	
	protected MethodRequest(Servant servant,FutureResult result){
		this.servant = servant;
		this.result = result;
	}
	
	protected abstract void excute();
}
