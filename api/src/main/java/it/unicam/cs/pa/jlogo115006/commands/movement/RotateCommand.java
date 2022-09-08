/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands.movement;

import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.util.*;

/**
 * This command change the orientation of the plane's cursor
 */
public class RotateCommand implements Command {

    private final RotateOrientation orientation;
    private final int angle;

    /**
     * Creates a new RotateCommand with the given orientation and angle
     * @param args the arguments of the command, this list must contain the orientation and the angle
     * @throws IllegalArgumentException if the arguments amount is not 2 or the orientation is invalid
     * @throws NumberFormatException if the angle is not a number
     */
    public RotateCommand(List<String> args) {
        if(args.size() != 2) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }
        this.orientation = RotateOrientation.fromString(args.get(0));
        this.angle = Integer.parseInt(args.get(1));
    }
    /**
     * Executes the command with its arguments in the given plane.
     *
     * @param plane the plane on which the command is executed.
     */
    @Override
    public <P extends Point> void execute(Plane<P> plane) {
        if (orientation == RotateOrientation.LEFT) {
            plane.rotateLeft(angle);
        } else {
            plane.rotateRight(angle);
        }
    }
}
