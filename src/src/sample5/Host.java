package src.sample5;

public class Host {
	
	public Data request(final int count,final char c){
		System.out.println(" request("+count+","+c+") BEGIN");
		final FutureData futureData = new FutureData();
		//�����Thread-pre �ô����ڿ���Ѹ���õ�FutureData�Ķ��󣬵���Ҫ��ȡ�����RealData�����ݣ���Ҫ�ȴ��߳̽���
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
