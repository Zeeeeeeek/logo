/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands.pen;

import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.util.*;

/**
 * Represents a command that set the line color.
 */
public class SetPenColorCommand implements Command {
    private final Colour penColour;

    /**
     * Create a new {@link SetPenColorCommand} with the given colour values.
     *
     * @param args list containing the colour values.
     * @throws NumberFormatException    if one or more values are not numbers.
     * @throws IllegalArgumentException if the list does not contain exactly 3 values or
     *                                  if one or more values are not in the range [0, 255].
     */
    public SetPenColorCommand(List<String> args) {
        this.penColour = RGBColour.colourOfList(args);
    }


    /**
     * Executes the command with its arguments in the given plane.
     *
     * @param plane the plane on which the command is executed.
     */
    @Override
    public void execute(Plane<? extends Point> plane) {
        plane.setLineColour(penColour);
    }
}
