/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen.shapes;import java.util.*;
import java.util.logging.*;

/**
 * Represents a closed area drawn in a plane.
 */
public record Polygon(List<Shape> lines, Colour colour) implements Shape {

    private static final Logger logger = Logger.getLogger(Polygon.class.getName());

    public Polygon{
        Objects.requireNonNull(lines);
        Objects.requireNonNull(colour);
        logger.info("New it.unicam.cs.pa.jlogo115006.screen.shapes.Polygon successfully created");
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
     * Returns the number of lines in the polygon.
     * @return the number of lines in the polygon.
     */
    public int getLinesNumber(){
        return this.lines.size();
    }

    /**
     * Returns the list of lines composing the polygon.
     * @return the list of lines composing the polygon.
     */
    @Override
    public List<Shape> lines() {
        return lines;
    }
}