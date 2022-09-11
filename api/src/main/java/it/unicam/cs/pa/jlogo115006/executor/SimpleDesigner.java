/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.executor;


import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.util.*;

/**
 * This class has the responsibility to execute commands on a plane.
 */
public class SimpleDesigner implements Designer {

    private final Plane<? extends Point> plane;

    public SimpleDesigner(Plane<? extends Point> plane) {
        this.plane = Objects.requireNonNull(plane);
    }


    /**
     * Performs the action associated with the given commands on its plane.
     *
     * @param commands the commands to be executed.
     */
    @Override
    public void execute(List<Command> commands) {
        commands.forEach(this::execute);
    }

    /**
     * Performs the action associated with the given command on its plane.
     *
     * @param command the command to be executed.
     */
    @Override
    public void execute(Command command) {
        command.execute(plane);
    }

    /**
     * Returns the plane on which the designer is working.
     *
     * @return the plane on which the designer is working.
     */
    @Override
    public Plane<? extends Point> getPlane() {
        return this.plane;
    }

}
