package main;

public record Cell(Point p, int f, int h) {
    Point getP() {
        return p;
    }

    int getF() {
        return f;
    }

    int getH() {
        return h;
    }
}
