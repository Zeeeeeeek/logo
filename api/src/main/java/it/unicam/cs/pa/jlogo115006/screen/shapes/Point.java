/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen.shapes;/**
 * Represents a point in a plane identified by its coordinates.
 */
public interface Point {
    /**
     * Returns the x value.
     *
     * @return the x value
     */
    double x();

    /**
     * Returns the y value.
     *
     * @return the y value
     */
    double y();

    /**
     * Returns a string representation of the point.
     * @return a string representation of the point.
     */
    String export();

    default boolean equals(Point other) {
        return areDoubleEquals(this.x(), other.x()) && areDoubleEquals(this.y(), other.y());
    }

    private static boolean areDoubleEquals(double val1, double val2) {
        return val1 == val2 || Math.abs(val1 - val2) <= 0.0000001;
    }
}
