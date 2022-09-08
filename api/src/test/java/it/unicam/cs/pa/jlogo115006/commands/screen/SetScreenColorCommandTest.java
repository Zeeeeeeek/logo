/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands.screen;

import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SetScreenColorCommandTest {
    @Test
    public void shouldSetScreenColor() {
        Plane<SimplePoint> plane = new SimplePlane(30, 30);
        SetScreenColorCommand command = new SetScreenColorCommand(List.of("255", "0", "0"));
        assertEquals(RGBColour.colourOf("255", "255", "255"), plane.getBackgroundColour());
        command.execute(plane);
        assertEquals(RGBColour.colourOf("255", "0", "0"), plane.getBackgroundColour());
    }

    @Test
    public void shouldThrowExceptionIfWrongArguments() {
        assertThrows(IllegalArgumentException.class, () -> new SetScreenColorCommand(List.of("255", "0")));
        assertThrows(IllegalArgumentException.class, () -> new SetScreenColorCommand(List.of("255", "0", "300")));
    }

    @Test
    public void shouldThrowExceptionIfArgsAreNotNumbers() {
        assertThrows(NumberFormatException.class, () -> new SetScreenColorCommand(List.of("255", "0", "a")));
    }

}
