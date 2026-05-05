import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServicePoc {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    // Code will run after 500ms
    scheduler.schedule(() -> System.out.println("task ran after delay"), 500, TimeUnit.MILLISECONDS);

    var fixedRate = scheduler.scheduleAtFixedRate(
      () -> System.out.println("fixed rate run"),
      0, 300, TimeUnit.MILLISECONDS);

    Thread.sleep(1000);

    // Stops running schedule
    fixedRate.cancel(false);

    // runst like fixed rate, but instead waits 300ms AFTER tasks is finished
    var fixedDelay = scheduler.scheduleWithFixedDelay(
        () -> System.out.println("fixed delay run"),
        0, 300, TimeUnit.MILLISECONDS
    );

    Thread.sleep(1000);
    fixedDelay.cancel(false);

    // shutdown - stops accepting new tasks, but waits for submitted ones to finish
    scheduler.shutdown();
    // shutdownNow() - interrupts all, without waiting and returns a List<Runnable> with tasks that were on queue

    // awaitTermination - blocks main until pool finishes or timeout 
    scheduler.awaitTermination(5, TimeUnit.SECONDS);
  }
}
