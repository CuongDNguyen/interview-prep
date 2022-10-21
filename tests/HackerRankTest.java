import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerRankTest {

    @Test
    public void ceaserCipherCase() {

        String testString = "www.abc.xy";
        int testK = 87;
        String result = life.caesarCipher(testString, testK);
        Assert.assertEquals(result, "fff.jkl.gh");
    }

    @Test
    public void flippingMatrixCase() {
        Integer[][] matrix = new Integer[][]{
                {112, 42, 83, 119},
                {56,125,56,49},
                {15, 78, 101, 43},
                {62, 98, 114, 108}
        };

        List<List<Integer>> matrixList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            matrixList.add(Arrays.asList(matrix[i]));
        }

        int flippingMatrixSum = life.flippingMatrix(matrixList);
        Assert.assertEquals(flippingMatrixSum, 414);
    }

    @Test
    public void ascendingGrid() {
       List<String> testList = new ArrayList<>();
       testList.add("eabc");
        testList.add("fghij");
        testList.add("olkmn");
        testList.add("trpqs");
        testList.add("xywuv");
        System.out.println(life.gridChallenge(testList));
    }

}
