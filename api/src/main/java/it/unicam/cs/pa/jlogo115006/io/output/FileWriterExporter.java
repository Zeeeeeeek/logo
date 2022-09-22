/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.io.output;

import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.io.*;
import java.util.logging.Logger;

/**
 * This class will export a plane in a text file.
 */
public class FileWriterExporter implements Exporter<Plane<? extends Point>> {
    private static final Logger logger = Logger.getLogger(FileWriterExporter.class.getName());
    private final BufferedWriter writer;
    /**
     * Creates a new text exporter that will write in the specified file.
     * @param path the path of the file to write.
     * @throws IOException if the file is a directory, can't be created or can't be opened for any other reason.
     */
    public FileWriterExporter(String path) throws IOException {
        this.writer = new BufferedWriter(new FileWriter(path));
    }

    /**
     * Exports the element
     *
     * @param toBeExported the element to be exported
     */
    @Override
    public void export(Plane<? extends Point> toBeExported) {
        try {
            writer.write(toBeExported.export());
        } catch (IOException e) {
            logger.severe("Error while writing to file\n" + e.getMessage());
        }
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

