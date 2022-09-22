/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.io;

import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.commands.movement.*;
import it.unicam.cs.pa.jlogo115006.commands.pen.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SimpleInstructionInterpreterTest {
    @Test
    void shouldCreateCommands() {
        SimpleInstructionInterpreter interpreter = new SimpleInstructionInterpreter();
        List<String> instructions = new ArrayList<>();
        instructions.add("forward 10");
        instructions.add("backward 10");
        instructions.add("penup");
        List<Command> commands = interpreter.createCommands(instructions);
        assertEquals(3, commands.size());
        assertEquals(MoveCommand.class, commands.get(0).getClass());
        assertEquals(MoveCommand.class, commands.get(1).getClass());
        assertEquals(ChangePenStatusCommand.class, commands.get(2).getClass());
    }

    @Test
    void shouldThrowExceptionForUnrecognizedCommand() {
        InstructionInterpreter interpreter = new SimpleInstructionInterpreter();
        assertThrows(IllegalArgumentException.class, () -> interpreter.createCommands(List.of("a")));
    }

    @Test
    void test() {
        Plane<SimplePoint> plane = new SimplePlane(500, 500);
        InstructionInterpreter interpreter = new SimpleInstructionInterpreter();
        Command cmd = interpreter.createCommand("REPEAT 4 [ FORWARD 10 RIGHT 90 ]");
        cmd.execute(plane);
        assertEquals(1, plane.getShapes().size());
        assertEquals(new SimplePoint(plane.getHeight() / 2, plane.getWidth() / 2), plane.getCursorPosition());
    }

}
