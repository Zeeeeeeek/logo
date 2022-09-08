/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands.movement;

import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveCommandTest {
    @Test
    public void shouldMove() {
        Plane<SimplePoint> plane = new SimplePlane(30,30);
        Command moveForward = new MoveCommand(List.of("FORWARD", "10"));
        moveForward.execute(plane);
        assertEquals(25, plane.getCursorPosition().x());
        assertEquals(15, plane.getCursorPosition().y());
        Command moveBackward = new MoveCommand(List.of("BACKWARD", "20"));
        moveBackward.execute(plane);
        assertEquals(5, plane.getCursorPosition().x());
        assertEquals(15, plane.getCursorPosition().y());
    }

    @Test
    public void shouldThrowExceptionIfWrongArguments() {
        assertThrows(IllegalArgumentException.class, () -> new MoveCommand(List.of("FORWARD")));
        assertThrows(IllegalArgumentException.class, () -> new MoveCommand(List.of("FORWARD", "10", "20")));
    }

    @Test
    public void shouldThrowExceptionIfArgsAreNotNumbers() {
        assertThrows(NumberFormatException.class, () -> new MoveCommand(List.of("FORWARD", "a")));
    }
}
