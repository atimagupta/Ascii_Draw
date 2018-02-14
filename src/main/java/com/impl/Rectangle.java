package main.java.com.impl;

import main.java.com.domain.Drawing;
import main.java.com.util.CanvasInfo;

/**
 * Created by atima.gupta on 2/13/2018.
 */
public class Rectangle implements Drawing {

    private String command;
    private CanvasInfo canvasInfo = new CanvasInfo();

    public Rectangle(String command) {
        this.command = command;
    }

    @Override
    public void verify() {
        String coordinates[] = command.split(" ");
        if (coordinates.length != 5)
            System.out.print("Invalid Line command");

        if (!canvasInfo.getCanvasInit().isCanvasDrawn()) {
            System.out.print("No canvas present");
            return;
        }

        try {
            int x = Integer.parseInt(coordinates[1]);
            int y = Integer.parseInt(coordinates[2]);
            int x1 = Integer.parseInt(coordinates[3]);
            int y1 = Integer.parseInt(coordinates[4]);

            draw(x, y, x1, y1, 'x');
        } catch (NumberFormatException e) {
            System.out.print("Invalid Line command");
        }
    }

    @Override
    public void draw(int x1, int y1, int x2, int y2, char sym) {
        new Line().draw(x1, y1, x2, y1, sym);
        new Line().draw(x1, y1, x1, y2, sym);
        new Line().draw(x2, y1, x2, y2, sym);
        new Line().draw(x1, y2, x2, y2, sym);
    }
}
