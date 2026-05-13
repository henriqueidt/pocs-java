
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
  public static void main(String[] args) throws InterruptedException {

    // tryLock doesn't lock the resource indefenitely.
    // It tries to lock in a defined time and "gives up"
    // if can't in the estabilished time

    ReentrantLock lock = new ReentrantLock();

    Thread holder = new Thread(() -> {
      lock.lock();
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      finally {
        lock.unlock();
      }
    });

    holder.start();
    Thread.sleep(50);

    boolean acquired = false;

    try {
      acquired = lock.tryLock(50, TimeUnit.MILLISECONDS);
    } catch (InterruptedException e) {
      System.out.println(e);
    } finally {
      if(acquired) {
        lock.unlock();
      }
    }

    System.out.println("tried to acquire while busy: " + acquired);

    holder.join();
    try {
    acquired = lock.tryLock(50, TimeUnit.MILLISECONDS);
    } catch (InterruptedException e) {
      System.out.println(e);
    } finally {
      if (acquired) {
        lock.unlock();
      }
    }

    System.out.println("tried to acquire when free: " + acquired);
  }
}
