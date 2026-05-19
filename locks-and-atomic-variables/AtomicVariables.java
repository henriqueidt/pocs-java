
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariables {
  public static void main(String[] args) {

    // When we do an operation like `counter++`
    // it may seem like only one operation, when in fact there are three:
    // 1. Read `counter` value
    // 2. Sum 1 to `counter`
    // 3. Write it back to `counter`

    // If two threads read the same value before writting,
    // They can both increment same value, adding only one to the counter


    // AtomicVariables ensure atomic operations, indivisible in CPU

    AtomicInteger counter = new AtomicInteger(0);

    counter.incrementAndGet(); // same as counter++, but thread-safe
    counter.getAndIncrement(); // same as before, but returns value before incrementing
    counter.get(); // reads the current value
    counter.set(10); // sets a value directly

    counter.compareAndSet(5, 10); // Only changes the value to 10, if current value is 5
  }
}