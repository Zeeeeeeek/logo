/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen.shapes;

import java.util.logging.*;

/**
 * Represents a simple point ina a plane
 * @param x x coordinate
 * @param y y coordinate
 */
public record SimplePoint(double x, double y) implements Point {
    private final static Logger logger = Logger.getLogger(SimplePoint.class.getName());
    /**
     * Creates a new point with the given coordinates.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     *
     * @throws IllegalArgumentException if the x or y coordinates are negative
     */
    public SimplePoint {
        requireNonNegativeDouble(x);
        requireNonNegativeDouble(y);
    }

    private void requireNonNegativeDouble(double coordinate) {
        if (coordinate < 0) {
            logger.severe("Tried to create a point with a negative coordinate");
            throw new IllegalArgumentException("The x or y value must be non-negative");
        }
    }

    /**
     * Returns the x value.
     *
     * @return the x value
     */
    @Override
    public double x() {
        return this.x;
    }

    /**
     * Returns the y value.
     *
     * @return the y value
     */
    @Override
    public double y() {
        return this.y;
    }
}
