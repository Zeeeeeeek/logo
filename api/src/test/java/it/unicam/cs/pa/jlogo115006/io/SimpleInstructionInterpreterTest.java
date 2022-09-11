/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.io;

import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleInstructionInterpreterTest {
    @Test
    public void shouldCreateCommands() {

    }

    @Test
    public void shouldThrowExceptionForUnrecognizedCommand() {
        InstructionInterpreter interpreter = new SimpleInstructionInterpreter();
        assertThrows(IllegalArgumentException.class, () -> interpreter.createCommands(List.of("a")));
    }

    private void verifyExpectedPlane(Plane<SimplePoint> plane) {
        assertTrue(plane.getCursorPosition().equals(new SimplePoint(35, 25)));
        assertEquals(90, plane.getCursor().getDirection());
        assertFalse(plane.getCursor().getPlot());
        assertEquals(1, plane.getShapes().size());
    }

    @Test
    public void test() {
        Plane<SimplePoint> plane = new SimplePlane(500, 500);
        InstructionInterpreter interpreter = new SimpleInstructionInterpreter();
        Command cmd = interpreter.createCommand("REPEAT 4 [ REPEAT 2 [ FORWARD 10 ] RIGHT 90 ]");
        cmd.execute(plane);
    }

}
