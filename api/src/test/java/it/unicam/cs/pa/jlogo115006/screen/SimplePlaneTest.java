/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen;

import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimplePlaneTest {

    @Test
    public void shouldBeCreatedWithDefaultValues() {
        Plane<SimplePoint> plane = new SimplePlane(100, 100);
        verifyXAndY(getCursorX(plane), getCursorY(plane), 50, 50);
        assertEquals(new RGBColour(255, 255, 255), plane.getBackgroundColour());
    }

    @Test
    public void shouldThrowExceptionWithNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> new SimplePlane(-100, 100));
        assertThrows(IllegalArgumentException.class, () -> new SimplePlane(100, -100));
    }

    @Test
    public void cursorRotation() {
        Plane<SimplePoint> plane = new SimplePlane(100, 100);
        plane.rotateRight(90);
        assertEquals(270, plane.getCursor().getDirection());
        plane.rotateLeft(135);
        assertEquals(45, plane.getCursor().getDirection());
    }

    @Test
    public void cursorMoveWithoutRotation() {
        Plane<SimplePoint> plane = new SimplePlane(100, 100);
        plane.moveForward(10);
        verifyXAndY(getCursorX(plane), getCursorY(plane), 60, 50);
        plane.moveBackward(20);
        verifyXAndY(getCursorX(plane), getCursorY(plane), 40, 50);
    }


    @Test
    public void cursorMoveWithRotation() {
        Plane<SimplePoint> plane = new SimplePlane(100, 100);
        plane.rotateRight(45);
        plane.moveForward(10);
        verifyXAndY(getCursorX(plane), getCursorY(plane), 57.07106781186547524, 42.92893218813452475);
        plane.rotateLeft(180);
        plane.moveBackward(20);
        verifyXAndY(getCursorX(plane), getCursorY(plane), 71.21320343559642573, 28.78679656440357426);
    }


    @Test
    public void exceedingPlaneBoundsOnStraightMovements () {
        Plane<SimplePoint> plane = new SimplePlane(20, 20);
        plane.moveForward(15);
        verifyXAndY(getCursorX(plane), getCursorY(plane), 20, 10, 0.00000001);
        plane.moveBackward(30);
        verifyXAndY(getCursorX(plane), getCursorY(plane), 0, 10, 0.00000001);
        plane.rotateLeft(90);
        plane.moveForward(15);
        verifyXAndY(getCursorX(plane), getCursorY(plane), 0, 20, 0.00000001);
        plane.moveBackward(30);
        verifyXAndY(getCursorX(plane), getCursorY(plane), 0, 0, 0.00000001);
    }


    @Test
    public void exceedingPlaneBoundsOnDiagonalMovements() {
        Plane<SimplePoint> plane = new SimplePlane(20, 20);
        plane.rotateRight(45);
        plane.moveForward(30);
        verifyXAndY(getCursorX(plane), getCursorY(plane), 20, 0, 0.00000001);
        plane.moveBackward(60);
        verifyXAndY(getCursorX(plane), getCursorY(plane), 0, 20, 0.00000001);
        plane.goHome();
        plane.rotateRight(90);
        plane.moveForward(30);
        verifyXAndY(getCursorX(plane), getCursorY(plane), 0, 0, 0.00000001);
        plane.moveBackward(60);
        verifyXAndY(getCursorX(plane), getCursorY(plane), 20, 20, 0.00000001);
    }

    @Test
    public void shouldCreateLines() {
        Plane<SimplePoint> plane = new SimplePlane(20, 20);
        plane.moveForward(5);
        assertEquals(1, countLines(plane.getShapes()));
        plane.rotateLeft(90);
        plane.moveForward(5);
        assertEquals(2, countLines(plane.getShapes()));
    }

    @Test
    public void shouldNotCreateTwoLines() {
        Plane<SimplePoint> plane = new SimplePlane(20, 20);
        plane.moveForward(2);
        assertEquals(1, countLines(plane.getShapes()));
        plane.penUp();
        plane.moveForward(2);
        assertEquals(1, countLines(plane.getShapes()));
    }


    @Test
    public void shouldCreateTriangle() {
        Plane<SimplePoint> plane = new SimplePlane(20, 20);
        plane.moveForward(5);
        plane.rotateLeft(120);
        plane.moveForward(5);
        plane.rotateLeft(120);
        plane.moveForward(5);
        assertEquals(1, countPolygons(plane.getShapes()));
        assertEquals(0, countLines(plane.getShapes()));
    }

    @Test
    public void shouldCreateSquare() {
        Plane<SimplePoint> plane = new SimplePlane(30, 30);
        plane.moveForward(5);
        plane.rotateLeft(90);
        plane.moveForward(5);
        plane.rotateLeft(90);
        plane.moveForward(5);
        plane.rotateLeft(90);
        plane.moveForward(5);
        assertEquals(1, countPolygons(plane.getShapes()));
        assertEquals(0, countLines(plane.getShapes()));
    }

    @Test
    public void shouldNotCreatePolygon() {
        Plane<SimplePoint> plane = new SimplePlane(20, 20);
        plane.moveForward(5);
        plane.rotateLeft(120);
        plane.moveForward(5);
        plane.rotateLeft(120);
        plane.penUp();
        plane.moveForward(5);
        assertEquals(0, countPolygons(plane.getShapes()));
        assertEquals(2, countLines(plane.getShapes()));
    }

    @Test
    public void shouldCreateOneLineAndOnePolygon() {
        Plane<SimplePoint> plane = new SimplePlane(30, 30);
        plane.moveForward(1);
        assertEquals(1, countLines(plane.getShapes()));
        plane.penUp();
        plane.moveForward(1);
        plane.penDown();
        plane.moveForward(5);
        plane.rotateLeft(120);
        plane.moveForward(5);
        plane.rotateLeft(120);
        plane.moveForward(5);
        assertEquals(1, countLines(plane.getShapes()));
        assertEquals(1, countPolygons(plane.getShapes()));
    }

    @Test
    public void shouldCreateLinesOfDifferentSize() {
        Plane<SimplePoint> plane = new SimplePlane(30, 30);
        plane.moveForward(2);
        plane.rotateLeft(90);
        plane.setPenSize(5);
        plane.moveForward(2);
        verifyLineSize(plane.getShapes(), 5);
        verifyLineSize(plane.getShapes(), 1);
    }

    private void verifyLineSize(List<Shape> lst, int size) {
        Set<Integer> set = lst.stream()
                .filter(s -> s instanceof Line)
                .map(s -> (Line) s)
                .map(Line::size)
                .collect(Collectors.toSet());
        assertTrue(set.contains(size));
    }

    private void verifyXAndY(double actualX, double actualY, double expectedX, double expectedY) {
        verifyXAndY(actualX, actualY, expectedX, expectedY, 0);
    }

    private void verifyXAndY(double actualX, double actualY, double expectedX, double expectedY, double delta) {
        assertEquals(expectedX, actualX, delta);
        assertEquals(expectedY, actualY, delta);
    }

    private double getCursorX(Plane<SimplePoint> plane) {
        return plane.getCursorPosition().x();
    }

    private double getCursorY(Plane<SimplePoint> plane) {
        return plane.getCursorPosition().y();
    }

    private long countLines(List<Shape>shapes) {
        return shapes.stream()
                .filter(s -> s instanceof Line)
                .count();
    }

    private long countPolygons(List<Shape>shapes) {
        return shapes.stream()
                .filter(s -> s instanceof Polygon)
                .count();
    }
}
