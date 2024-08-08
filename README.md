## Files Description

### `Calculator.java`
This file defines the remote interface for the calculator service. It declares the following methods:
- `void pushValue(int val)`: Pushes a value onto the stack.
- `void pushOperation(String operator)`: Pushes an operator ("min", "max", "lcm", "gcd") onto the stack, causing the server to pop all values and perform the corresponding operation.
- `int pop()`: Pops the top value from the stack and returns it.
- `boolean isEmpty()`: Returns true if the stack is empty, false otherwise.
- `int delayPop(int millis)`: Waits for the specified milliseconds before performing the pop operation.

### `CalculatorImplementation.java`
This file provides the implementation of the `Calculator` interface. It includes methods to handle the stack operations and perform the required calculations:
- The stack is maintained using a `Stack<Integer>`.
- The `pushValue` and `pushOperation` methods are synchronized to handle concurrent access.
- The `pushOperation` method includes the logic for "min", "max", "lcm", and "gcd" operations.

### `CalculatorServer.java`
This file contains the server class which:
- Starts the RMI registry on port 1099.
- Creates an instance of `CalculatorImplementation`.
- Binds the `CalculatorImplementation` instance to the RMI registry with the name `CalculatorService`.

### `CalculatorClient.java`
This file contains a simple test client which:
- Connects to the `CalculatorService` on the RMI server.
- Pushes values and operations onto the stack.
- Pops and prints the result of the operations.
