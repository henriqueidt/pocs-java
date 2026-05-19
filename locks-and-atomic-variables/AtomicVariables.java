
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

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

    counter.compareAndSet(5, 10); // Only changes the value to 10, if current value is 5 (CAS)


    // AtomicReference<T> does the same as AtomicCounter, but changing  an object reference
    AtomicReference<String> ref = new AtomicReference<>("initial value");
    ref.get(); // reads actual value
    ref.set("new value"); // replaces the value

    // A common practice for compareAndSwap is to make an optimistic update

    while (true) { 
        String actual = ref.get();
        String newValue = actual + " updated";

        if(ref.compareAndSet(actual, newValue)) {
          break; // this means it was successfully updated, break the loop
        }
        // if other thread changed before, try again
    }

    // Worth noticing that compareAndSwap uses identity (===), not .equals(),
    // so the below code will always fail, as they are different objects in memory
    AtomicReference<String> ref1 = new AtomicReference<>(new String("abc"));
    ref1.compareAndSet(new String("abc"), "new");
  }
}