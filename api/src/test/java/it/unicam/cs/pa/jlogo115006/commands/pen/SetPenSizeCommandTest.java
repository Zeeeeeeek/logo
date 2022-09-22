/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands.pen;

import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SetPenSizeCommandTest {
    @Test
    void shouldChangePenSize() {
        Plane<SimplePoint> plane = new SimplePlane(30, 30);
        SetPenSizeCommand command = new SetPenSizeCommand("10");
        assertEquals(1, plane.getCursor().getPenSize());
        command.execute(plane);
        assertEquals(10, plane.getCursor().getPenSize());
    }

    @Test
    void shouldThrowExceptionIfNotNumber() {
        assertThrows(NumberFormatException.class, () -> new SetPenSizeCommand("a"));
    }

    @Test
    void shouldThrowExceptionIfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> new SetPenSizeCommand("-1").execute(new SimplePlane(30, 30)));
    }
}
