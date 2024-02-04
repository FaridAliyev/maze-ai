package main;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class Program {
    public static void main(String[] args) {
        byte[][] mazeMatrix = Maze.readMaze();
        Point p1 = new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        Point p2 = new Point(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        boolean result = aStar(mazeMatrix, p1, p2);
        System.out.println(result ? "YES" : "NO");
    }

    static boolean aStar(byte[][] maze, Point start, Point end) {
        // return false if starting point is on the wall
        if (maze[start.x()][start.y()] == 1) return false;

        // maps for storing g and f(g+h) values of points
        Map<Point, Integer> g = new HashMap<>();
        Map<Point, Integer> f = new HashMap<>();

        // put the g and f values of the starting point to the maps
        g.put(start, 0);
        f.put(start, Point.h(start, end) + g.get(start));

        // PriorityQueue for processing cells, giving high priority to f value, then h value
        PriorityQueue<Cell> open = new PriorityQueue<>(Comparator.comparing(Cell::getF).thenComparing(Cell::getH));

        // add the starting cell to PriorityQueue
        open.add(new Cell(start, f.get(start), Point.h(start, end)));

        // process the queue until no more cells left
        while (!open.isEmpty()) {
            Cell currentCell = open.poll();
            Point currentPoint = currentCell.p();
            // goal state condition
            if (currentPoint.equals(end)) return true;

            // possible moves
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] dir : directions) {
                // new coordinates
                int newX = currentPoint.x() + dir[0];
                int newY = currentPoint.y() + dir[1];

                // check if the move is possible
                if (isValidMove(maze, newX, newY) && maze[newX][newY] == 0) {
                    // create the new Point and find its g(path cost) and f value
                    Point neighbor = new Point(newX, newY);
                    int tempG = g.get(currentPoint) + 1;
                    int tempF = tempG + Point.h(neighbor, end);

                    // set the g and f value if the point is new, or it has a better f value, then add the cell to the queue
                    if (tempF < f.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                        g.put(neighbor, tempG);
                        f.put(neighbor, tempF);
                        open.add(new Cell(neighbor, tempF, Point.h(neighbor, end)));
                    }
                }
            }
        }
        // no path is found, return false
        return false;
    }

    private static boolean isValidMove(byte[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[x].length;
    }
}
