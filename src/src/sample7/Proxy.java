package src.sample7;

public class Proxy implements ActiveObject{
	
	private final SchedulerThread scheduler;
	private final Servant servant;
	
	public Proxy(SchedulerThread scheduler,Servant servant) {
		// TODO Auto-generated constructor stub
		this.scheduler = scheduler;
		this.servant = servant;
	}
	

	@Override
	public Result makeString(int count, char filter) {
		// TODO Auto-generated method stub
		FutureResult result = new FutureResult();
		scheduler.invoke(new MakingStringRequest(servant, result, count, filter));
		return result;
	}

	@Override
	public void displayString(String string) {
		// TODO Auto-generated method stub
		scheduler.invoke(new DisplayStringRequest(servant, string));
	}

}
