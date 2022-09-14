/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen;

import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.*;

/**
 * A two-dimensional plane that handles the shapes and the cursor
 */
public class SimplePlane implements Plane<SimplePoint> {

    private final static Logger logger = Logger.getLogger(SimplePlane.class.getName());

    private final List<Shape> shapes;
    private final Cursor cursor;

    private final SimplePoint homePoint;
    private SimplePoint cursorPosition;

    private Colour backgroundColour;

    private final double width;
    private final double height;

    /**
     * Creates a new plane with the given width and height, with default background colour and default cursor.
     *
     * @param width  the width of the plane
     * @param height the height of the plane
     */
    public SimplePlane(double width, double height) {
        this(new RGBColour(255, 255, 255), width, height,
                new SimpleCursor(), new SimplePoint(width / 2, height / 2));
    }

    /**
     * Creates a new plane based on the specified parameters.
     *
     * @param backgroundColour the screen background colour
     * @param width            the screen width
     * @param height           the screen height
     * @param cursor           the cursor used in the plane
     * @param cursorPosition   the cursor position
     */
    public SimplePlane(Colour backgroundColour, double width, double height, Cursor cursor, SimplePoint cursorPosition) {
        this.width = requirePositive(width);
        this.height = requirePositive(height);
        this.shapes = new ArrayList<>();
        this.homePoint = new SimplePoint(width / 2, height / 2);
        this.cursor = Objects.requireNonNull(cursor);
        this.backgroundColour = Objects.requireNonNull(backgroundColour);
        this.cursorPosition = Objects.requireNonNull(cursorPosition);
        logger.info("New simple plane successfully created");
    }

    private double requirePositive(double value) {
        if (value <= 0) throw new IllegalArgumentException("Value must be positive");
        return value;
    }

    /**
     * Returns the coordinates of the point where the cursor is.
     *
     * @return the coordinates of the point where the cursor is.
     */
    @Override
    public SimplePoint getCursorPosition() {
        return this.cursorPosition;
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
        logger.info("Rotating cursor of " + angle + " degrees");
        this.cursor.rotate(angle);
    }

    /**
     * Returns the cursor used in the plane.
     *
     * @return the cursor used in the plane.
     */
    @Override
    public Cursor getCursor() {
        return this.cursor;
    }

    /**
     * Move the cursor forward of the specified distance.
     *
     * @param distance the distance of the movement.
     */
    @Override
    public void moveForward(double distance) {
        move(distance);
    }

    /**
     * Move the cursor backward of the specified distance.
     *
     * @param distance the distance of the movement.
     */
    @Override
    public void moveBackward(double distance) {
        move(-distance);
    }

    /**
     * Utility method to move the cursor of the specified distance.
     *
     * @param distance the distance of the movement.
     */
    private void move(double distance) {
        SimplePoint start = this.cursorPosition;
        SimplePoint end = newPosition(start, distance);
        this.cursorPosition = end;
        if (isPlot()) addNewLineFromPoints(start, end);
    }


    /**
     * Creates a new Line between the specified points and adds it to the list of shapes.
     *
     * @param start the start point of the line
     * @param end   the end point of the line
     */
    private void addNewLineFromPoints(Point start, Point end) {
        Line line = new Line(start, end, cursor.getLineColour(), cursor.getPenSize());
        shapes.add(line);
        checkForNewPolygon();
    }

    /**
     * Verifies if there is a new polygon in the shapes list, if so, removes the lines that form the polygon and
     * adds the polygon to the list.
     */
    private void checkForNewPolygon() {
        int adjacentPointsCounter = 0;
        for (int i = shapes.size() - 1; i > 0; i--) {
            if (shapes.get(i) instanceof Polygon || shapes.get(i - 1) instanceof Polygon) return;
            if (!areAdjacentLines((Line) shapes.get(i), (Line) shapes.get(i - 1))) break;
            adjacentPointsCounter++;
        }
        if (adjacentPointsCounter >= 2 && isClosedPolygon(adjacentPointsCounter)) {
            shapes.add(new Polygon(retrieveLines(adjacentPointsCounter), cursor.getShapeColour()));
        }
    }

    private boolean isClosedPolygon(int adjacentPointsCounter) {
        return areAdjacentLines((Line) shapes.get(shapes.size() - 1 - adjacentPointsCounter), (Line) shapes.get(shapes.size() - 1));
    }

    /**
     * Remove and return the specified number of lines from the shapes list.
     *
     * @param adjacentLineIndex the number of lines to remove
     * @return the list of lines removed
     */
    private List<Shape> retrieveLines(int adjacentLineIndex) {
        List<Shape> newPolygonLines = new ArrayList<>();
        for (int i = adjacentLineIndex; i >= 0; i--) {
            newPolygonLines.add(shapes.remove(i));
        }
        return newPolygonLines;
    }

    /**
     * Verifies if the two specified lines are adjacent.
     *
     * @param first  the first line
     * @param second the second line
     * @return true if the two lines are adjacent, false otherwise
     */
    private boolean areAdjacentLines(Line first, Line second) {
        return first.start().equals(second.end());
    }

    /**
     * Return the next cursor's position based on the specified distance. If the movement goes out of the plane, the new
     * position ends in plane's border.
     *
     * @param start    the start point
     * @param distance the distance of the movement
     * @return the next cursor's position
     */
    private SimplePoint newPosition(Point start, double distance) {
        double x = start.x() + (distance * cosWithDegrees(cursor.getDirection()));
        double y = start.y() + (distance * sinWithDegrees(cursor.getDirection()));
        if (x > width) x = width;
        else if (x < 0) x = 0;
        if (y > height) y = height;
        else if (y < 0) y = 0;
        return new SimplePoint(x, y);
    }

    /**
     * Return the sine of the specified angle represented in degrees.
     *
     * @param degrees the angle
     * @return the sine of the specified angle
     */
    private double sinWithDegrees(int degrees) {
        return Math.sin(Math.toRadians(degrees));
    }

    /**
     * Return the cosine of the specified angle represented in degrees.
     *
     * @param degrees the angle
     * @return the cosine of the specified angle
     */
    private double cosWithDegrees(int degrees) {
        return Math.cos(Math.toRadians(degrees));
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
     * Move the cursor to the home position. If the pen is down, a line is drawn.
     */
    @Override
    public void goHome() {
        SimplePoint start = this.cursorPosition;
        this.cursorPosition = this.homePoint;
        if (isPlot()) addNewLineFromPoints(start, this.homePoint);
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
     * @throws IllegalArgumentException if the size is less than 1
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

    @Override
    public String export() {
        return "Plane width " + width + " height " + height + " background colour: "
                + backgroundColour.export() + "\n" +
                this.shapes.stream()
                        .map(Shape::export)
                        .collect(Collectors.joining("\n"));
    }
}
