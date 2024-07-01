package in.cdac.thread;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        System.out.println("I am the main class");
	        ScalerThread adderThread=new ScalerThread(new Adder());
	        adderThread.start();
	        ScalerThread subThread=new ScalerThread(new Subtractor());
	        subThread.start();    
//	        Thread t1=new Thread()
	    
	}

}
