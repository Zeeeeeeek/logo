/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.io.input;

import it.unicam.cs.pa.jlogo115006.*;
import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.io.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FromFileInstructionReaderTest {
    @Test
    public void shouldReadLineByLine() throws FileNotFoundException {
        FromFileInstructionReader reader = new FromFileInstructionReader("src/test/java/it/unicam/cs/pa/jlogo115006/io/input/inputTest.txt");
        assertEquals("FORWARD 10", reader.readLine());
        assertEquals("LEFT 30", reader.readLine());
        assertEquals("PENUP", reader.readLine());
        assertEquals("SETPENCOLOR 25 25 25", reader.readLine());
    }

    @Test
    public void shouldReadAllLines() throws FileNotFoundException {
        FromFileInstructionReader reader = new FromFileInstructionReader("src/test/java/it/unicam/cs/pa/jlogo115006/io/input/inputTest.txt");
        List<String> expected = List.of("FORWARD 10", "LEFT 30", "PENUP", "SETPENCOLOR 25 25 25");
        List<String> actual = reader.readLines();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateMultipleRepeatCommands() throws FileNotFoundException {
        FromFileInstructionReader reader = new FromFileInstructionReader("src/test/java/it/unicam/cs/pa/jlogo115006/io/input/inputTest2.txt");
        InstructionInterpreter interpreter = new SimpleInstructionInterpreter();
        Plane<SimplePoint> plane = new SimplePlane(100, 100);
        Designer designer = new SimpleDesigner(plane);
        List<Command> cmds = interpreter.createCommands(reader.readLines());
        designer.execute(cmds);
        assertEquals(66, plane.getCursorPosition().x());
    }
}
