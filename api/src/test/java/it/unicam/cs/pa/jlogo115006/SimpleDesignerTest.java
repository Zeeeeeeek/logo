/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006;

import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.commands.movement.*;
import it.unicam.cs.pa.jlogo115006.commands.pen.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleDesignerTest {
    @Test
    public void shouldRunSingleCommands() {
        Plane<SimplePoint> plane = new SimplePlane(50, 50);
        Designer designer = new SimpleDesigner<>(plane);
        designer.execute(new MoveCommand(List.of("FORWARD", "10")));
        assertEquals(new SimplePoint(35, 25), plane.getCursorPosition());
        designer.execute(new RotateCommand(List.of("LEFT", "90")));
        assertEquals(90, plane.getCursor().getDirection());
    }

    @Test
    public void shouldRunListOfCommands() {
        Plane<SimplePoint> plane = new SimplePlane(50, 50);
        Designer designer = new SimpleDesigner<>(plane);
        designer.execute(getSampleCommands());
        assertTrue(new SimplePoint(25, 15).equals(plane.getCursorPosition()));
        assertEquals(270, plane.getCursor().getDirection());
        assertEquals(2, plane.getShapes().size());
        assertEquals(1, countPolygonInPlane(plane));
        assertEquals(1, countLineInPlane(plane));
        assertFalse(plane.getCursor().getPlot());
    }
    private List<Command> getSampleCommands() {
        return List.of(
                new MoveCommand(List.of("FORWARD", "10")),
                new RotateCommand(List.of("LEFT", "90")),
                new MoveCommand(List.of("FORWARD", "10")),
                new RotateCommand(List.of("LEFT", "90")),
                new MoveCommand(List.of("FORWARD", "10")),
                new RotateCommand(List.of("LEFT", "90")),
                new MoveCommand(List.of("FORWARD", "10")),
                new MoveCommand(List.of("FORWARD", "10")),
                new ChangePenStatusCommand("UP")
        );
    }

    private long countPolygonInPlane(Plane<SimplePoint> plane) {
        return plane.getShapes().stream().filter(s -> s instanceof Polygon).count();
    }

    private long countLineInPlane(Plane<SimplePoint> plane) {
        return plane.getShapes().stream().filter(s -> s instanceof Line).count();
    }
}
