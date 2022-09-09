/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.io;

import it.unicam.cs.pa.jlogo115006.commands.*;

import java.util.*;

/**
 * Represents an interpreter that, given a string, returns a command.
 */
public interface InstructionInterpreter {

    /**
     * Returns a list of commands that corresponds to the given instructions.
     * @param instructions the instructions to interpret.
     * @return a list of commands that corresponds to the given instructions.
     */
    List<Command> createCommands(List<String> instructions);



    /**
     * Returns a command that corresponds to the given instruction.
     * @param instruction the instruction to interpret.
     * @return a command that corresponds to the given instruction.
     */
    Command createCommand(String instruction);
}
