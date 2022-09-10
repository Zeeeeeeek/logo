/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands;


import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.util.*;

public class RepeatCommand implements Command {

    private final List<Command> commands;
    private final int times;

    /**
     * Creates a new repeat command that will execute the commands for the specified times
     * @param times the number of times the commands will be executed
     * @param commands the commands to execute
     *
     * @throws IllegalArgumentException if the number of times is not greater than 0
     * @throws NullPointerException if the commands list is null
     */
    public RepeatCommand(String times, List<Command> commands) {
        if(Integer.parseInt(times) <= 0) throw new IllegalArgumentException("Times in repeat command must be greater than 0");
        this.times = Integer.parseInt(times);
        this.commands = Objects.requireNonNull(commands);
    }



    /**
     * Executes the command with its arguments in the given plane.
     *
     * @param plane the plane on which the command is executed.
     */
    @Override
    public void execute(Plane<? extends Point> plane){
        for(int i = 0; i < times; i++) {
            commands.forEach(c -> c.execute(plane));
        }
    }
}
