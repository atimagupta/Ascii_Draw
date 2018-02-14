package main.java.com.util;

/**
 * Created by atima.gupta on 2/14/2018.
 */
public class CanvasInit {
    private boolean isCanvasDrawn;
    private int width = 0;
    private int height = 0;
    private char printArray[][];

    private static CanvasInit canvasInit = new CanvasInit();

    private CanvasInit() {
    }

    public static CanvasInit getCanvasInstance() {
        return canvasInit;
    }

    public boolean isCanvasDrawn() {
        return isCanvasDrawn;
    }

    public void setCanvasDrawn(boolean canvasDrawn) {
        this.isCanvasDrawn = canvasDrawn;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getPrintArray() {
        return printArray;
    }

    public void setPrintArray(char[][] printArray) {
        this.printArray = printArray;
    }

    public void initPrintArray(int x, int y) {
        printArray = new char[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                printArray[i][j] = ' ';
            }
        }
    }
}
