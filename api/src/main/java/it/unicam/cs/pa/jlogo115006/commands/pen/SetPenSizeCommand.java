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
 * Represents the command that set the pen size.
 */
public class SetPenSizeCommand implements Command {

    private final int size;

    /**
     * Create a new {@link SetPenSizeCommand} with the given size.
     * @param size pen size
     *
     * @throws NumberFormatException if the size is not a number.
     */
    public SetPenSizeCommand(String size) {
        this.size = Integer.parseInt(size);
    }
    /**
     * Executes the command with its arguments in the given plane.
     *
     * @param plane the plane on which the command is executed.
     * @throws IllegalArgumentException if the size is less than 1.
     */
    @Override
    public void execute(Plane<? extends Point> plane) {
        plane.setPenSize(size);
    }
}
