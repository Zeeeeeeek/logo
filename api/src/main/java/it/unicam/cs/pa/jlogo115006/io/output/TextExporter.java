/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.io.output;

import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 * This class will export shapes and write them in a text file.
 */
public class TextExporter implements ShapeExporter {
    private final static Logger logger = Logger.getLogger(TextExporter.class.getName());
    private final BufferedWriter writer;
    /**
     * Creates a new text exporter that will write in the specified file.
     * @param path the path of the file to write.
     * @throws IOException if the file is a directory, can't be created or can't be opened for any other reason.
     */
    public TextExporter(String path) throws IOException {
        this.writer = new BufferedWriter(new FileWriter(path));
    }



    /**
     * Prints a shape list
     *
     * @param shapes the list of shapes to print
     */
    @Override
    public void export(List<Shape> shapes) {
            shapes.forEach(
                    shape -> {
                        try {
                            writer.write(shape.export());
                            writer.newLine();
                        } catch (IOException e) {
                            logger.severe("Error while writing to file\n" + e.getMessage());
                            throw new RuntimeException(e);
                        }
                    }
            );
        close();
    }

    private void close() {
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

