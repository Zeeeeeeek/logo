/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.io.output;

/**
 * This class guarantees the exportability of a certain element
 */

public interface IsExportable {
    /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    String export();
}
