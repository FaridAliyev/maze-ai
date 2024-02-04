# Path finding algorithm implemented using A-Star search

## Prerequisites

Before you run the code, ensure you have met the following requirements:

- Have Java installed on your system.
- The java code is written using `jdk version 17`. Use the same version to prevent potential errors that may arise due to version mismatch.

## How to Run the Code

To run the code on your local machine, follow these steps:

1. **Compile the java code**:
   In the terminal, navigate to the root folder (the folder that contains the `src` folder) and run this command:
   ```sh
   javac src/main/*.java
   ```
2. **Run the program**:
   In the root folder, run the command of this form:
   ```sh
   java -cp src main.Program [arg1] [arg2] [arg3] [arg4]
   ```
   The program expects 4 arguments from the user:
   - The X coordinate of the starting point
   - The Y coordinate of the starting point
   - The X coordinate of the end point
   - The Y coordinate of the end point

  The dimensions of the maze is ***81x81***, so take it into account when entering values.
  
  Here is an example of a working command:
  ```sh
   java -cp src main.Program 1 2 3 39         
   ```
  After running this command you will get one of the two results:
  - **`YES`** if the path exists
  - **`NO`** otherwise



***HAVE FUN TESTING THE CODE :)***
