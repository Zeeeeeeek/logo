/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006.io;

import it.unicam.cs.pa.jlogo115006.commands.*;
import it.unicam.cs.pa.jlogo115006.commands.movement.*;
import it.unicam.cs.pa.jlogo115006.commands.pen.*;
import it.unicam.cs.pa.jlogo115006.commands.screen.*;

import java.util.*;

/**
 * Represents an interpreter that, received all the instructions as a String list, returns a list of commands.
 */
public class SimpleInstructionInterpreter implements InstructionInterpreter {

    /**
     * Returns a list of commands that corresponds to the given instructions.
     *
     * @param instructions the instructions, each one has a keyword and a number of arguments.
     * @return a list of commands that corresponds to the given instructions.
     */
    @Override
    public List<Command> createCommands(List<String> instructions) {
        return instructions.stream()
                .map(this::createCommand)
                .toList();
    }

    /**
     * Returns a command that corresponds to the given instruction.
     *
     * @return a command that corresponds to the given instruction.
     */
    @Override
    public Command createCommand(String instruction) {
        List<String> args = splitInstructionArgs(instruction);
        return switch (args.get(0).toUpperCase()) {
            case "FORWARD" -> new MoveCommand(List.of("FORWARD", args.get(1)));
            case "BACKWARD" -> new MoveCommand(List.of("BACKWARD", args.get(1)));
            case "LEFT" -> new RotateCommand(List.of("LEFT", args.get(1)));
            case "RIGHT" -> new RotateCommand(List.of("RIGHT", args.get(1)));
            case "CLEARSCREEN" -> new ClearScreenCommand();
            case "HOME" -> new HomeCommand();
            case "PENUP" -> new ChangePenStatusCommand("UP");
            case "PENDOWN" -> new ChangePenStatusCommand("DOWN");
            case "SETPENCOLOR" -> new SetPenColorCommand(List.of(args.get(1), args.get(2), args.get(3)));
            case "SETFILLCOLOR" -> new SetFillColorCommand(List.of(args.get(1), args.get(2), args.get(3)));
            case "SETSCREENCOLOR" -> new SetScreenColorCommand(List.of(args.get(1), args.get(2), args.get(3)));
            case "SETPENSIZE" -> new SetPenSizeCommand(args.get(1));
            case "REPEAT" -> new RepeatCommand(args.get(1), createCommandsForRepeatCommand(args.subList(2, args.size())));
            default -> throw new IllegalArgumentException("Invalid instruction: " + instruction);
        };
    }

    /**
     * Utility method that create a list of commands fot a repeat command.
     *
     * @param instructions the instructions to format
     * @return a list of instructions formatted
     */
    private List<Command> createCommandsForRepeatCommand(List<String> instructions) {
        List<Command> commands = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        for (int i = 1; i < instructions.size() - 1; i++) {
            if (isNumber(instructions.get(i))) currentString.append(" ").append(instructions.get(i));
             else {
                if (!currentString.isEmpty()) {
                    commands.add(createCommand(currentString.toString()));
                    currentString.setLength(0);
                }
                if(instructions.get(i).equalsIgnoreCase("repeat") && i < instructions.size() -3) {
                    int lastIndex = getLastIndexOfInnerRepeat(instructions);
                    List<Command> innerCommands = createCommandsForRepeatCommand(instructions.subList(i + 2, lastIndex + 1));
                    commands.add(new RepeatCommand(instructions.get(i + 1), innerCommands));
                    i = lastIndex;
                } else currentString.append(instructions.get(i));
            }
        }
        if (!currentString.isEmpty()) commands.add(createCommand(currentString.toString()));
        return commands;
    }
    private int getLastIndexOfInnerRepeat(List<String> instructions) {
        int lastIndex = instructions.size() -2; //ignore the last ]
        while (lastIndex > 0) {
            if (instructions.get(lastIndex).equals("]")) {
                return lastIndex;
            }
            lastIndex--;
        }
        return -1;
    }

    private boolean isNumber(String s) {
        return s.matches("^\\d+(\\.\\d+)?$");
    }

    private List<String> splitInstructionArgs(String instruction) {
        return List.of(instruction.split("\\s+"));
    }
}
