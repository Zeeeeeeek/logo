/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

/**
 * Represents a cursor for drawing shapes on a plane.
 */
public interface Cursor {
    /**
     * Returns the colour of the area that is coloured when a series of segments produce a closed area.
     * @return the area colour
     */
    Colour getShapeColor();

    /**
     * Returns the colour of the line that is drawn when the cursor moves.
     * @return the line colour
     */
    Colour getLineColor();

    /**
     * Returns the cursor's position in the plane.
     * @return cursor's position
     */
    Coordinate getPosition();

    /**
     * Return true if cursor movement will draw a line
     * @return true if cursor movement will draw a line, false otherwise
     */
    boolean getPlot();

    /**
     * Return the angle to which the cursor is pointing
     * @return the angle to which the cursor is pointing
     */
    int getDirection();
}
