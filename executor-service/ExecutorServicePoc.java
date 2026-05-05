import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServicePoc {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // The ExecutorService is a high-level API that manages a `pool of threads`
        // When submitting tasks, it decides which thread to run them in
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            pool.execute(() -> {
                System.out.println("Task " + taskId + " running on " + Thread.currentThread().getName());
            });
        }


        // Callables<T> are runnable thread tasks that return values
        // Future<T> are handlers for results that aren't yet ready and can be executed later with .get()
        // Calling .get() blocks until the task finishes
        Callable<Integer> task1 = () -> {
            Thread.sleep(100);
            return 100;
        };

        Future<Integer> future1 = pool.submit(task1);

        try {
            System.out.println(future1.get());
        } catch (ExecutionException ex) {
            System.getLogger(ExecutorServicePoc.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }


        // invokeAll - submitts all tasks and blocks until they're all finished
        List<Callable<String>> tasksList = Arrays.asList(
            () -> "result 1",
            () -> "result 2",
            () -> "result 3"
        );

        List<Future<String>> tasksListResults = pool.invokeAll(tasksList);
        System.out.println("INVOKE ALL");
        for (Future<String> f : tasksListResults) {
            System.out.println(f.get());
        }

        



        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
    }
}