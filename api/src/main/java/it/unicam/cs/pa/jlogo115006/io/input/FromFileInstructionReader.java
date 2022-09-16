/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.io.input;

import java.io.*;
import java.util.*;

/**
 * This class will read instructions from a file
 */
public class FromFileInstructionReader implements InstructionReader {
    private final LineNumberReader reader;

    /**
     * Creates a new Instruction reader that reads from the given file name.
     *
     * @param path the path of the file to read.
     * @throws FileNotFoundException if the file does not exist, is a directory rather than a regular file,
     *                               or for some other reason cannot be opened for reading.
     */
    public FromFileInstructionReader(String path) throws FileNotFoundException {
        this.reader = new LineNumberReader(new FileReader(path));
    }

    /**
     * Reads all the instruction from the input source and returns them as a list.
     *
     * @return instructions read from the input source.
     */
    @Override
    public List<String> readLines() {
        return reader.lines().toList();
    }

    /**
     * Reads a single instruction from the input source.
     *
     * @return the instruction read.
     */
    @Override
    public String readLine() {
        try {
            String line = reader.readLine();
            return line == null ? "" : line;
        } catch (IOException e) {
            throw new RuntimeException("Error while reading from file message: " + e);
        }
    }
}
