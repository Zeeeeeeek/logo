/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen;

import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.util.*;
import java.util.logging.Logger;

/**
 * A basic implementation of a cursor.
 */
public class SimpleCursor implements Cursor {

    private final static Logger logger = Logger.getLogger(SimpleCursor.class.getName());

    private int direction;
    private boolean plot;
    private Colour lineColour;
    private Colour shapeColour;

    private int lineSize;

    /**
     * Creates a new cursors in the home position, with the default direction, plot mode and colours.
     *
     */
    public SimpleCursor() {
        this(0, true, new RGBColour(0, 0, 0),
                new RGBColour(255, 255, 255), 1);
    }

    /**
     * Creates a new cursor in the given position with the specified direction, plot mode, colours and line
     * size.
     *
     * @param direction  the direction of the cursor
     * @param plot       the plot mode of the cursor
     * @param lineColour the line colour of the cursor
     * @param shapeColour the area colour of the cursor
     *
     * @throws NullPointerException if any of the colours is null
     * @throws IllegalArgumentException if the line size is less than 1
     */
    public SimpleCursor(int direction, boolean plot, Colour lineColour, Colour shapeColour, int lineSize) {
        this.direction = validateDirection(direction);
        this.plot = plot;
        this.lineColour = Objects.requireNonNull(lineColour);
        this.shapeColour = Objects.requireNonNull(shapeColour);
        this.lineSize = validatePenSize(lineSize);
        logger.info("New cursor successfully created");
    }

    /**
     * Utility method used to normalize the cursor's direction angle.
     * @param direction the direction to be normalized
     * @return the normalized direction
     */
    private int validateDirection(int direction) {
        int angle = direction % 360;
        return angle < 0 ? angle + 360 : angle;
    }

    /**
     * Returns the colour of the area that is coloured when a series of segments produce a closed area.
     *
     * @return the area colour
     */
    @Override
    public Colour getShapeColour() {
        return this.shapeColour;
    }

    /**
     * Returns the colour of the line that is drawn when the cursor moves.
     *
     * @return the line colour
     */
    @Override
    public Colour getLineColour() {
        return this.lineColour;
    }

    /**
     * Return true if cursor movement will draw a line
     *
     * @return true if cursor movement will draw a line, false otherwise
     */
    @Override
    public boolean getPlot() {
        return this.plot;
    }

    /**
     * Return the angle to which the cursor is pointing
     *
     * @return the angle to which the cursor is pointing
     */
    @Override
    public int getDirection() {
        return this.direction;
    }

    /**
     * Return the size of the line that is drawn when the cursor moves.
     *
     * @return the size of the line that is drawn when the cursor moves.
     */
    @Override
    public int getPenSize() {
        return this.lineSize;
    }

    /**
     * Set the pen size to the given value.
     *
     * @param size the new pen size
     */
    @Override
    public void setPenSize(int size) {
        this.lineSize = validatePenSize(size);
    }

    /**
     * Utility method used to validate the pen size.
     * @param size the pen size to be validated
     * @return the passed size if it is greater or equal to 1
     *
     * @throws IllegalArgumentException if the size is less than 1
     */
    private int validatePenSize(int size) {
        if (size < 1) {
            logger.severe("Tried to set pen size to a value less than 1");
            throw new IllegalArgumentException("Pen size must be greater or equal to 1");
        }
        return size;
    }

    /**
     * Set the colour of the area that is coloured when a series of segments produce a closed area.
     *
     * @param colour the area colour
     */
    @Override
    public void setShapeColour(Colour colour) {
        this.shapeColour = Objects.requireNonNull(colour);
    }

    /**
     * Set the colour of the line that is drawn when the cursor moves.
     *
     * @param colour the line colour
     */
    @Override
    public void setLineColour(Colour colour) {
        this.lineColour = Objects.requireNonNull(colour);
    }


    /**
     * Changes the cursor's plot value.
     *
     * @param plot new plot value
     */
    @Override
    public void setPlot(boolean plot) {
        this.plot = plot;
    }

    /**
     * Modify the angle to which the cursor is pointing.
     *
     * @param angle the angle at which modify the direction
     */
    @Override
    public void rotate(int angle) {
        this.direction = validateDirection(this.direction + angle);
    }
}
