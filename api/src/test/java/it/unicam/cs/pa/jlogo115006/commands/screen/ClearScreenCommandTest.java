/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands.screen;

import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClearScreenCommandTest {
    @Test
    public void shouldClearScreen() {
        Plane<SimplePoint> plane = new SimplePlane(100, 100);
        plane.moveForward(10);
        assertEquals(1, plane.getShapes().size());
        new ClearScreenCommand().execute(plane);
        assertEquals(0, plane.getShapes().size());
    }
}
