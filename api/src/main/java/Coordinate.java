/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

/**
 * Identifies a point in a plane
 */
public interface Coordinate {
    /**
     * Returns the x value.
     * @return the x value
     */
    int getX();

    /**
     * Returns the y value.
     * @return the y value
     */
    int getY();
}
