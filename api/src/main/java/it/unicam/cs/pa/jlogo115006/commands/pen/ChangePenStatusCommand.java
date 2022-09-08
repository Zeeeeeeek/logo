/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands.pen;

import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

/**
 * A command that changes the pen status.
 */

public class ChangePenStatusCommand implements Command {

    private final PenStatus status;

    /**
     * Creates a new ChangePenStatusCommand with the given status.
     * @param arg the status to set
     * @throws IllegalArgumentException if the status is invalid
     */
    public ChangePenStatusCommand(String arg) {
        this.status = PenStatus.fromString(arg);
    }
    /**
     * Executes the command with its arguments in the given plane.
     *
     * @param plane the plane on which the command is executed.
     */
    @Override
    public <P extends Point> void execute(Plane<P> plane) {
        if (status == PenStatus.UP) {
            plane.penUp();
        } else {
            plane.penDown();
        }
    }
}
