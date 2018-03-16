package src.sample5;

public class Host {
	
	public Data request(final int count,final char c){
		System.out.println(" request("+count+","+c+") BEGIN");
		final FutureData futureData = new FutureData();
		//这个是Thread-pre 好处在于可以迅速拿到FutureData的对象，但是要获取里面的RealData的内容，需要等待线程解锁
		new Thread(){
			public void run() {
				RealData data = new RealData(count, c);
				futureData.setRealData(data);
			};
		}.start();
		
		System.out.println(" request("+count+","+c+") END");
		
		return futureData;
		
	}

}
