/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.util.*;

/**
 * It represents a plane whose points are identified by coordinates. Manages the shapes drawn on it and the cursor.
 *
 */
public interface Plane<P extends Point> {

    /**
     * Returns the coordinates of the point where the cursor is.
     *
     * @return the coordinates of the point where the cursor is.
     */
    P getCursorPosition();

    Cursor getCursor();

    /**
     * Rotates the cursor to the left of the given angle.
     * @param angle the angle to rotate the cursor.
     */
    void rotateLeft(int angle);

    /**
     * Rotates the cursor to the right of the given angle.
     * @param angle the angle to rotate the cursor.
     */
    void rotateRight(int angle);

    /**
     * Move the cursor forward of the specified distance.
     *
     * @param distance the distance of the movement.
     */
    void moveForward(double distance);

    /**
     * Move the cursor backward of the specified distance.
     *
     * @param distance the distance of the movement.
     */
    void moveBackward(double distance);

    /**
     * Returns true if a cursor movement will draw a line, false otherwise.
     *
     * @return true if a cursor movement will draw a line, false otherwise.
     */
    boolean isPlot();

    /**
     * Set pen up.
     */
    void penUp();

    /**
     * Set pen down.
     */
    void penDown();

    /**
     * Set the line colour
     *
     * @param colour the background color.
     */
    void setLineColour(Colour colour);

    /**
     * Set the shape colour
     *
     * @param colour the background color.
     */
    void setShapeColour(Colour colour);

    /**
     * Set the background colour
     *
     * @param colour the background color.
     */
    void setBackgroundColour(Colour colour);

    /**
     * Returns the background color.
     *
     * @return the background color.
     */
    Colour getBackgroundColour();

    /**
     * Returns the shapes drawn on the plane.
     *
     * @return the shapes drawn on the plane.
     */
    List<Shape> getShapes();

    /**
     * Move the cursor to the home position.
     */
    void goHome();

    /**
     * Delete all the shapes drawn on the plane.
     */
    void clear();

    /**
     * Sets the pen size.
     * @param size the pen size.
     */
    void setPenSize(int size);

    /**
     * Returns the plane's width.
     * @return the plane's width.
     */
    double getWidth();

    /**
     * Returns the plane's height.
     * @return the plane's height.
     */
    double getHeight();
}
