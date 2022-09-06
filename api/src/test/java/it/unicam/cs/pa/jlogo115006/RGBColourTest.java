/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006;

import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class RGBColourTest {
    @Test
    public void colourWithCorrectValues() {
        checkColourValues(new RGBColour(125, 150, 40), 125, 150, 40);
    }

    @Test
    public void colourWithWrongValues() {
        assertThrows(IllegalArgumentException.class, () -> new RGBColour(500, 30 ,40));
    }

    private void checkColourValues(Colour colour, int red, int green, int blue) {
        assertEquals(colour.red(), red);
        assertEquals(colour.green(), green);
        assertEquals(colour.blue(), blue);
    }
}
