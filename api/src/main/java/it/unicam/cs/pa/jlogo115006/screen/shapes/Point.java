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
public interface Point extends IsExportable {
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
     * Returns true if the point is equal to the given point.
     * @param other the other element
     * @return true if the point is equal to the given point
     */
    @Override
    boolean equals(Object other);

    /**
     * Returns the hash code of the point.
     * @return the hash code of the point
     */
    @Override
    int hashCode();
}
