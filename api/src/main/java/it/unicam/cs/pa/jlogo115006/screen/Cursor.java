/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen;

import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

/**
 * Represents a cursor for drawing shapes on a plane.
 */
public interface Cursor {
    /**
     * Returns the colour of the area that is coloured when a series of segments produce a closed area.
     *
     * @return the area colour
     */
    Colour getShapeColour();

    /**
     * Returns the colour of the line that is drawn when the cursor moves.
     *
     * @return the line colour
     */
    Colour getLineColour();

    /**
     * Returns the cursor's position in the plane.
     *
     * @return cursor's position
     */
    Point getPosition();

    /**
     * Return true if cursor movement will draw a line
     *
     * @return true if cursor movement will draw a line, false otherwise
     */
    boolean getPlot();

    /**
     * Return the angle to which the cursor is pointing
     *
     * @return the angle to which the cursor is pointing
     */
    int getDirection();

    /**
     * Return the size of the line that is drawn when the cursor moves.
     * @return the size of the line that is drawn when the cursor moves.
     */
    int getPenSize();

    /**
     * Set the pen size to the given value.
     * @param size the new pen size
     */
    void setPenSize(int size);

    /**
     * Set the colour of the area that is coloured when a series of segments produce a closed area.
     *
     * @param colour the area colour
     */
    void setShapeColour(Colour colour);

    /**
     * Set the colour of the line that is drawn when the cursor moves.
     *
     * @param colour the line colour
     */
    void setLineColour(Colour colour);

    /**
     * Set the cursor's position in the plane.
     *
     * @param position cursor's position
     */
    void setPosition(Point position);

    /**
     * Changes the cursor's plot value.
     *
     * @param plot new plot value
     */
    void setPlot(boolean plot);

    /**
     * Modify the angle to which the cursor is pointing.
     *
     * @param angle rotation angle
     */
    void rotate(int angle);
}