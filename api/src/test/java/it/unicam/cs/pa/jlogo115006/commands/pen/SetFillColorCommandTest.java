/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands.pen;

import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SetFillColorCommandTest {
    @Test
    void shouldChangeTheShapeColour() {
        Plane<SimplePoint> plane = new SimplePlane(30, 30);
        SetFillColorCommand command = new SetFillColorCommand(List.of("255", "0", "0"));
        command.execute(plane);
        assertEquals(plane.getCursor().getShapeColour(), RGBColour.colourOf("255", "0", "0"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfTheArgumentsAreInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new SetFillColorCommand(List.of("255", "0")));
        assertThrows(IllegalArgumentException.class, () -> new SetFillColorCommand(List.of("255", "0", "300")));
    }

    @Test
    void shouldThrowNumberFormatExceptionIfTheStringsDoesNotContainAParsableInteger() {
        assertThrows(NumberFormatException.class, () -> new SetFillColorCommand(List.of("255", "0", "a")));
    }
}
