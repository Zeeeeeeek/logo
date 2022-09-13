/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006;

import it.unicam.cs.pa.jlogo115006.io.input.*;
import it.unicam.cs.pa.jlogo115006.screen.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to JLogo!\nInsert plane width:");
        double planeWidth = scanner.nextDouble();
        System.out.println("Insert plane height:");
        double planeHeight = scanner.nextDouble();
        System.out.println("Select your input mode:\n1 File\n2 Console");
        switch (scanner.next()) {
            case "2" -> {
                System.out.println("Please insert output file path:");
                String outputPath = scanner.next();
                Controller controller = new Controller(new SimplePlane(planeWidth, planeHeight), new FromConsoleInstructionReader(scanner), outputPath);
                System.out.println("You can now insert your instructions, one per line. When you are done, type \"exit\".");
                while (true) {
                    System.out.println("Insert instruction:");
                    if (scanner.nextLine().equals("exit")) break;
                    controller.runSingleInstruction();
                }
                controller.export();
            }
            case "1" -> {
                System.out.println("Insert input path:");
                String inputPath = scanner.next();
                System.out.println("Insert output path:");
                String outputPath = scanner.next();
                Controller controller = new Controller(new SimplePlane(planeWidth, planeHeight), inputPath, outputPath);
                controller.run();
                controller.export();
            }
            default -> throw new IllegalArgumentException("Invalid mode");
        }
        System.out.println("Done!");
        scanner.close();
    }
}