/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.screen.shapes;

import it.unicam.cs.pa.jlogo115006.io.output.*;

/**
 * Represents a shape drawn by the cursor on a plane.
 */
public interface Shape extends IsExportable {
    /**
     * Return the colour of the shape.
     * @return the colour of the shape.
     */
    Colour colour();

}
