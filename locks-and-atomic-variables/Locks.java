import java.util.concurrent.locks.ReentrantLock;

public class Locks {
  public static void main(String[] args) {
    // When multiple threads are working on the same variable,
    // there's no guarantee of which will make changes first
    // that's called race condition

    int[] counter = { 0 };

    // The ReentrantLock serves to give exclusive access to a code section
    // Only one thread can access at a time.
    // It can block all other threads from accessing it with `lock.lock()`
    ReentrantLock lock = new ReentrantLock();

    Runnable increment = () -> {
      for (int i = 0; i < 10; i++) {
        lock.lock();
        try {
          // holdCount stores how many times did the actual thread held the lock
          System.out.println(lock.getHoldCount());
          counter[0]++;  
        } finally {
          // unlock at finally to unlock even if there are exceptions
          lock.unlock();
        }
      }
    };

    Thread t1 = new Thread(increment);
    Thread t2 = new Thread(increment);
    // start creates a new thread and starts to execute it in paralel with main thread
    t1.start();
    t2.start();

    try {
        // makes the acutal (main thread) wait for the thread to finish
        t1.join();
        t2.join();
    } catch (InterruptedException ex) {
        System.out.println(ex);
    }

    System.out.println("counter value is: " + counter[0]);

  }
}
