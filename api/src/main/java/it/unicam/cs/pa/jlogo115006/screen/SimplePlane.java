/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen;

import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.util.*;

/**
 * A two-dimensional plane that handles the shapes and the cursor
 */
public class SimplePlane implements Plane<SimplePoint> {

    private final List<Shape> shapes;
    private final Cursor cursor;

    private final Point home;

    private Colour backgroundColour;

    private final double width;
    private final double height;

    /**
     * Creates a new plane with the given cursor and white background.
     *
     * @param width  the width of the plane
     * @param height the height of the plane
     */
    public SimplePlane(double width, double height) {
        this(new RGBColour(255, 255, 255), width, height);
    }

    /**
     * Creates a new plane with the given cursor and background colour.
     *
     * @param backgroundColour the background colour
     * @param width the width of the plane
     * @param height           the height of the plane
     */
    public SimplePlane(Colour backgroundColour, double width, double height) {
        this.shapes = new Stack<>();
        this.home = new SimplePoint(width/2, height/2);
        this.cursor = new SimpleCursor(home);
        this.backgroundColour = Objects.requireNonNull(backgroundColour);
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the coordinates of the point where the cursor is.
     *
     * @return the coordinates of the point where the cursor is.
     */
    @Override
    public SimplePoint getCursorPosition() {
        return null; //TODO implement
    }

    /**
     * Rotates the cursor to the left of the given angle.
     *
     * @param angle the angle to rotate the cursor.
     */
    @Override
    public void rotateLeft(int angle) {
        rotateCursor(angle);
    }

    /**
     * Rotates the cursor to the right of the given angle.
     *
     * @param angle the angle to rotate the cursor.
     */
    @Override
    public void rotateRight(int angle) {
        rotateCursor(-angle);
    }

    private void rotateCursor(int angle) {
        this.cursor.rotate(angle);
    }

    /**
     * Move the cursor forward of the specified distance.
     *
     * @param distance the distance of the movement.
     */
    @Override
    public void moveForward(int distance) {

    }

    /**
     * Move the cursor backward of the specified distance.
     *
     * @param distance the distance of the movement.
     */
    @Override
    public void moveBackward(int distance) {

    }

    /**
     * Returns true if a cursor movement will draw a line, false otherwise.
     *
     * @return true if a cursor movement will draw a line, false otherwise.
     */
    @Override
    public boolean isPlot() {
        return this.cursor.getPlot();
    }

    /**
     * Set pen up.
     */
    @Override
    public void penUp() {
        this.cursor.setPlot(false);
    }

    /**
     * Set pen down.
     */
    @Override
    public void penDown() {
        this.cursor.setPlot(true);
    }

    /**
     * Set the line colour
     *
     * @param colour the background color.
     */
    @Override
    public void setLineColour(Colour colour) {
        this.cursor.setLineColour(colour);
    }

    /**
     * Set the shape colour
     *
     * @param colour the background color.
     */
    @Override
    public void setShapeColour(Colour colour) {
        this.cursor.setShapeColour(colour);
    }

    /**
     * Set the background colour
     *
     * @param colour the background color.
     */
    @Override
    public void setBackgroundColour(Colour colour) {
        this.backgroundColour = Objects.requireNonNull(colour);
    }

    /**
     * Returns the background color.
     *
     * @return the background color.
     */
    @Override
    public Colour getBackgroundColour() {
        return this.backgroundColour;
    }

    /**
     * Returns the shapes drawn on the plane.
     *
     * @return the shapes drawn on the plane.
     */
    @Override
    public List<Shape> getShapes() {
        return this.shapes;
    }

    /**
     * Move the cursor to the home position.
     */
    @Override
    public void goHome() {
        this.cursor.setPosition(this.home);
    }

    /**
     * Delete all the shapes drawn on the plane.
     */
    @Override
    public void clear() {
        this.shapes.clear();
    }

    /**
     * Sets the pen size.
     *
     * @param size the pen size.
     */
    @Override
    public void setPenSize(int size) {
        this.cursor.setPenSize(size);
    }

    /**
     * Returns the width of the plane.
     *
     * @return the width of the plane.
     */
    @Override
    public double getWidth() {
        return width;
    }

    /**
     * Returns the height of the plane.
     *
     * @return the height of the plane.
     */
    @Override
    public double getHeight() {
        return height;
    }
}
