package com.wandrell.tabletop.dice.parser;

import com.wandrell.tabletop.dice.notation.DiceExpression;

public interface DiceExpressionParser {

	public DiceExpression parse(final String string);

}
