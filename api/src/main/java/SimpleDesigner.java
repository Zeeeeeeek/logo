/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */


import java.util.*;

public class SimpleDesigner implements Designer {

    private final SimplePlane plane;

    public SimpleDesigner(SimplePlane plane) {
        this.plane = Objects.requireNonNull(plane);
    }


    /**
     * Performs the action associated with the given commands on its plane.
     *
     * @param commands the commands to be executed.
     */
    @Override
    public void execute(List<Command> commands) {
        //commands.forEach(command -> command.execute(plane));
    }

    /**
     * Returns the plane on which the designer is working.
     *
     * @return the plane on which the designer is working.
     */
    @Override
    public Plane<Point> getPlane() {
        return null;
    }
}
