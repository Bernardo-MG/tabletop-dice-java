/**
 * Copyright 2014-2016 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.wandrell.tabletop.dice.test.unit.random;

import java.util.Collection;
import java.util.LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.random.DefaultNumberGenerator;
import com.wandrell.tabletop.dice.random.NumberGenerator;

/**
 * Units tests for {@code DefaultNumberGenerator}, checking that it generates
 * values as expected.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The generated numbers are kept inside the expected interval.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestDefaultNumberGenerator {

    /**
     * Default constructor.
     */
    public TestDefaultNumberGenerator() {
        super();
    }

    /**
     * Tests that the generated numbers are kept inside the expected interval.
     */
    @Test
    public final void testRoll_ValuesInBounds() {
        final NumberGenerator generator;   // Tested generator
        final Integer lowerLimit;          // Lowest allowed number
        final Integer upperLimit;          // Highest allowed number
        final Collection<Integer> numbers; // Generated numbers
        final Integer times;               // Times to run the test loop
        final Integer max;                 // Max for the number generation

        generator = new DefaultNumberGenerator();

        times = 100;
        max = 10;
        lowerLimit = 1;
        upperLimit = max;

        numbers = new LinkedList<Integer>();
        for (Integer i = 0; i < times; i++) {
            numbers.add(generator.generate(max));
        }

        for (final Integer number : numbers) {
            Assert.assertTrue(number >= lowerLimit);
            Assert.assertTrue(number <= upperLimit);
        }
    }

}