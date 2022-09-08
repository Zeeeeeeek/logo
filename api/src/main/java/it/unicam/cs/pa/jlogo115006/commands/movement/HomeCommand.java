/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands.movement;

import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

/**
 * Represents a command that move the cursor to the home position.
 */
public class HomeCommand implements Command {
    /**
     * Executes the command with its arguments in the given plane.
     *
     * @param plane the plane on which the command is executed.
     */
    @Override
    public <P extends Point> void execute(Plane<P> plane) {
        plane.goHome();
    }
}
