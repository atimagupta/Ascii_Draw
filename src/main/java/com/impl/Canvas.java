package main.java.com.impl;

import main.java.com.domain.Drawing;
import main.java.com.util.CanvasInfo;
import main.java.com.util.CanvasInit;

/**
 * Creat ed by atima.gupta on 2/13/2018.
 */
public class Canvas implements Drawing {

    private String command;
    private CanvasInfo canvasInfo = new CanvasInfo();

    public Canvas(String command) {
        this.command = command;
    }

    @Override
    public void verify() {
        String coordinates[] = command.split(" ");
        if (coordinates.length != 3)
            System.out.print("Invalid Line command");

        try {
            int w = Integer.parseInt(coordinates[1]);
            int h = Integer.parseInt(coordinates[2]);

            draw(w, h, 0, 0, ' ');
        } catch (NumberFormatException e) {
            System.out.print("Invalid Line command");
        }
    }

    @Override
    public void draw(int w, int h, int x2, int y2, char sym) {
        CanvasInit canvasInit = canvasInfo.getCanvasInit();
        h += 2;
        //w += 2;
        canvasInit.setHeight(h);
        canvasInit.setWidth(w);
        canvasInit.initPrintArray(h, w);

        new Line().draw(0, 0, w - 1, 0, '-');
        new Line().draw(0, h - 1, w - 1, h - 1, '-');
        new Line().draw(0, 1, 0, h - 2, '|');
        new Line().draw(w - 1, 1, w - 1, h - 2, '|');
        canvasInit.setCanvasDrawn(true);

    }
}
