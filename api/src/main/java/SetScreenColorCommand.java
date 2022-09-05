/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */


import java.util.List;
import java.util.stream.*;

/**
 * This class represents a command that change the screen color.
 */
public class SetScreenColorCommand implements Command {


    private final Colour newBackgroundColour;


    public SetScreenColorCommand(String arg1, String arg2, String arg3) {
        this(List.of(arg1, arg2, arg3));
    }

    public SetScreenColorCommand(List<String> args) {
        List<Integer> values = getIntegerFromStrings(args);
        newBackgroundColour = new RGBColour(values.get(0), values.get(1), values.get(2));
    }


    /**
     * Executes the command with its arguments in the given plane.
     *
     * @param plane the plane on which the command is executed.
     */
    @Override
    public void execute(Plane<Point> plane) {
        plane.setBackgroundColour(newBackgroundColour);
    }

    /**
     * Returns a list containing all the integer values.
     *
     * @param args command arguments.
     * @throws IllegalArgumentException if the arguments are of a different amount to that requested
     * @throws NumberFormatException    if the arguments are not numbers.
     */
    private List<Integer> getIntegerFromStrings(List<String> args) {
        if (args.size() != 3) throw new IllegalArgumentException("Wrong number of arguments");
        return args.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
