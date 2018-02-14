package main.java.com.impl;

import main.java.com.domain.Drawing;
import main.java.com.util.CanvasInfo;


/**
 * Created by atima.gupta on 2/13/2018.
 */

public class Line implements Drawing {

    private String command;
    private CanvasInfo canvasInfo = new CanvasInfo();

    public Line() {
    }

    public Line(String command) {
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

            if (x != x1 && y != y1) {
                System.out.print("only horizontal/vertical line supported");
                return;
            }
            draw(x, y, x1, y1, 'x');
        } catch (NumberFormatException e) {
            System.out.print("Invalid Line command");
        }

    }

    @Override
    public void draw(int x1, int y1, int x2, int y2, char sym) {
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                canvasInfo.getCanvasInit().getPrintArray()[i][j] = sym;
            }
        }
    }
}
