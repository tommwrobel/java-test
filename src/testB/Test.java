package testB;

import testA.Square;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Test extends Applet {

    List<RandomSquare> randomSquares = new ArrayList<>();

    @Override
    public void init() {
        setBackground(Color.BLUE);

        Dimension dim = getSize();
        for (int i = 0; i < 5; i++) {
            randomSquares.add(new RandomSquare(dim));
        }
    }

    @Override
    public void paint(Graphics graphics) {
        for (RandomSquare rq : randomSquares) {
            rq.draw(graphics);
        }
    }

}
