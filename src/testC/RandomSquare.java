package testC;

import java.awt.*;
import java.util.Random;

public class RandomSquare {

    private int a, b;
    private int x, y;
    private Color color;
    private boolean pulseOut;

    public RandomSquare(Dimension dim) {
        Random random = new Random();

        int minA = 10;
        int maxA = Math.min(dim.height, dim.width) / 3;
        a = minA + random.nextInt(maxA - minA);
        b = a;

        x = random.nextInt(dim.width - a);
        y = random.nextInt(dim.height - a);

        color = Color.WHITE;
        pulseOut = false;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(x, y, a, b);
    }

    public void pulse() {
        if (pulseOut == false) {
            y += 1;
            b -= 2;
        } else {
            y -= 1;
            b += 2;
        }

        if (b < 1) {
            pulseOut = true;
        }
        if (b >= a) {
            pulseOut = false;
        }
    }
}
