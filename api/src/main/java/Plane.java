/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

import java.util.*;

/**
 * It represents a plane whose points are identified by coordinates. Manages the shapes drawn on it and the cursor.
 */
public interface Plane<Coordinate> {
    /**
     * Returns the coordinate of the point where the cursor is.
     *
     * @return the coordinate of the point where the cursor is.
     */
    Coordinate getCursorCoordinate();

    /**
     * Rotate the cursor of the specified angle.
     *
     * @param angle the angle of rotation.
     */
    void rotateCursor(int angle);

    /**
     * Move the cursor forward of the specified distance.
     *
     * @param distance the distance of the movement.
     */
    void moveForward(int distance);

    /**
     * Move the cursor backward of the specified distance.
     *
     * @param distance the distance of the movement.
     */
    void moveBackward(int distance);

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
    void setLineColor(Colour colour);

    /**
     * Set the shape colour
     *
     * @param colour the background color.
     */
    void setShapeColor(Colour colour);

    /**
     * Set the background colour
     *
     * @param colour the background color.
     */
    void setBackgroundColor(Colour colour);

    /**
     * Returns the background color.
     *
     * @return the background color.
     */
    Colour getBackgroundColor();

    /**
     * Returns the shapes drawn on the plane.
     *
     * @return the shapes drawn on the plane.
     */
    List<Shape> getShapes();

}
