/*
 * JLogo: A simple java application for logo language interpretation
 * Copyright (c) 2022. Enrico Ulissi
 * Use of this source code is governed by an MIT-style license that can be found in the LICENSE file or at https://opensource.org/licenses/MIT.
 */

import org.junit.jupiter.api.*;

public class SimplePlaneTest {
    @Test
    public void shouldCreatePlane() {
        SimplePlane plane = new SimplePlane(10, 10);
        Assertions.assertEquals(10, plane.getWidth());
        Assertions.assertEquals(10, plane.getHeight());
    }
}
