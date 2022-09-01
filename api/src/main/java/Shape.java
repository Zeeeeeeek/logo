/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

/**
 * Represents a shape drawn by the cursor on a plane.
 */
public interface Shape {
    /**
     * Return the color of the shape.
     * @return the color of the shape.
     */
    Colour getColor();
}
