package testA;

import java.applet.Applet;
import java.awt.*;

public class Test extends Applet {

    private Square square;

    @Override
    public void init() {
        setBackground(Color.BLACK);
        square = new Square(getSize());
    }

    @Override
    public void paint(Graphics graphics) {
        square.draw(graphics);
    }

}
