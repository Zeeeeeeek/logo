/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen.shapes;

import java.util.*;
import java.util.logging.Logger;

/**
 * Represents a closed area drawn in a plane.
 */
public record Polygon(List<Line> lines, Colour colour) implements Shape {

    private static final Logger logger = Logger.getLogger(Polygon.class.getName());

    public Polygon {
        Objects.requireNonNull(lines);
        Objects.requireNonNull(colour);
        logger.info("Polygon successfully created");
    }

    /**
     * Return the colour of the shape.
     *
     * @return the colour of the shape.
     */
    @Override
    public Colour colour() {
        return this.colour;
    }

    /**
     * This method returns a string representation of the shape.
     *
     * @return a string representation of the shape.
     */
    @Override
    public String export() {
        return "POLYGON " + this.lines.size() + " " + this.colour.export() + "\n"
                + this.lines.stream().map(l -> l.start().export() + " " + l.colour().export() + " " +l.size() + "\n").reduce("", String::concat);
    }

    /**
     * Returns the number of lines in the polygon.
     *
     * @return the number of lines in the polygon.
     */
    public int getLinesNumber() {
        return this.lines.size();
    }

    /**
     * Returns the list of lines composing the polygon.
     *
     * @return the list of lines composing the polygon.
     */
    @Override
    public List<Line> lines() {
        return lines;
    }
}
