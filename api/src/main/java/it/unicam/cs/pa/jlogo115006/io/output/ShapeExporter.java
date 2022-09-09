/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.io.output;

import it.unicam.cs.pa.jlogo115006.screen.shapes.*;

import java.util.*;

/**
 * This class has the responsibility to export shapes in a specific format.
 */
public interface ShapeExporter {
    /**
     * Prints a shape list
     * @param shapes the list of shapes to print
     */
    void export(List<Shape> shapes);
}
