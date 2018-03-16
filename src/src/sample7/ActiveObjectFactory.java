package src.sample7;

public class ActiveObjectFactory {

	public static ActiveObject createActiveObject(){
		Servant servant = new Servant();
		ActiveQueue queue = new ActiveQueue();
		SchedulerThread t = new SchedulerThread(queue);
		t.start();
		Proxy proxy = new Proxy(t, servant);
		return proxy;
	}
	
}
