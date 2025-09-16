# Java Records

- Immutable, read-only data classes;
- Usually used to represent data from a DB Query, records from a service call, data from a csv file, etc.
- Java compiler auto-generates `getter methods`, `toString()`, `hashCode()`, `equals()`.
- The `hashCode()` is always the same for the same data;
- Java compiler also auto-generates a constructor with all the fields as parameters;
- We can also implement our own custom `constructor`