package main.java.com;

import main.java.com.domain.Drawing;
import main.java.com.impl.BucketFill;
import main.java.com.impl.Canvas;
import main.java.com.impl.Line;
import main.java.com.impl.Rectangle;
import main.java.com.util.CanvasInfo;
import main.java.com.util.CanvasInit;

import java.util.Scanner;

/**
 * Created by atima.gupta on 2/13/2018.
 */
public class Main {

    public static void main(String args[]) {
        String command = "";
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            command = in.nextLine();
            if (!process(command))
                System.exit(0);
        }
        //if Q is not pressed
        drawToConsole();
    }

    private static boolean process(String command) {
        char type = '\0';
        String commandSuffix = null;
        Drawing drawing = null;

        if (command == null || command.equals(""))
            return true;

        try {
            commandSuffix = command.split(":")[1];
            commandSuffix = commandSuffix.substring(1, commandSuffix.length());
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.print("Invalid command");
            return true;
        }

        type = commandSuffix.charAt(0);

        switch (type) {
            case 'C':
                drawing = new Canvas(commandSuffix);
                drawing.verify();
                break;
            case 'L':
                drawing = new Line(commandSuffix);
                drawing.verify();
                break;
            case 'R':
                drawing = new Rectangle(commandSuffix);
                drawing.verify();
                break;
            case 'B':
                new BucketFill(commandSuffix).verify();
                break;
            case 'Q':
                drawToConsole();
                return false;
        }

        return true;
    }

    private static void drawToConsole() {

        CanvasInit canvasInit = new CanvasInfo().getCanvasInit();

        for (int i = 0; i < canvasInit.getHeight(); i++) {
            for (int j = 0; j < canvasInit.getWidth(); j++) {
                System.out.print(canvasInit.getPrintArray()[i][j]);
            }
            System.out.println();
        }
    }
}
