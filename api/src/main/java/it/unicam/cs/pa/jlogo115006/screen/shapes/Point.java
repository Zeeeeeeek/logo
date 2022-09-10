/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen.shapes;

import it.unicam.cs.pa.jlogo115006.io.output.*;

/**
 * Represents a point in a plane identified by its coordinates.
 */
public interface Point extends isExportable {
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

    default boolean equals(Point other) {
        return areDoubleEquals(this.x(), other.x()) && areDoubleEquals(this.y(), other.y());
    }

    private boolean areDoubleEquals(double val1, double val2) {
        return val1 == val2 || Math.abs(val1 - val2) <= 0.0001;
    }
}
