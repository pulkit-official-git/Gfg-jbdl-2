package threads;

public class Client {

    public static void doSomething(){
        System.out.println("Doing something "+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName());
//        doSomething();
//        PrintHello task = new PrintHello();
//        Thread thread = new Thread(task,"my-thread");
//        thread.start();
//        task.run();
        for(int i=1; i<=100; i++){
            PrintNumber task = new PrintNumber(i);
            if (i==80){
                System.out.println("hi");
            }
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}


// Define the task that you want to perform (class)
// Runnable
// run()