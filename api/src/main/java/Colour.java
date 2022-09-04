/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */


/**
 * Represents a color in the logo language.
 */
public interface Colour {
    /**
     * Returns the red component of the color.
     *
     * @return the red component of the color.
     */
    int getRed();

    /**
     * Returns the green component of the color.
     *
     * @return the green component of the color.
     */
    int getGreen();

    /**
     * Returns the blue component of the color.
     *
     * @return the blue component of the color.
     */
    int getBlue();

}
