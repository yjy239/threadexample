package src.sample3;

import javax.management.DescriptorRead;

public class Data {
	
	private final char[] buffer;
	private final ReadAndWriteLock lock = new ReadAndWriteLock();
	
	public Data(int size){
		buffer = new char[size];
		for(int i=0;i<size;i++){
			buffer[i] = '*';
		}
	}
	
	public char[] read() throws InterruptedException{
		lock.readLock();
		try{
			return doRead();
		}finally {
			lock.readUnLock();
		}
		
	}
	
	private char[] doRead(){
		char[] newbuff = new char[buffer.length];
		for(int i=0;i<buffer.length;i++){
			newbuff[i] = buffer[i];
		}
		//�ղų���������Ϊ����ʱ��̫��500ms�����ʱ��д��Ȼû��д�꣬������dowrite�Ĺ����У����Ѿ����⿪��
		//��Ȼ������write��
		slowly();
		return newbuff;
	}
	
	public void write(char c) throws InterruptedException{
		lock.writeLock();
		try {
			doWrite(c);
		} finally {
			// TODO: handle finally clause
			lock.writeUnLock();
		}
	}
	
	private void doWrite(char c){
		for(int i=0;i<buffer.length;i++){
			buffer[i] = c;
			slowly();
		}
		
	}
	
	private void slowly(){
		try {
			Thread.sleep(50);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
