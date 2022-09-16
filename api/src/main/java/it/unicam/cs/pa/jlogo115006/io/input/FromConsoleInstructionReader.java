/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.io.input;

import java.util.*;

public class FromConsoleInstructionReader implements InstructionReader {
    private final java.util.Scanner scanner;

    public FromConsoleInstructionReader(Scanner scanner) {
        this.scanner = Objects.requireNonNull(scanner);
    }

    @Override
    public java.util.List<String> readLines() {
        return scanner.tokens().toList();
    }

    @Override
    public String readLine() {
        return scanner.hasNextLine() ? scanner.nextLine() : "";
    }
}
