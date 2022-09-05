/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

/**
 * Represents a command in the logo language.
 */
public interface Command {
    /**
     * Executes the command with its arguments in the given plane.
     * @param plane the plane on which the command is executed.
     */
    void execute(Plane<Point> plane);
}
