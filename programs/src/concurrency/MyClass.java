package concurrency;

public class MyClass implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("hey runnable: " +
                Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getId());

        new Thread(new MyClass()).start();

        System.out.println("Main thread not waiting: " + Thread.currentThread().getId());

    }
}
