/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands.pen;

import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ChangePenStatusCommandTest {
    @Test
    void shouldChangePenStatus() {
        Plane<SimplePoint> plane = new SimplePlane(30,30);
        assertTrue(plane.isPlot());
        Command penUp = new ChangePenStatusCommand("up");
        penUp.execute(plane);
        assertFalse(plane.isPlot());
        Command penDown = new ChangePenStatusCommand("down");
        penDown.execute(plane);
        assertTrue(plane.isPlot());
    }

    @Test
    void shouldThrowExceptionWithWrongArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ChangePenStatusCommand("wrong"));
    }
}
