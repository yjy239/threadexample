package src.sample7;

public class DisplayStringRequest extends MethodRequest{
	
	private final String string;
	
	protected DisplayStringRequest(Servant servant, String s) {
		super(servant, null);
		// TODO Auto-generated constructor stub
		this.string =s;
		
		
	}

	@Override
	protected void excute() {
		// TODO Auto-generated method stub
		servant.displayString(string);
	}

}
