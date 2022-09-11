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
        String defaultPath = "api/src/main/java/it/unicam/cs/pa/jlogo115006/textFiles/";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to JLogo!\nInsert plane width:");
        double planeWidth = scanner.nextDouble();
        System.out.println("Insert plane height:");
        double planeHeight = scanner.nextDouble();
        System.out.println("You wish to run the program in console mode? (y/n)");
        switch (scanner.next()) {
            case "Y","y" -> {
                System.out.println("Please insert output file path:");
                String outputPath = scanner.next();
                if(outputPath.equals("")) outputPath = defaultPath + "output.txt";
                Controller controller = new Controller(new SimplePlane(planeWidth, planeHeight), new FromConsoleInstructionReader(scanner), outputPath);
                System.out.println("You can now insert your instructions, one per line. When you are done, type \"exit\".");
                while (true) {
                    System.out.println("Insert instruction:");
                    if (scanner.nextLine().equals("exit")) break;
                    controller.runSingleInstruction();
                }
                controller.export();
            }
            case "N","n" -> {
                System.out.println("Insert input path or press ENTER to use default path:");
                String inputPath = scanner.next();
                if(inputPath.equals("")) inputPath = defaultPath + "input.txt";
                System.out.println("Insert output path or press ENTER to use default path:");
                String outputPath = scanner.next();
                if(outputPath.equals("")) outputPath = defaultPath + "output.txt";
                Controller controller = new Controller(new SimplePlane(planeWidth, planeHeight), inputPath, outputPath);
                controller.run();
                controller.export();
            }
            default -> throw new IllegalArgumentException("Invalid input");
        }
        System.out.println("Done!");
        scanner.close();
    }
}
