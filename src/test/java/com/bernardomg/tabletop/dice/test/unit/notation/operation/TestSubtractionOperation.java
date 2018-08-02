/**
 * Copyright 2014-2017 the original author or authors
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

package com.bernardomg.tabletop.dice.test.unit.notation.operation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;
import com.bernardomg.tabletop.dice.notation.transformer.RollerTransformer;

/**
 * Unit tests for {@link SubtractionOperation}, checking that it works as
 * expected with its operands.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestSubtractionOperation {

    /**
     * Default constructor.
     */
    public TestSubtractionOperation() {
        super();
    }

    /**
     * Verifies that the text expression is generated correctly.
     */
    @Test
    public final void testTextExpression() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        left = Mockito.mock(DiceNotationExpression.class);
        Mockito.when(left.getExpression()).thenReturn("1");

        right = Mockito.mock(DiceNotationExpression.class);
        Mockito.when(right.getExpression()).thenReturn("2");

        operation = new SubtractionOperation(left, right);

        Assertions.assertEquals("1-2", operation.getExpression());
    }

    /**
     * Verifies that the value is generated correctly.
     */
    @Test
    public final void testValue() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        left = Mockito.mock(DiceNotationExpression.class);
        Mockito.when(left.transform(ArgumentMatchers.any())).thenReturn(1);

        right = Mockito.mock(DiceNotationExpression.class);
        Mockito.when(right.transform(ArgumentMatchers.any())).thenReturn(2);

        operation = new SubtractionOperation(left, right);

        Assertions.assertEquals(new Integer(-1),
                operation.transform(new RollerTransformer()));
    }

}