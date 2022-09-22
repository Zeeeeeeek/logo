/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen;


import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCursorTest {

    @Test
    void shouldBeCreatedWithDefaultValues() {
        SimpleCursor cursor = new SimpleCursor();
        assertEquals(0, cursor.getDirection());
        assertTrue(cursor.getPlot());
        assertEquals(new RGBColour(0, 0, 0), cursor.getLineColour());
        assertEquals(new RGBColour(255, 255, 255), cursor.getShapeColour());
        assertEquals(1, cursor.getPenSize());
    }

    @Test
    void shouldBeCreatedWithSpecifiedValues() {
        SimpleCursor cursor = new SimpleCursor(90, false,
                new RGBColour(255, 0, 0), new RGBColour(0, 255, 0), 2);
        assertEquals(90, cursor.getDirection());
        assertFalse(cursor.getPlot());
        assertEquals(new RGBColour(255, 0, 0), cursor.getLineColour());
        assertEquals(new RGBColour(0, 255, 0), cursor.getShapeColour());
        assertEquals(2, cursor.getPenSize());
    }

    @Test
    void shouldRotateWithPositiveValues() {
        SimpleCursor cursor = new SimpleCursor();
        cursor.rotate(180);
        assertEquals(180, cursor.getDirection());
        cursor.rotate(190);
        assertEquals(10, cursor.getDirection());
    }

    @Test
    void shouldRotateWithNegativeValues() {
        SimpleCursor cursor = new SimpleCursor();
        cursor.rotate(-180);
        assertEquals(180, cursor.getDirection());
        cursor.rotate(-190);
        assertEquals(350, cursor.getDirection());
    }

    @Test
    void shouldChangePenSize() {
        SimpleCursor cursor = new SimpleCursor();
        cursor.setPenSize(20);
        assertEquals(20, cursor.getPenSize());
    }

    @Test
    void shouldNotChangePenSize() {
        SimpleCursor cursor = new SimpleCursor();
        assertThrows(IllegalArgumentException.class, () -> cursor.setPenSize(-20));
    }

    @Test
    void shouldChangeColours() {
        SimpleCursor cursor = new SimpleCursor();
        Colour colour1 = new RGBColour(255, 0, 0);
        Colour colour2 = new RGBColour(255, 0, 10);
        cursor.setLineColour(colour1);
        cursor.setShapeColour(colour2);
        assertEquals(colour1, cursor.getLineColour());
        assertEquals(colour2, cursor.getShapeColour());
    }

    @Test
    void shouldNotChangeColours() {
        SimpleCursor cursor = new SimpleCursor();
        assertThrows(NullPointerException.class, () -> cursor.setLineColour(null));
        assertThrows(NullPointerException.class, () -> cursor.setShapeColour(null));
    }
}
