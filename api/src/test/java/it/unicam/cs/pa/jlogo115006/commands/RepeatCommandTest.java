/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands;

import it.unicam.cs.pa.jlogo115006.commands.movement.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RepeatCommandTest {
    @Test
    public void shouldRepeatCommands() {
        Plane<SimplePoint> plane = new SimplePlane(100,100);
        List<Command> commands = generateCommands();
        Command repeat = new RepeatCommand("4", commands);
        repeat.execute(plane);
        assertEquals(1, plane.getShapes().size());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWithWrongArgument() {
        assertThrows(IllegalArgumentException.class, () -> new RepeatCommand("0", List.of(new HomeCommand(), new HomeCommand())));
    }

    private List<Command> generateCommands() {
        return List.of(new MoveCommand(List.of("Forward", "10")), new RotateCommand(List.of("Left", "90")));
    }

    @Test
    public void multipleRepeatCommand() {
        Plane<SimplePoint> plane = new SimplePlane(100, 100);
        List<Command> commands = List.of(new MoveCommand(List.of("Forward", "5")));
        Command toBeRepeated = new RepeatCommand("2", commands);
        Command repeat = new RepeatCommand("2", List.of(toBeRepeated));
        repeat.execute(plane);
        assertEquals(70, plane.getCursorPosition().x());
    }
}
