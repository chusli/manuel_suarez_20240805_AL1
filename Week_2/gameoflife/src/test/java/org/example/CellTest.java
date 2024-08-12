package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CellTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void toggleStateTest(boolean startingCellState) {
        Cell cell = new Cell(startingCellState);

        cell.toggle();

        assertThat(cell.getAlive()).isNotEqualTo(startingCellState);
    }

}
