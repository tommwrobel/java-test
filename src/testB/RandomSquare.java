package testB;

import java.awt.*;
import java.util.Random;

public class RandomSquare {

    private int a;
    private int x, y;
    private Color color;

    public RandomSquare(Dimension dim) {
        Random random = new Random();

        int minA = 10;
        int maxA = Math.min(dim.height, dim.width) / 3;
        a = minA + random.nextInt(maxA - minA);

        x = random.nextInt(dim.width - a);
        y = random.nextInt(dim.height - a);

        color = Color.WHITE;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(x, y, a, a);
    }
}
