/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.io.output;

import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextExporterTest {
    @Test
    public void shouldExport() throws IOException {
        TextExporter exporter = new TextExporter("src/test/java/it/unicam/cs/pa/jlogo115006/io/output/outputTest.txt");
        List<Shape> shapes = new LinkedList<>();
        shapes.add(new Line(new SimplePoint(0, 0), new SimplePoint(10, 10), new RGBColour(255, 255, 255), 1));
        shapes.add(new Line(new SimplePoint(1, 0), new SimplePoint(20, 10), new RGBColour(3, 6, 8), 1));
        shapes.add(new Line(new SimplePoint(3, 0), new SimplePoint(30, 10), new RGBColour(15, 2, 88), 1));
        shapes.add(getSamplePolygon());
        shapes.add(new Line(new SimplePoint(4, 0), new SimplePoint(30, 10), new RGBColour(15, 2, 88), 1));
        exporter.export(shapes);
        verifyIsExpectedOutput();
    }

    private Polygon getSamplePolygon() {
        return new Polygon(List.of(new Line(new SimplePoint(0, 0), new SimplePoint(10, 10), new RGBColour(255, 255, 5), 1),
                new Line(new SimplePoint(1, 7), new SimplePoint(20, 45), new RGBColour(3, 6, 8), 3),
                new Line(new SimplePoint(5, 0), new SimplePoint(6, 10), new RGBColour(145, 2, 76), 4)), new RGBColour(255, 255, 255));
    }

    private void verifyIsExpectedOutput() throws IOException {
            String actual = Files.readString(Paths.get("src/test/java/it/unicam/cs/pa/jlogo115006/io/output/outputTest.txt"));
            assertEquals(getExpectedOutput().replaceAll("\\s+",""), actual.replaceAll("\\s+",""));

    }

    private String getExpectedOutput() {
        return """
                    Line start: (0.0; 0.0) end: (10.0; 10.0) colour: rgb(255,255,255) Size: 1
                    Line start: (1.0; 0.0) end: (20.0; 10.0) colour: rgb(3,6,8) Size: 1
                    Line start: (3.0; 0.0) end: (30.0; 10.0) colour: rgb(15,2,88) Size: 1
                    Polygon Colour: rgb(255,255,255)
                    \tPolygon lines:
                    \t\tLine start: (0.0; 0.0) end: (10.0; 10.0) colour: rgb(255,255,5) Size: 1
                    \t\tLine start: (1.0; 7.0) end: (20.0; 45.0) colour: rgb(3,6,8) Size: 3
                    \t\tLine start: (5.0; 0.0) end: (6.0; 10.0) colour: rgb(145,2,76) Size: 4
                    \t\t
                    Line start: (4.0; 0.0) end: (30.0; 10.0) colour: rgb(15,2,88) Size: 1
                    """;
    }
}
