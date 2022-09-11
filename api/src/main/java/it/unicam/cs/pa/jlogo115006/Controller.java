/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006;

import it.unicam.cs.pa.jlogo115006.io.*;
import it.unicam.cs.pa.jlogo115006.io.input.*;
import it.unicam.cs.pa.jlogo115006.io.output.*;
import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.io.*;
import java.util.*;

/**
 * This class is used to control the execution of the program.
 */
public class Controller {
    private final InstructionInterpreter interpreter;
    private final InstructionReader reader;
    private final Exporter<Plane<? extends Point>> exporter;
    private final Designer designer;

    /**
     * Creates a new Controller with default elements with the given plane.
     * @param plane the plane on which the default designer will work.
     * @param inputPath the path of the file from which the instructions will be read.
     * @param outputPath the path of the file where the plane will be exported.
     *
     * @throws IOException if an I/O error occurs.
     */
    public Controller(Plane<? extends Point> plane, String inputPath, String outputPath) throws IOException {
        this(
                new SimpleInstructionInterpreter(),
                new FromFileInstructionReader(inputPath),
                new FileWriterExporter(outputPath),
                new SimpleDesigner(plane)
        );
    }

    /**
     * Creates a new controller.
     * @param interpreter the interpreter to use.
     * @param reader the reader to use.
     * @param exporter the exporter to use.
     * @param designer the designer to use.
     */
    public Controller(InstructionInterpreter interpreter, InstructionReader reader, Exporter<Plane<? extends Point>> exporter, Designer designer) {
        this.interpreter = Objects.requireNonNull(interpreter);
        this.reader = Objects.requireNonNull(reader);
        this.exporter = Objects.requireNonNull(exporter);
        this.designer = Objects.requireNonNull(designer);
    }

    /**
     * Runs a single instruction.
     */
    public void runSingleInstruction() {
        designer.execute(interpreter.createCommand(reader.readLine()));
    }

    /**
     * Runs all the instructions.
     */
    public void run() {
        designer.execute(interpreter.createCommands(reader.readLines()));
    }

    /**
     * Export the plane on which the designer is working.
     */
    public void export() {
        exporter.export(designer.getPlane());
    }
}
