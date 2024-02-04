package main;

public record Point(int x, int y) {
    // calculates Manhattan distance between two points
    static int h(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
