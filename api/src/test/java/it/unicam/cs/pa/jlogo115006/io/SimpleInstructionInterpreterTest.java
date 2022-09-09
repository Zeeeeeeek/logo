/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.io;

import it.unicam.cs.pa.jlogo115006.*;
import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleInstructionInterpreterTest {
    @Test
    public void shouldCreateCommands() {
        Plane<SimplePoint> plane = new SimplePlane(50, 50);
        InstructionInterpreter interpreter = new SimpleInstructionInterpreter();
        Designer designer = new SimpleDesigner<>(plane);
        List<Command> commands = interpreter.createCommands(getSampleInstructionAsList());
        designer.execute(commands);
        verifyExpectedPlane(plane);
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


    private List<String> getSampleInstructionAsList() {
        return Arrays.asList(getSampleInstruction().split("\\R"));
    }

    private String getSampleInstruction() {
        return "forward 10\nleft 90\npenup\nsetpencolor 25 25 25";
    }
}
