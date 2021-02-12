package testD;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
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

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) {
                    for (RandomSquare rs : randomSquares) {
                        rs.setColor(Color.WHITE);
                    }
                    repaint();
                } else if (e.getButton() == 1) {

                    int x = e.getX();
                    int y = e.getY();

                    RandomSquare minDistRs = randomSquares
                            .stream()
                            .min(Comparator.comparing(rs -> rs.getDistanceFromCenter(x, y)))
                            .orElseThrow(NoSuchElementException::new);

                    minDistRs.changeColor();
                }
            }
        });

        TimerTask pulseTask = new TimerTask() {
            @Override
            public void run() {
                for (RandomSquare rs : randomSquares) {
                    rs.pulse();
                }
                repaint();
            }
        };

        Timer timer = new Timer();
        timer.schedule(pulseTask, 1000, 50);
    }

    @Override
    public void paint(Graphics graphics) {
        for (RandomSquare rs : randomSquares) {
            rs.draw(graphics);
        }
    }
}
