/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands.screen;

import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.util.*;

/**
 * This class represents a command that change the screen color.
 */
public class SetScreenColorCommand implements Command {


    private final Colour newBackgroundColour;

    /**
     * Creates a new {@link SetScreenColorCommand} with the given background colour.
     *
     * @param args colour values.
     *
     * @throws IllegalArgumentException if the list does not contain exactly 3 values or if one or more values are not in the range [0, 255]
     * @throws NumberFormatException if one or more values are not numbers
     */
    public SetScreenColorCommand(List<String> args) {
        newBackgroundColour = RGBColour.colourOfList(args);
    }


    /**
     * Executes the command with its arguments in the given plane.
     *
     * @param plane the plane on which the command is executed.
     */
    @Override
    public void execute(Plane<? extends Point> plane) {
        plane.setBackgroundColour(newBackgroundColour);
    }

}
