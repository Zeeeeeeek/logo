/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class SimpleCursorTest {

    @Test
    public void shouldBeCreatedWithHomePosition() {
        Point home = new SimplePoint(10, 10);
        SimpleCursor cursor = new SimpleCursor(home);
        assertEquals(home, cursor.getPosition());
    }

    @Test
    public void shouldBeCreatedWithGivenArguments() {
        SimpleCursor cursor = createSampleCursor();
        assertEquals(new SimplePoint(10, 10), cursor.getPosition());
        assertEquals(180, cursor.getDirection());
        assertTrue(cursor.getPlot());
        assertEquals(createSampleColour(), cursor.getLineColour());
        assertEquals(createSampleColour(), cursor.getShapeColour());
    }


    private SimpleCursor createSampleCursor() {
        return new SimpleCursor(new SimplePoint(10, 10), 180, true,
                createSampleColour(), createSampleColour());
    }

    private RGBColour createSampleColour() {
        return new RGBColour(0, 0, 0);
    }

    @Test
    public void rotationWithPositiveValues() {
        SimpleCursor cursor = createSampleCursor();
        cursor.rotate(90);
        assertEquals(270, cursor.getDirection());
        cursor.rotate(100);
        assertEquals(10, cursor.getDirection());
        cursor.rotate(400);
        assertEquals(50, cursor.getDirection());
    }

    @Test
    public void rotationWithNegativeValues() {
        SimpleCursor cursor = createSampleCursor();
        cursor.rotate(-170);
        assertEquals(10, cursor.getDirection());
        cursor.rotate(-100);
        assertEquals(270, cursor.getDirection());
        cursor.rotate(-400);
        assertEquals(230, cursor.getDirection());
    }
}
