
public class MyThread implements Runnable {
	private String name;
	public MyThread(String str) {
		this.name=str;
	}
	public void run() {
		System.out.println("name:"+this.name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
