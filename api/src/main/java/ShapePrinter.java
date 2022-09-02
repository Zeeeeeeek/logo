/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

import java.util.*;

/**
 * This class has the responsibility to print shapes
 */
public interface ShapePrinter {
    /**
     * Prints a shape list
     * @param shapes the list of shapes to print
     */
    void print(List<Shape> shapes);
}
