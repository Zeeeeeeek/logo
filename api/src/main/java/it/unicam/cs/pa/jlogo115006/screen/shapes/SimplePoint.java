/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen.shapes;

import java.util.logging.Logger;

/**
 * Represents a simple point ina a plane
 * @param x x coordinate
 * @param y y coordinate
 */
public record SimplePoint(double x, double y) implements Point {
    private static final Logger logger = Logger.getLogger(SimplePoint.class.getName());
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


    @Override
    public boolean equals(Object other) {
        if(other instanceof Point otherPoint) {
            return areDoubleEquals(this.x(), otherPoint.x()) && areDoubleEquals(this.y(), otherPoint.y());
        }
        return false;
    }

    private boolean areDoubleEquals(double val1, double val2) {
        return val1 == val2 || Math.abs(val1 - val2) <= 0.0001;
    }

    /**
     * Returns a string representation of the point.
     *
     * @return a string representation of the point.
     */
    @Override
    public String export() {
        return this.x() + " " + this.y();
    }
}
