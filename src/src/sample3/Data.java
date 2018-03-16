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
		//刚才出问题是因为读的时间太长500ms，这个时候，写虽然没有写完，但是在dowrite的过程中，锁已经被解开了
		//虽然过程中write的
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
