/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.commands.movement;

import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RotateCommandTest {
    @Test
    void shouldRotateWithDifferentValues() {
        Plane<SimplePoint> plane = new SimplePlane(30,30);
        rotate("left", 90, plane);
        assertEquals(90, plane.getCursor().getDirection());
        rotate("right", 180, plane);
        assertEquals(270, plane.getCursor().getDirection());
        rotate("right", -30, plane);
        assertEquals(300, plane.getCursor().getDirection());
    }

    private <P extends Point> void rotate(String direction, int angle, Plane<P> plane) {
        new RotateCommand(List.of(direction, Integer.toString(angle))).execute(plane);
    }

    @Test
    void shouldThrowExceptionWithWrongArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new RotateCommand(List.of("wrong", "90")));
    }

}
