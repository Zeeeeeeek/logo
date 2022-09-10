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


import static org.junit.jupiter.api.Assertions.*;

public class HomeCommandTest {
    @Test
    public void shouldGoHome() {
        Plane<SimplePoint> plane = new SimplePlane(30,30);
        plane.moveForward(10);
        Command goHome = new HomeCommand();
        goHome.execute(plane);
        assertEquals(plane.getWidth()/2, plane.getCursorPosition().x());
        assertEquals(plane.getHeight()/2, plane.getCursorPosition().y());
    }


}
