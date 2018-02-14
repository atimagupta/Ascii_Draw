package main.java.com.util;

/**
 * Created by atima.gupta on 2/13/2018.
 */

public class CanvasInfo {
    private CanvasInit canvasInit;

    public CanvasInit getCanvasInit() {
        return CanvasInit.getCanvasInstance();
    }

    public void setCanvasInit(CanvasInit canvasInit) {
        this.canvasInit = canvasInit;
    }
}
