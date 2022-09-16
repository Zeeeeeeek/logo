/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen.shapes;


import java.util.List;
import java.util.logging.Logger;

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
     * @throws IllegalArgumentException if one or more values are not in the range [0, 255].
     */
    public RGBColour {
        isValidColourValue(red);
        isValidColourValue(green);
        isValidColourValue(blue);
    }

    /**
     * Utility method used to verify the colour value
     *
     * @param colour colour value
     *
     * @throws IllegalArgumentException if an invalid value is passed
     */
    private void isValidColourValue(int colour) {
        if (colour < 0 || colour > 255) {
            logger.severe("Tried to create a colour with an invalid value");
            throw new IllegalArgumentException("Color values should be in the range [0,360]. Value entered" + colour);
        }
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

    /**
     * Returns a string representation of the colour.
     *
     * @return a string representation of the colour.
     */
    @Override
    public String export() {
        return this.red + " " + this.green + " " + this.blue;
    }


    /**
     * Returns a colour based on the values passed as strings
     * @param red red component
     * @param green green component
     * @param blue blue component
     * @return a new colour with the given values
     *
     * @throws IllegalArgumentException if one or more values are not in the range [0, 255].
     * @throws NumberFormatException if one or more values are not numbers.
     */
    public static RGBColour colourOf(String red, String green, String blue) {
        return new RGBColour(Integer.parseInt(red), Integer.parseInt(green), Integer.parseInt(blue));
    }

    /**
     * Returns a colour based on the values passed in a string list
     * @param values list of values
     * @return a new colour with the given values
     *
     * @throws IllegalArgumentException if the list does not contain exactly 3 values or if one or more values are
     * not in the range [0, 255].
     * @throws NumberFormatException if one or more values are not numbers.
     */
    public static RGBColour colourOfList(List<String> values) {
        if(values.size() != 3) {
            logger.severe("List of values does not contain exactly 3 values for RGB colour");
            throw new IllegalArgumentException("Invalid number of values");
        }
        return colourOf(values.get(0), values.get(1), values.get(2));
    }
}
