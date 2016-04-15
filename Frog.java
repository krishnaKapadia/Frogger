/* Code for COMP102 Assignment
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;

import java.awt.*;
import java.awt.geom.AffineTransform;

/** Frog
 *  A new frog starts at the given position, with the given direction, and
 *     has either a "light" or "dark" shade.
 *  Frogs can turn in 4 directions: left, right, up, and down.
 *  Frogs move around at a constant speed in an arena with an enclosing wall,
 *     following its direction, until it hits a wall. In which case it stops moving.
 *  Frog can grow in size, and (for the completion) can also shrink by resetting their size
 *      to the original value.
 *
 *  The walls of the arena are determined by the constants:
 *    FrogGame.TopWall, FrogGame.BotWall, FrogGame.LeftWall and FrogGame.RightWall
 */

public class Frog {
    // Constants
    public static final int INITIAL_SIZE = 30;
    public static final int GROWTH_RATE = 1;
    public static final int SPEED = 2;

    public double x;
    public double y;
    public String dir;
    public String shade;
    public double imageXCenter;
    public double imageYCenter;
    public String image = "";
    //Constructor
    /**
     * Make a new frog
     * The parameters specify the initial position of the top left corner,
     *   the direction, and the shade of the Frog ("light" or "dark")
     * We assume that the position is within the boundaries of the arena
     */
    public Frog(double left, double top, String dir, String shade)  {
        this.x = left;
        this.y = top;
        this.dir = dir.toLowerCase();
        this.shade = shade.toLowerCase();
    }

    public void turnRight(){
        this.dir = "right";

    }

    public void turnLeft(){
        this.dir = "left";
    }

    public void turnUp(){
        this.dir = "up";
    }

    public void turnDown(){
        this.dir = "down";
    }

    /**
     * Moves the frog:
     *   use SPEED unit forward in the correct direction
     *   by changing the position of the frog.
     * Make sure that the frog does not go outside the arena, by making sure
     *  - the top of the frog is never smaller than FrogGame.TopWall
     *  - the bottom of the frog is never greater than FrogGame.BotWall
     *  - the left of the frog is never smaller than FrogGame.LeftWall
     *  - the right of the frog is never smaller than FrogGame.RightWall
     *
     */
    
    public void move() {


        switch (dir.toLowerCase()){
            case "up":
                y -= SPEED;
                dir = "up";
                break;

            case "down":
                y += SPEED;
                dir = "down";
                break;

            case "left":
                x -= SPEED;
                dir = "left";
                break;

            case "right":
                x += SPEED;
                dir = "right";
                break;
        }

        if ( (x <= FrogGame.LeftWall) || (x >= FrogGame.RightWall) ){
            x += 0;

        }else if ((y <= FrogGame.BotWall) || (y >= FrogGame.TopWall)){
            y += 0;

        }
    }

    /**
     * Check whether the frog is touching the given point, eg, whether the
     *   given point is included in the area covered by the frog.
     * Return true if the frog is on the top of the position (x, y)
     * Return false otherwise
     */
    public boolean touching(double x, double y) {
        /*# YOUR CODE HERE */
        boolean isTouching = false;

        if ((this.getX() == x) && (this.getY() == y)){
            return true;
        }else {
            return false;
        }
    }

    public double getY(){
        return this.y;
    }

    public double getX(){
        return this.x;
    }

    /**
     * The Frog has just eaten a bug
     * Makes the frog grow larger by GROWTH_RATE.
     */
    public void grow(){
        /*# YOUR CODE HERE */



    }

    /**
     * The Frog has just bumped into a snake
     * Makes the frog size reset to its original size
     * ONLY NEEDED FOR COMPLETION
     */
    public void shrink(){
        /*# YOUR CODE HERE */

    }

    /**
     * Draws the frog at the current position.
     *
     *NEED TO WORK OUT ROTATION INSTEAD ON SWITCHING IMAGES
     */
    public void draw(){

        if((this.shade).equals("light")){
            switch (this.dir){
                case "Up":
                    image = "src/Images/lightfrogUp.jpg";
                    break;
                case "Down":
                    image = "src/Images/lightfrogDown.jpg";
                    break;
                case "Left":
                    image = "src/Images/lightfrogLeft.jpg";
                    break;
                case "Right":
                    image = "src/Images/lightfrogRight.jpg";
                    break;
                default:
                    image = "src/Images/lightFrogUp.jpg";
            }
        } else {
            switch (this.dir){
                case "Up":
                    image = "src/Images/darkfrogUp.jpg";
                    break;
                case "Down":
                    image = "src/Images/darkfrogDown.jpg";
                    break;
                case "Left":
                    image = "src/Images/darkfrogLeft.jpg";
                    break;
                case "Right":
                    image = "src/Images/darkfrogRight.jpg";
                    break;
                default:
                    image = "src/Images/darkFrogUp.jpg";
            }
        }

        UI.setColor(Color.black);
        UI.drawImage(image, x, y, INITIAL_SIZE, INITIAL_SIZE);

        imageXCenter = INITIAL_SIZE / 2;
        imageYCenter = INITIAL_SIZE / 2;

        //AffineTransform tx = AffineTransform.getRotateInstance(1.5708f, imageXCenter, imageYCenter);

        UI.drawImage(image, x, y, INITIAL_SIZE, INITIAL_SIZE);


    }
}

