package testD;

import java.awt.*;
import java.util.Random;

public class RandomSquare {

    private int a, b;
    private int x, y;
    private Color color;
    private int pulseStep;

    public RandomSquare(Dimension dim) {
        Random random = new Random();

        int minA = 10;
        int maxA = Math.min(dim.height, dim.width) / 3;
        a = minA + random.nextInt(maxA - minA);
        b = a;

        x = random.nextInt(dim.width - a);
        y = random.nextInt(dim.height - a);

        color = Color.WHITE;
        pulseStep = 1;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(x, y, a, b);
    }

    public void pulse() {
        y += pulseStep;
        b -= pulseStep * 2;

        pulseStep = (b < 1 || b >= a) ? -pulseStep : pulseStep;
    }

    public double getDistanceFromCenter(int cx, int cy) {
        int objX = x + a / 2;
        int objY = y + b / 2;

        double distX = Math.abs(objX - cx);
        double distY = Math.abs(objY - cy);

        return Math.sqrt((Math.pow(distX, 2d) + Math.pow(distY, 2d)));
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void changeColor() {
        color = (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }
}
