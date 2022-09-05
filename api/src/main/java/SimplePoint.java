/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

/**
 * Represents a simple point ina a plane
 * @param x x coordinate
 * @param y y coordinate
 */
public record SimplePoint(double x, double y) implements Point {

    /**
     * Returns the x value.
     *
     * @return the x value
     */
    @Override
    public double x() {
        return 0;
    }

    /**
     * Returns the y value.
     *
     * @return the y value
     */
    @Override
    public double y() {
        return 0;
    }
}
