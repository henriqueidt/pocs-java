# Type casting

Type conversion and casting in Java

- Type casting helps making sure that we're not losing data when converting from one type to another
- Make some operations possible that wouldn't happen with different data types
- Helps to make use of the right data type, i.e. using a smaller type for small numbers, instead of large types
- Helps to handle user input, usually text, into numbers to perform calculations

## Widening Type Casting

Convert a lower data type into a higher data type, e.g. `int` to `long`, `float` to `double`
- No risk of data loss
- Used when the two data types are compatible
- Used when the target type is larger than the source type
- `byte -> short -> char -> int -> long -> float -> double`

## Narrowing Type Casting (Casting up / Explicit Type Casting)

Convert a higher data type into a lower data type, e.g. `long` to `int`, `double` to `float`
- It does not happen on its own
- If not done explicitly, will throw a compile-time error
- There is risk of data loss
- `double -> float -> long -> int -> char -> short -> byte`