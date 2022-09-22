/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.io.output;

import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.commands.movement.*;
import it.unicam.cs.pa.jlogo115006.executor.*;
import it.unicam.cs.pa.jlogo115006.io.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileWriterExporterTest {
    @Test
    void shouldExport() throws IOException {
        FileWriterExporter exporter = new FileWriterExporter("src/test/resources/textFiles/outputTest.txt");
        Plane<SimplePoint> plane = new SimplePlane(50, 50);
        Designer designer = new SimpleDesigner(plane);
        InstructionInterpreter interpreter = new SimpleInstructionInterpreter();
        designer.execute(drawSquareCommands(interpreter));
        designer.execute(new MoveCommand(List.of("Forward", "10")));
        exporter.export(plane);
        isExpectedOutput();
    }

    private void isExpectedOutput() throws FileNotFoundException {
        LineNumberReader reader = new LineNumberReader(new FileReader("src/test/resources/textFiles/outputTest.txt"));
        assertEquals(getExpectedOutput(), reader.lines().collect(Collectors.toList()));
    }

    private List<String> getExpectedOutput() {
        return List.of(
                "SIZE 50.0 50.0 255 255 255",
                "POLYGON 4 255 255 255",
                "25.0 15.000000000000002 0 0 0 1",
                "35.0 15.0 0 0 0 1",
                "35.0 25.0 0 0 0 1",
                "25.0 25.0 0 0 0 1",
                "",
                "LINE 25.0 25.0 25.0 35.0 0 0 0 1"
        );
    }

    private List<Command> drawSquareCommands(InstructionInterpreter interpreter) {
        return interpreter.createCommands(
                List.of(
                        "forward 10",
                        "right 90",
                        "forward 10",
                        "right 90",
                        "forward 10",
                        "right 90",
                        "forward 10"
                )
        );
    }

}
