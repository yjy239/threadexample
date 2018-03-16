package src.sample5;

public class FutureData implements Data {
	
	private RealData data = null;
	private boolean ready = false;
	
	public synchronized void setRealData(RealData data){
		if(ready){
			return;//balkģʽ���ٽ�ֵ����ȷ��ִ��
		}
		this.data = data;
		this.ready = true;
		notifyAll();
	}
	
	
	@Override
	public synchronized String getContent() {
		// TODO Auto-generated method stub
		while (!ready) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
			}
		}
		return data.getContent();
	}

}
