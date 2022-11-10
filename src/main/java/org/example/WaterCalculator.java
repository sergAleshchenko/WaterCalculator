package org.example;

public class WaterCalculator {
    private boolean validateCorrectness(int[] landscape) {
        if (landscape.length == 0) {
            return false;
        }

        for (int column = 0; column < landscape.length; column++) {
            if (landscape[column] < 0 || landscape[column] > 32000) {
                return false;
            }
        }
        return true;
    }

    // O(max(maxHeight, N)), O(1)
    public long calculateWaterAmount(int[] landscape) {
        if (!validateCorrectness(landscape)) {
            return 0;
        }

        int numberOfBlocks = 0;
        int maxHeight = Integer.MIN_VALUE;

        for (int column = 0; column < landscape.length; column++) {
            maxHeight = Integer.max(maxHeight, landscape[column]);
            numberOfBlocks += landscape[column];
        }

        int totalWater = 0;
        int leftPointer = 0;
        int rightPointer = landscape.length - 1;

        for (int height = 1; height <= maxHeight; height++) {
            while (landscape[leftPointer] < height) {
                leftPointer += 1;
            }

            while (landscape[rightPointer] < height) {
                rightPointer -= 1;
            }

            totalWater += (rightPointer - leftPointer + 1);
        }
        totalWater -= numberOfBlocks;

        return totalWater;
    }


//    // O(N), O(N)
//    public long calculateWaterAmount(int[] landscape) {
//        if (!validateCorrectness(landscape)) {
//            return 0;
//        }
//
//        int answer = 0;
//        int size = landscape.length;
//
//        int[] leftMax = new int[size];
//        int[] rightMax = new int[size];
//
//        leftMax[0] = landscape[0];
//        for (int column = 1; column < size; column++) {
//            leftMax[column] = Math.max(landscape[column], leftMax[column - 1]);
//        }
//
//        rightMax[size - 1] = landscape[size - 1];
//        for (int column = size - 2; column >= 0; column--) {
//            rightMax[column] = Math.max(landscape[column], rightMax[column + 1]);
//        }
//
//        for (int column = 1; column < size - 1; column++) {
//            answer += Math.min(leftMax[column], rightMax[column]) - landscape[column];
//        }
//
//        return answer;
//    }

    public static void main(String[] args) {
        WaterCalculator waterCalculator = new WaterCalculator();

        int[] landscape = {5, 2, 3, 4, 5, 4, 0, 3, 1};

        System.out.println(waterCalculator.calculateWaterAmount(landscape));
    }
}