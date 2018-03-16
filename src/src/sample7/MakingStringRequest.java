package src.sample7;

public class MakingStringRequest extends MethodRequest{
	
	private final int count;
	private final char filter;

	protected MakingStringRequest(Servant servant, FutureResult result,int count,char filter) {
		super(servant, result);
		// TODO Auto-generated constructor stub
		this.count = count;
		this.filter = filter;
		
	}

	@Override
	protected void excute() {
		// TODO Auto-generated method stub
		Result r = servant.makeString(count, filter);
		result.setResult(r);
	}

}
