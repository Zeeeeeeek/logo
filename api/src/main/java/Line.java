/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

/**
 * Represents a Line between 2 points
 */
public record Line(Point start, Point end, Colour colour, int size) implements Shape {

    /**
     * Return the colour of the shape.
     *
     * @return the colour of the shape.
     */
    @Override
    public Colour colour() {
        return this.colour;
    }
}
