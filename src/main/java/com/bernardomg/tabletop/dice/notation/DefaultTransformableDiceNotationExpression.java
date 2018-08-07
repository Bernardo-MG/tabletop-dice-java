/**
 * Copyright 2014-2018 the original author or authors
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

package com.bernardomg.tabletop.dice.notation;

import static com.google.common.base.Preconditions.checkNotNull;

import com.bernardomg.tabletop.dice.notation.transformer.DiceNotationTransformer;
import com.bernardomg.tabletop.dice.notation.transformer.RollerTransformer;
import com.bernardomg.tabletop.dice.roller.Roller;

/**
 * Default implementation of the transformable dice notation expression.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class DefaultTransformableDiceNotationExpression
        implements TransformableDiceNotationExpression {

    /**
     * Transformer used for the {@link #roll()} operation.
     */
    private final DiceNotationTransformer<Integer> rollerTransformer;

    /**
     * Wrapped expression, which is the root of the dice notation expression.
     */
    private final DiceNotationExpression           root;

    /**
     * Constructs an expression wrapping the received one.
     * 
     * @param expression
     *            expression to wrap
     */
    public DefaultTransformableDiceNotationExpression(
            final DiceNotationExpression expression) {
        super();

        root = checkNotNull(expression,
                "Received a null pointer as root expression");
        rollerTransformer = new RollerTransformer();
    }

    /**
     * Constructs an expression wrapping the received one, and using the
     * received roller for simulating rolls for the {@link #roll()} operation.
     * 
     * @param expression
     *            expression to wrap
     * @param roller
     *            roller for simulating rolls
     */
    public DefaultTransformableDiceNotationExpression(
            final DiceNotationExpression expression, final Roller roller) {
        super();

        root = checkNotNull(expression,
                "Received a null pointer as root expression");
        rollerTransformer = new RollerTransformer(roller);
    }

    @Override
    public final String getExpression() {
        return getRoot().getExpression();
    }

    @Override
    public final DiceNotationExpression getRoot() {
        return root;
    }

    @Override
    public final Integer roll() {
        return transform(rollerTransformer);
    }

    @Override
    public final <V> V transform(final DiceNotationTransformer<V> interpreter) {
        return interpreter.transform(getRoot());
    }

}
