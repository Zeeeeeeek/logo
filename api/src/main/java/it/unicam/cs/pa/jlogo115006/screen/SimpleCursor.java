/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen;

import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.util.*;
import java.util.logging.*;

/**
 * A basic implementation of a cursor.
 */
public class SimpleCursor implements Cursor {

    private final static Logger logger = Logger.getLogger(SimpleCursor.class.getName());

    private Point position;
    private int direction;
    private boolean plot;
    private Colour lineColour;
    private Colour shapeColour;

    private int lineSize;

    /**
     * Creates a new cursors in the home position, with the default direction, plot mode and colours.
     *
     * @param home home position of the cursor
     */
    public SimpleCursor(Point home) {
        this(home, 0, true, new RGBColour(0, 0, 0),
                new RGBColour(255, 255, 255));
    }

    /**
     * Creates a new cursor in the given position with the specified direction, plot mode and colours.
     *
     * @param position   the position of the cursor
     * @param direction  the direction of the cursor
     * @param plot       the plot mode of the cursor
     * @param lineColour the line colour of the cursor
     * @param shapeColour the area colour of the cursor
     */
    public SimpleCursor(Point position, int direction, boolean plot, Colour lineColour, Colour shapeColour) {
        this.position = Objects.requireNonNull(position);
        this.direction = validateDirection(direction);
        this.plot = plot;
        this.lineColour = Objects.requireNonNull(lineColour);
        this.shapeColour = Objects.requireNonNull(shapeColour);
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
     * Returns the cursor's position in the plane.
     *
     * @return cursor's position
     */
    @Override
    public Point getPosition() {
        return this.position;
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
        if(size < 1) throw new IllegalArgumentException("Pen size must be greater or equal to 1");
        this.lineSize = size;
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
     * Set the cursor's position in the plane.
     *
     * @param position cursor's position
     */
    @Override
    public void setPosition(Point position) {
        this.position = Objects.requireNonNull(position);
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
