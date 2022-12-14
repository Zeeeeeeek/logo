/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen.shapes;


import java.util.*;
import java.util.logging.Logger;

/**
 * Represents a Line between 2 points
 */
public record Line(Point start, Point end, Colour colour, int size) implements Shape {
    private static final Logger logger = Logger.getLogger(Line.class.getName());

    /**
     * Creates a new line with the given start and end points, and the specified colour and size.
     *
     * @param start the start point
     * @param end the end point
     * @param colour the colour of the line
     * @param size the size of the line
     *
     * @throws IllegalArgumentException if the start or end points are null
     */

    public Line {
        Objects.requireNonNull(start);
        Objects.requireNonNull(end);
        Objects.requireNonNull(colour);
        if (size < 0) {
            logger.severe("Tried to create a line with a negative size");
            throw new IllegalArgumentException("The size must be non-negative");
        }
        logger.info("New Line has been drawn");
    }
    /**
     * This method returns a string representation of this line.
     *
     * @return a string representation of this line.
     */
    @Override
    public String export() {
        return "LINE " + this.start.export() + " " + this.end.export() + " " + this.colour.export() + " " + this.size;
    }
}
