package main.java.com.impl;

import main.java.com.util.CanvasInfo;

/**
 * Created by atima.gupta on 2/13/2018.
 */
public class BucketFill {

    private String command;
    private CanvasInfo canvasInfo = new CanvasInfo();

    public BucketFill(String command) {
        this.command = command;
    }

    public void verify() {
        String coordinates[] = command.split(" ");
        if (coordinates.length != 4)
            System.out.print("Invalid Line command");

        if (!canvasInfo.getCanvasInit().isCanvasDrawn()) {
            System.out.print("No canvas present");
            return;
        }

        try {
            int x = Integer.parseInt(coordinates[1]);
            int y = Integer.parseInt(coordinates[2]);
            char sym = coordinates[3].charAt(0);
            char oldChar = canvasInfo.getCanvasInit().getPrintArray()[y][x];

            if (oldChar == x)
                fill2(x, y, sym);
            else
                fill(x, y, sym, oldChar);
        } catch (NumberFormatException e) {
            System.out.print("Invalid Line command");
        }
    }

    private void fill(int x, int y, char sym, char oldChar) {
        if (canvasInfo.getCanvasInit().getPrintArray()[y][x] != oldChar) {
            return;
        }

        if (x > 0 || x < canvasInfo.getCanvasInit().getHeight() || y > 0 || y < canvasInfo.getCanvasInit().getWidth()) {
            if (canvasInfo.getCanvasInit().getPrintArray()[y][x] == oldChar)
                canvasInfo.getCanvasInit().getPrintArray()[y][x] = sym;
            fill(x + 1, y, sym, oldChar);
            fill(x - 1, y, sym, oldChar);
            fill(x, y - 1, sym, oldChar);
            fill(x, y + 1, sym, oldChar);
        }
    }

    private void fill2(int x, int y, char sym) {
        if (canvasInfo.getCanvasInit().getPrintArray()[y][x] != 'x') {
            return;
        }

        if (x > 0 || x < canvasInfo.getCanvasInit().getHeight() || y > 0 || y < canvasInfo.getCanvasInit().getWidth()) {
            if (canvasInfo.getCanvasInit().getPrintArray()[y][x] == 'x')
                canvasInfo.getCanvasInit().getPrintArray()[y][x] = sym;
            fill2(x + 1, y, sym);
            fill2(x - 1, y, sym);
            fill2(x, y - 1, sym);
            fill2(x, y + 1, sym);
        }
    }
}
