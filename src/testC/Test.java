package testC;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Test extends Applet implements Runnable {

    List<RandomSquare> randomSquares = new ArrayList<>();

    @Override
    public void init() {
        setBackground(Color.BLUE);

        Dimension dim = getSize();
        for (int i = 0; i < 5; i++) {
            randomSquares.add(new RandomSquare(dim));
        }

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paint(Graphics graphics) {
        for (RandomSquare rs : randomSquares) {
            rs.draw(graphics);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (RandomSquare rs : randomSquares) {
                rs.pulse();
            }

            repaint();
        }
    }
}
