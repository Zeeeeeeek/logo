/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

package it.unicam.cs.pa.jlogo115006;

import it.unicam.cs.pa.jlogo115006.screen.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller(new SimplePlane(100, 100),
                "api/src/main/java/it/unicam/cs/pa/jlogo115006/input.txt",
                "api/src/main/java/it/unicam/cs/pa/jlogo115006/output.txt");
        controller.run();
        controller.export();
    }
}
