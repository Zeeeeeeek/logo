/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.io;

import it.unicam.cs.pa.jlogo115006.screen.*;
import it.unicam.cs.pa.jlogo115006.screen.shapes.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleInstructionInterpreterTest {
    @Test
    public void shouldCreateCommands() {
        Plane<SimplePoint> plane = new SimplePlane(50, 50);
        InstructionInterpreter interpreter = new SimpleInstructionInterpreter();
        getSampleInstructionAsList().forEach(System.out::println);
    }


    private List<String> getSampleInstructionAsList() {
        return Arrays.asList(getSampleInstruction().split("\\R"));
    }

    private String getSampleInstruction() {
        return "forward 10\nrotateleft 90";
    }
}
