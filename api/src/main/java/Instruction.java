/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

import java.util.*;

/**
 * Represents an instruction in the logo language. todo: può essere ridondante
 */
public interface Instruction {
    /**
     * Returns the keyword of the instruction.
     * @return the keyword of the instruction.
     */
    String getKeyword();

    /**
     * Returns the arguments of the instruction.
     * @return the arguments of the instruction.
     */
    List<String> getArguments();
}
