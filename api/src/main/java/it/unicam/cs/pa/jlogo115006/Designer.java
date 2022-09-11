/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006;

import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.util.*;

/**
 * Represents an element that performs action on a plane based on the received commands.
 */
public interface Designer {

    /**
     * Performs the action associated with the given commands on its plane.
     *
     * @param commands the commands to be executed.
     */
    default void execute(List<Command> commands) {
        commands.forEach(this::execute);
    }


    /**
     * Performs the action associated with the given command on its plane.
     *
     * @param command the command to be executed.
     */
    void execute(Command command);

    /**
     * Returns the plane on which the designer is working.
     * @return the plane on which the designer is working.
     */
    Plane<? extends Point> getPlane();

}
