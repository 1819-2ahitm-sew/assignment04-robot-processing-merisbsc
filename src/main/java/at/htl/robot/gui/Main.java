package at.htl.robot.gui;

import at.htl.robot.model.Robot;
import processing.core.PApplet;


public class Main extends PApplet {

    // Hier die Member-Attribute eintragen

    int leftMargin = 70;
    int upperMargin = 120;
    int boxLength = 50;
    boolean isTeleport = false;
    Robot robot;

    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(209); //https://processing.org/tutorials/color/

        robot = new Robot();
        robot.setX(1);
        robot.setY(1);
    }

    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */
    public void draw() {

        textSize(20);
        text("Press f to step forward", leftMargin, 20);
        text("Press l to turn left", leftMargin, 40);
        text("Press m to change Mode", leftMargin, 60);
        text("Current Direction : " + robot.getDirection(), leftMargin, 100);


        fill(255);
        for (int i = 0; i < 11; i++) {
            line(
                    leftMargin,
                    upperMargin + i * boxLength,
                    leftMargin + 10 * boxLength,
                    upperMargin + i * boxLength
            );

            line(
                    leftMargin + i * boxLength,
                    upperMargin,
                    leftMargin + i * boxLength,
                    upperMargin + 10 * boxLength
            );

            int boxCenterX = leftMargin - boxLength / 2 + robot.getX() * boxLength;
            int boxCenterY = upperMargin - boxLength / 2 + robot.getY() * boxLength;

            if (robot.getX() <= 10 && robot.getX() >= 1 && robot.getY() >= 1 && robot.getY() <= 10) {
                ellipse(
                        boxCenterX,
                        boxCenterY,
                        (int) (boxLength * 0.8),
                        (int) (boxLength * 0.8)
                );
            }
        }

        fill(0);
        if (isTeleport) {
            robot.setPositionTeleport();
            text("Current Mode: Teleport", leftMargin, 80);
        } else {
            robot.setPositionRestrict();
            text("Current Mode: Restrict", leftMargin, 80);
        }



    }

    /**
     * Erstellen Sie eine eigene Methode, mittels der der Roboter am Bildschirm gezeichnet wird
     * Die Angabe zu Position des Roboters am Spielfeld erhalten Sie aus dem Roboter-Objekt, welches
     * als Parameter übergeben wird.
     *
     * @param robot Objekt des zu zeichnenden Roboters
     */
    public void drawRobot(Robot robot) {


    }

    /**
     * Erstellen Sie eine eigene Methode zum Löschen des Bildschirms
     */
    public void deleteAll() {
        background(209);
    }

    /**
     * In dieser Methode reagieren Sie auf die Tasten
     */
    public void keyPressed() {
        println("pressed " + key + " " + keyCode);

        if (key == 'f' || key == 'F') {
            deleteAll();
            robot.stepForward();
        } else if (key == 'l' || key == 'L') {
            deleteAll();
            robot.rotateLeft();
        }

        if (key == 'm' || key == 'M') {
            isTeleport = !isTeleport;
        }

    }

//    public void keyTyped() {
//        println("typed " + key + " " + keyCode);
//    }
//
//    public void keyReleased() {
//        println("released " + key + " " + keyCode);
//    }

}
