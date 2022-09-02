/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

import java.util.*;

/**
 * Represents an element that reads instruction from an input source.
 */
public interface InstructionReader {

    /**
     * Reads all the instruction from the input source and returns them as a list.
     * @return instructions read from the input source.
     */
    List<String> readLines();
}
