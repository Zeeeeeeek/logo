/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */


import java.util.logging.*;

/**
 * This class represents a simple RGB implementation.
 */
public record RGBColour(int red, int green, int blue) implements Colour {

    private static final Logger logger = Logger.getLogger(RGBColour.class.getName());

    /**
     * Creates a new RGBColour with the given values
     * @param red red component
     * @param green green component
     * @param blue blue component
     *
     * @throws IllegalArgumentException if one of the values are not in the range [0, 360].
     */
    public RGBColour(int red, int green, int blue) {
        this.red = checkColour(red);
        this.green = checkColour(green);
        this.blue = checkColour(blue);
        logger.info("New RGB colour successfully created");
    }

    /**
     * Utility method used to verify the colour value
     *
     * @param colour colour value
     * @return the colour value if its valid, 0 otherwise
     *
     * @throws IllegalArgumentException if an invalid value is passed
     */
    private int checkColour(int colour) {
        if (colour < 0 || colour > 255) {
            logger.severe("Tried to create a colour with an invalid value");
            throw new IllegalArgumentException("Color values should be in the range [0,360]. Value entered" + colour);
        }
        return colour;
    }

    /**
     * Returns the red component of the color.
     *
     * @return the red component of the color.
     */
    @Override
    public int red() {
        return this.red;
    }

    /**
     * Returns the green component of the color.
     *
     * @return the green component of the color.
     */
    @Override
    public int green() {
        return this.green;
    }

    /**
     * Returns the blue component of the color.
     *
     * @return the blue component of the color.
     */
    @Override
    public int blue() {
        return this.blue;
    }
}
