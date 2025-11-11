/*
 * Title: Threads in Java
 * Description: The code includes threads and thread operations in Java using thread class and runnable.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
//Threads are shared memory space operations that can be done simultaneously without waiting for one to completely finish.
//It is a lightweight alternative to multi-processing.
//We can either extend the thread class or use runnable interface.
class Threads1 extends Thread{
	//public void run(String Name) {
		Threads1(String Name){
			super(Name);
			int i=0;
			while(i<1000)
			{System.out.println("Welcome!" + Name);
			i++;}
		}
//		try {
//			sleep(200);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		int i=0;
//		while(i<100)
//		{System.out.println("Good Morning!");
//		i++;}
	}

class Threads2 extends Thread{
		public void run() {
		int i=0;
		while(i<100)
		{System.out.println("Welcome!");
		i++;}
	}
}

//Threads using runnable interface
class ThreadsRun1 implements Runnable{
	//It is compulsory to implement the run() method
	//Although here the method is named run() we need to call start() method while creating an object of the class to actually run this process
 	public void run() {
		int i=0;
		while(i<10)
		System.out.println("This is Thread 2");
		i++;
	}
}

class ThreadsRun2 implements Runnable{
	public void run() {
		int i=0;
		while(i<10)
		System.out.println("This is Thread 2");
		i++;
	}
}

public class Thread_Prac {

	public static void main(String[] args) throws InterruptedException {
		Threads1 t1 = new Threads1("Isha");
		Threads1 t11 = new Threads1("Kia");
		Threads1 t12 = new Threads1("Kylie");
		Threads1 t13 = new Threads1("Khloe");
		Threads1 t14 = new Threads1("Kris");
		//Threads2 t2 = new Threads2();
		t13.setPriority(Thread.MIN_PRIORITY);
		t1.setPriority(Thread.MAX_PRIORITY);
		//All processes start simultaneously and don't want for other
		//start() method to use not run()
		t1.start();
//		t12.start();
//		t13.start();
//		t14.start();
//		t11.start();
		
		//To print one after another is finished
		try {
			t12.join();//allows one thread for completion of another
			Thread.sleep(2000);//passes currently executing thread for specified duration
			t13.join();
			t14.join();
			t14.interrupt();//signals a thread to stop
			System.out.println(Thread.interrupted());//checks of the thread was interrupted
			System.out.println(t14.isAlive());
			t11.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t1.getPriority());//retrieves / setPriority sets the priority of a process
		System.out.println(t14.getState());//retrieves the current state of the thread
		System.out.println(Thread.currentThread());//returns reference to the currently executing thread

		//t2.start();
//		ThreadsRun1 r1 = new ThreadsRun1();
//		Thread t1 = new Thread(r1);
//		t1.start();
//		ThreadsRun2 r2 = new ThreadsRun2();
//		Thread t2 = new Thread(r2);
//		t2.start();
	}

}
