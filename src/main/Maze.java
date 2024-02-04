package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class Maze {

    // reads the maze matrix from the maze.txt file under the resources folder
    static byte[][] readMaze() {
        byte[][] mazeMatrix = new byte[81][81];

        try (BufferedReader br = new BufferedReader(new FileReader(Paths.get("src", "resources", "maze.txt").toString()))) {
            String line;
            int row = 0;

            while ((line = br.readLine()) != null && row < 81) {
                String[] columns = line.split(" ");
                for (int col = 0; col < columns.length; col++) {
                    mazeMatrix[row][col] = Byte.parseByte(columns[col]);
                }
                row++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return mazeMatrix;
    }
}
