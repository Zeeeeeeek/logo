/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

/**
 * Represents an element that performs action on a plane based on the received commands.
 */
public interface Designer {

    /**
     * Performs the action associated with the given command on its plane.
     *
     * @param command the command to be executed.
     */
    void execute(Command command);

    /**
     * Returns the plane on which the designer is working.
     *
     * @return the plane on which the designer is working.
     */
    Plane<Point> getPlane();
}
