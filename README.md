# Unit 2 - Assignment 1: Recursive SmartBot

## Overview
In this assignment, you will transition from **iterative logic** (`while` and `for` loops) to **recursive logic** using Karel J Robot. You will refactor existing methods in `SmartBot.java` so that they accomplish their goals using base cases and recursive call stacks instead of loops.

---

## One-Time Setup Requirement
Before running this project, ensure you have the **Extension Pack for Java** installed in VS Code:
1. Open the **Extensions** tab on the left sidebar (`Ctrl+Shift+X` or `Cmd+Shift+X`).
2. Search for **Extension Pack for Java** (published by Microsoft) and click **Install**.

---

## How to Run the Project
1. Open the project folder in VS Code (`File > Open Folder...`).
2. Open `SmartBotDriver.java`.
3. Click the **Run** button (play icon) in the top-right corner, or press `F5`.
4. A Java GUI window will launch displaying Karel's world and robot execution.

---

## Your Task

Open `SmartBot.java` and refactor the following **4 methods** to be completely recursive. You must **remove all `while` and `for` loops** from these methods:

### 1. `pickAll()`
* **Iterative Goal:** Picks up all beepers on the current corner.
* **Recursive Logic:**
  * **Base Case:** If `!nextToABeeper()`, do nothing.
  * **Recursive Step:** Pick one beeper, then call `pickAll()` again.

### 2. `move(int numSteps)`
* **Iterative Goal:** Moves forward `numSteps` times.
* **Recursive Logic:**
  * **Base Case:** If `numSteps <= 0`, do nothing.
  * **Recursive Step:** Move forward once, then recursively call `move(numSteps - 1)`.

### 3. `findBeeper()`
* **Iterative Goal:** Moves forward until finding a beeper, picks it up, turns around, and moves back to the starting point.
* **Recursive Logic:**
  * **Winding Phase (Stack Pushes):** If `!nextToABeeper()`, move forward and recursively call `findBeeper()`.
  * **Base Case (Target Reached):** When next to a beeper, turn around and pick up the beeper.
  * **Unwinding Phase (Stack Pops):** Execute `move()` *after* the recursive call returns to step backward along the call stack toward home.

### 4. `countPile()`
* **Iterative Goal:** Picks up a pile of beepers, counts how many were on the corner, puts all beepers back, and returns the total count.
* **Recursive Logic:**
  * **Base Case:** If `!nextToABeeper()`, return `0`.
  * **Recursive Step:** Pick up one beeper, compute `int count = 1 + countPile()`, put the beeper back down on the corner, and return `count`.

---

## Constraints
* **No Loops:** You may **not** use `while` or `for` loops inside `pickAll`, `move(int)`, `findBeeper`, or `countPile`.
* **Preserve State:** `countPile()` must leave the original number of beepers on the corner when finished.
* **Call Stack Execution:** Pay close attention to actions that occur **before** a recursive call (winding) versus actions that occur **after** a recursive call (unwinding).
