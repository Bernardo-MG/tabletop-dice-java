/**
 * Copyright 2014-2019 the original author or authors
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

package com.bernardomg.tabletop.dice.test.unit.roll;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.random.DiceToRollResult;
import com.bernardomg.tabletop.dice.random.NumberGenerator;

@DisplayName("DiceToRollResult generates the expected values")
public final class TestDiceToRollResult {

    public TestDiceToRollResult() {
        super();
    }

    @Test
    @DisplayName("The total roll is enerated when there is a single value")
    public final void testApply_AddSingleValue() {
        final Dice dice;
        final Integer rolled;
        final NumberGenerator generator;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate((Dice) ArgumentMatchers.any()))
                .thenReturn(Arrays.asList(5));

        rolled = new DiceToRollResult(generator).apply(dice).getTotalRoll();

        Assertions.assertEquals(new Integer(5), rolled);
    }

    @Test
    @DisplayName("The total roll is a sum of all the generated values")
    public final void testApply_AddsTotalRoll() {
        final Dice dice;
        final Integer rolled;
        final NumberGenerator generator;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(3);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate((Dice) ArgumentMatchers.any()))
                .thenReturn(Arrays.asList(1, 2, 3));

        rolled = new DiceToRollResult(generator).apply(dice).getTotalRoll();

        Assertions.assertEquals(new Integer(6), rolled);
    }

    @Test
    @DisplayName("All the rolls generated by the roller are returned")
    public final void testApply_ReturnsAllRolls() {
        final Dice dice;
        final Iterator<Integer> rolled;
        final NumberGenerator generator;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(2);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate((Dice) ArgumentMatchers.any()))
                .thenReturn(Arrays.asList(1, 2));

        rolled = new DiceToRollResult(generator).apply(dice).getAllRolls()
                .iterator();

        Assertions.assertEquals(new Integer(1), rolled.next());
        Assertions.assertEquals(new Integer(2), rolled.next());
    }

    @Test
    @DisplayName("The correct dice are returned")
    public final void testApply_ReturnsDice() {
        final Dice dice;
        final NumberGenerator generator;
        final Dice returned;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(2);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate((Dice) ArgumentMatchers.any()))
                .thenReturn(Arrays.asList(5));

        returned = new DiceToRollResult(generator).apply(dice).getDice();

        Assertions.assertEquals(new Integer(1), returned.getQuantity());
        Assertions.assertEquals(new Integer(2), returned.getSides());
    }

}
