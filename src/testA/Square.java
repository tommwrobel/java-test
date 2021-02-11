package testA;

import java.awt.*;

public class Square {

    private Color color;
    private Dimension dimension;
    private int x, y;

    public Square(Dimension dim) {
        this.color = Color.WHITE;
        this.dimension = new Dimension(50, 50);
        this.x = dim.width / 2 - 25;
        this.y = dim.height / 2 - 25;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(x, y, dimension.width, dimension.height);
    }
}
