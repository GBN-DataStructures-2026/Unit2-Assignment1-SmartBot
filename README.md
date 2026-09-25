# Unit 2 - Assignment 1: Recursive SmartBot

## Overview
In this assignment, you will transition from **iterative logic** (`while` and `for` loops) to **recursive logic** using the Karel J Robot library. You will refactor existing methods in `SmartBot.java` so that they accomplish their goals using base cases and call stack execution instead of loops.

---

## How to Compile and Run

You can run this project using either the VS Code GUI or the integrated terminal.

### Option 1: VS Code GUI (Recommended)
1. Ensure the **Extension Pack for Java** is installed in VS Code.
2. Open `SmartBotDriver.java`.
3. Click the **Play Icon** in the top-right corner, or press `F5`.

### Option 2: Integrated Terminal (Windows)
Because `KarelJRobot.jar` resides in the `lib/` folder, you must explicitly include the classpath (`-cp`) flag when compiling and running from the command line.

Open the integrated terminal in VS Code (`Ctrl + ~`) and run:

```cmd
javac -cp "lib/*;." SmartBot.java SmartBotDriver.java
java -cp "lib/*;." SmartBotDriver
```

---

## Your Task

Open `SmartBot.java` and refactor the following **4 methods** so that they operate completely recursively. You must **remove all `while` and `for` loops** from these methods.

### 1. `pickAll()`
Picks up all beepers present on the current corner.

### 2. `move(int numSteps)`
Moves the robot forward `numSteps` times.

### 3. `findBeeper()`
Moves forward until a beeper is found, picks up the beeper, turns around, and returns to the exact starting position.

### 4. `countPile()`
Picks up all beepers in a pile on the current corner, counts how many were present, restores the exact number of beepers back onto the corner, and returns the total count.

---

## Constraints & Requirements

* **Strictly No Loops:** You may **not** use `while` or `for` loops inside `pickAll`, `move(int)`, `findBeeper`, or `countPile`.
* **State Preservation:** `countPile()` must leave the corner in its original state (with all beepers replaced) when completed.
* **Leverage the Call Stack:** Think carefully about how information, position, and execution order can be managed automatically by the Java call stack during both the *winding* (before recursive call) and *unwinding* (after recursive call) phases.

---

## Troubleshooting & Known Artifacts

* **Closing the GUI Window:** When closing the Karel GUI window after execution finishes, you may see a `java.lang.UnsupportedOperationException` in the terminal referencing `Thread.stop()`. This is a harmless artifact caused by running a legacy library (`KarelJRobot`) on modern Java runtime environments. As long as your robot output prints correctly before closing, your program has executed successfully.
