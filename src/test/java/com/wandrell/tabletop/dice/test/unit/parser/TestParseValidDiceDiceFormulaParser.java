
package com.wandrell.tabletop.dice.test.unit.parser;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.dice.notation.operation.DiceOperand;
import com.wandrell.tabletop.dice.parser.DiceExpressionParser;
import com.wandrell.tabletop.dice.test.util.conf.factory.parameter.DiceValuesTestParametersFactory;

public final class TestParseValidDiceDiceFormulaParser {

    protected static final String                DATA = "data";

    private final Parser<String, DiceExpression> parser;

    @DataProvider(name = DATA)
    public final static Iterator<Object[]> getData() throws Exception {
        return DiceValuesTestParametersFactory.getInstance().getDiceAndText();
    }

    {
        parser = new DiceExpressionParser();
    }

    public TestParseValidDiceDiceFormulaParser() {
        super();
    }

    @Test(dataProvider = DATA)
    public final void testParse_Dice_Valid(final String text,
            final Integer quantity, final Integer sides) {
        final DiceExpression formula;
        final DiceOperand dice;

        formula = parser.parse(text);

        dice = (DiceOperand) formula.getComponents().iterator().next();

        Assert.assertEquals(dice.getDice().getDice().getQuantity(), quantity);
        Assert.assertEquals(dice.getDice().getDice().getSides(), sides);
    }

}