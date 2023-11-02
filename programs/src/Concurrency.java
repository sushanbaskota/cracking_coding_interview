import java.util.concurrent.*;

public class Concurrency {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        Future<String> f = ex.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "finished";
        });

        System.out.println(f.get(1, TimeUnit.SECONDS));
    }

}
