
package com.bernardomg.tabletop.dice.visitor;

import java.util.ArrayList;
import java.util.Collection;

import com.bernardomg.tabletop.dice.DefaultDice;
import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.operand.ConstantOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;

public final class DiceAccumulator
        implements NotationAccumulator<Iterable<Dice>> {

    private final Collection<Dice> dice     = new ArrayList<>();

    private Boolean                negative = false;

    public DiceAccumulator() {
        super();
    }

    @Override
    public final void binaryOperation(final BinaryOperation exp) {
        if (exp instanceof SubtractionOperation) {
            negative = true;
        } else {
            negative = false;
        }
    }

    @Override
    public final void constantOperand(final ConstantOperand exp) {
        negative = false;
    }

    @Override
    public final void diceOperand(final DiceOperand exp) {
        if (negative) {
            dice.add(reverse(exp.getDice()));
        } else {
            dice.add(exp.getDice());
        }
    }

    @Override
    public final Iterable<Dice> getValue() {
        return dice;
    }

    @Override
    public final void reset() {
        negative = false;
        dice.clear();
    }

    /**
     * Reverses the sign of a dice, changing positive values to negatives, and
     * viceversa.
     * 
     * @param dice
     *            dice to reverse
     * @return dice with the sign reversed
     */
    private final Dice reverse(final Dice dice) {
        return new DefaultDice(0 - dice.getQuantity(), dice.getSides());
    }

}
