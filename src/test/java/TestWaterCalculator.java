import org.example.WaterCalculator;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestWaterCalculator {

    @Test
    public void validateLandscape() {
        WaterCalculator waterCalculator = new WaterCalculator();

        int[] emptyLandscape = {};
        int[] tooBigLandscape = {5, 4, 0, 32001, 1, 77};
        int[] negativeLandscape = {17, 2, 3, -3, 1, 15, 0};

        long emptyResult = waterCalculator.calculateWaterAmount(emptyLandscape);
        long tooBigResult = waterCalculator.calculateWaterAmount(tooBigLandscape);
        long negativeResult = waterCalculator.calculateWaterAmount(negativeLandscape);

        assertEquals(0, emptyResult);
        assertEquals(0, tooBigResult);
        assertEquals(0, negativeResult);
    }

    @Test
    public void testFillWater() {
        WaterCalculator waterCalculator = new WaterCalculator();

        int[] landscape1 = {1};
        int[] landscape2 = {1, 0, 1};
        int[] landscape3 = {2, 0, 2};
        int[] landscape4 = {5, 2, 3, 4, 5, 4, 0, 3, 1};
        int[] landscape5 = {5, 2, 3, 4, 5, 4, 0, 3, 1, 44, 27};

        long result1 = waterCalculator.calculateWaterAmount(landscape1);
        long result2 = waterCalculator.calculateWaterAmount(landscape2);
        long result3 = waterCalculator.calculateWaterAmount(landscape3);
        long result4 = waterCalculator.calculateWaterAmount(landscape4);
        long result5 = waterCalculator.calculateWaterAmount(landscape5);

        assertEquals(0, result1);
        assertEquals(1, result2);
        assertEquals(2, result3);
        assertEquals(9, result4);
        assertEquals(18, result5);
    }
}
