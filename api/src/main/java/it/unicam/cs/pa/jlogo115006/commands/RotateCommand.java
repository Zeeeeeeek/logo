/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands;

import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.util.*;

public class RotateCommand implements Command{

    private final RotateOrientation orientation;
    private final int angle;

    public RotateCommand(List<String> args) {
        if(args.size() != 2) throw new IllegalArgumentException("Wrong number of arguments");

        this.orientation = RotateOrientation.fromString(args.get(0));
        this.angle = Integer.parseInt(args.get(1));
    }
    /**
     * Executes the command with its arguments in the given plane.
     *
     * @param plane the plane on which the command is executed.
     */
    @Override
    public void execute(Plane<Point> plane) {
        if (orientation == RotateOrientation.LEFT) {
            plane.rotateLeft(angle);
        } else {
            plane.rotateRight(angle);
        }
    }
}
