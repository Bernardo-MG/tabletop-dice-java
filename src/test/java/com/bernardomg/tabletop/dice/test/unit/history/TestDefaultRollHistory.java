/**
 * Copyright 2014-2020 the original author or authors
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

package com.bernardomg.tabletop.dice.test.unit.history;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.history.DefaultRollHistory;
import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.history.RollResult;

@DisplayName("Tests for DefaultRollHistory")
public final class TestDefaultRollHistory {

    public TestDefaultRollHistory() {
        super();
    }

    @Test
    @DisplayName("The text representation matches the received one")
    public final void testToString() {
        final RollHistory history;
        final Collection<RollResult> results;

        results = new ArrayList<>();

        history = new DefaultRollHistory(results, "1+2", 0);

        Assertions.assertEquals("1+2", history.toString());
    }

}
