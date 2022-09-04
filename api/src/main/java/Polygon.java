/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

import java.util.*;
import java.util.logging.*;

/**
 * Represents a closed area drawn in a plane.
 */
public record Polygon(List<Shape> lines, Colour colour) implements Shape {

    private static final Logger logger = Logger.getLogger(Polygon.class.getName());

    public Polygon(List<Shape> lines, Colour colour) {
        this.lines = Objects.requireNonNull(lines);
        this.colour = Objects.requireNonNull(colour);
        logger.info("New Polygon successfully created");
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

    public int getLinesNumber(){
        return this.lines.size();
    }
}
