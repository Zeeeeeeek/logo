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
 * Represents a command that set the area colour.
 */
public class SetFillColorCommand implements Command {
    
    private final Colour fillColour;
    
    
    public SetFillColorCommand(List<String> args) {
        this.fillColour = RGBColour.colourOfList(args);
    }
    
    
    
    /**
     * Executes the command with its arguments in the given plane.
     *
     * @param plane the plane on which the command is executed.
     */
    @Override
    public void execute(Plane<Point> plane) {
        plane.setShapeColour(fillColour);
    }
}
