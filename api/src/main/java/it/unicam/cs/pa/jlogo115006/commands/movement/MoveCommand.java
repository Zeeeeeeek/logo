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
 * This class represents a command that move the cursor for a given distance.
 */
public class MoveCommand implements Command {
    private final MovementDirection direction;
    private final double distance;
    /**
     * Creates a new move command based on the given arguments.
     * @param args list of arguments.
     *
     * @throws IllegalArgumentException if the arguments are not 2. Or if the first argument is an invalid direction.
     * @throws NumberFormatException if the distance argument is not a parsable double.
     */
    public MoveCommand(List<String> args) {
        if(args.size() != 2) throw new IllegalArgumentException("Invalid number of arguments for move command.");
        this.direction = MovementDirection.fromString(args.get(0));
        this.distance = Double.parseDouble(args.get(1));
    }

    /**
     * Executes the command with its arguments in the given plane.
     *
     * @param plane the plane on which the command is executed.
     */
    @Override
    public <P extends Point> void execute(Plane<P> plane) {
        if (direction == MovementDirection.FORWARD) {
            plane.moveForward(distance);
        } else {
            plane.moveBackward(distance);
        }
    }
}
