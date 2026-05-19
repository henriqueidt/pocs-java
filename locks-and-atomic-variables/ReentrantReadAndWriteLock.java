
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadAndWriteLock {
  public static void main(String[] args) throws InterruptedException {
    // ReentrantLock solves a problem of ReentrantLock
    // ReentrantLock blocks every access for everybody
    // But simultaneous reads don't need to block each other

    // ReentrantReadWriteLock lets multiple threads read at the same time
    // But still only one can write, and noone can read while it is writting

    ReentrantReadWriteLock rWriteLock = new ReentrantReadWriteLock();

    Map<String, String> map = new HashMap<>();

    map.put("language", "java");

    Runnable reader = () -> {
      rWriteLock.readLock().lock();
      try {
          System.out.println(Thread.currentThread().getName() + " reading: " + map.get("language"));
      } finally {
        rWriteLock.readLock().unlock();
      }
    };

    Runnable writter = () -> {
      rWriteLock.writeLock().lock();
      try {
        map.put("language", "typescript");
        System.out.println(Thread.currentThread().getName() + " writting: Typescript");
      } finally {
        rWriteLock.writeLock().unlock();
      }
    };

    Thread t1Thread = new Thread(reader, "reader-1");
    Thread t2Thread = new Thread(reader, "reader-2");
    Thread t3Thread = new Thread(writter, "writter-1");

    t1Thread.start();
    t2Thread.start();
    t3Thread.start();

    t1Thread.join();
    t2Thread.join();
    t3Thread.join();
  }
}
