/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands;

public enum RotateOrientation {
    LEFT,
    RIGHT;

    /**
     * Returns the orientation corresponding to the given string.
     * @param s the string to parse.
     * @return the corresponding orientation.
     *
     * @throws IllegalArgumentException if the string is not a valid orientation.
     */
    public static RotateOrientation fromString(String s) {
        return RotateOrientation.valueOf(s.toUpperCase());
    }
}
