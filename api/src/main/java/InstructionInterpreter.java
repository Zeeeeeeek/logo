/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

/**
 * represents an interpreter that, given a string, returns a command.
 */
public interface InstructionInterpreter {
    Command createCommand(String instruction);
}
