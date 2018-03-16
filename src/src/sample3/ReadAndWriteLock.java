package src.sample3;

public class ReadAndWriteLock {
	
	private volatile int readingReaders = 0; //正在读取的线程数目
	private volatile int writingWriters = 0;//正在写的线程数
	private volatile int waitingWriters = 0;//正在等待写的线程数
	
	private boolean preferWriter = true;
	
	public synchronized void readLock() throws InterruptedException {
		while(writingWriters>0||(preferWriter && waitingWriters>0)){
			System.out.println(Thread.currentThread().getName()+"read wait "+writingWriters);
			wait();
			System.out.println(Thread.currentThread().getName()+"read waitout"+writingWriters);
		}
		readingReaders++;
	}
	
	public synchronized void readUnLock() throws InterruptedException{
		readingReaders--;
		preferWriter = true;
		notifyAll();
	}
	
	public synchronized void writeLock() throws InterruptedException {
		waitingWriters++;
		try {
			while(readingReaders>0||writingWriters>0){
				System.out.println(Thread.currentThread().getName()+" write wait"+writingWriters);
				wait();
				System.out.println(Thread.currentThread().getName()+"write waitout"+writingWriters);
			}
		} finally {
			// TODO: handle finally clause
			waitingWriters--;
		}
		System.out.println("writing: "+Thread.currentThread().getName());
		writingWriters++;
	}
	
	public synchronized void writeUnLock() throws InterruptedException{
		writingWriters--;
		preferWriter = false;
		System.out.println("writing: out"+Thread.currentThread().getName());
		notifyAll();
	}
	

}
