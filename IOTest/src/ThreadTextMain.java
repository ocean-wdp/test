import java.io.IOException;

public class ThreadTextMain {
	public static void main(String[] args) throws IOException{
		Thread thread11 = new Thread(new MyThread("1"));
		Thread thread12 = new Thread(new MyThread("2"));
		Thread thread13 = new Thread(new MyThread("3"));
		Thread thread14 = new Thread(new MyThread("4"));
		Thread thread15 = new Thread(new MyThread("5"));
		Thread thread16 = new Thread(new MyThread("6"));
		thread11.start();
		thread12.start();
		thread13.start();
		thread14.start();
		thread15.start();
		thread16.start();
	}
}
