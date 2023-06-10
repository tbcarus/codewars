package SnailSort;

/*Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.

        array = [[1,2,3],
        [4,5,6],
        [7,8,9]]
        snail(array) #=> [1,2,3,6,9,8,7,4,5]
        For better understanding, please follow the numbers of the next array consecutively:

        array = [[1,2,3],
        [8,9,4],
        [7,6,5]]
        snail(array) #=> [1,2,3,4,5,6,7,8,9]
        This image will illustrate things more clearly:


        NOTE: The idea is not sort the elements from the lowest value to the highest; the idea is to traverse the 2-d array in a clockwise snailshell pattern.

        NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].*/

public class Snail {

    public static int[] snail(int[][] array) {
        int n = array[0].length;
        int[] result = new int[n * n];
        int index = 0;
        int direction = 0; // 0 - right, 1 - down, 2 - left, 3 - up
        int cornerP = n; // номер углового элемента
        int cornerM = 0; // номер углового элемента
        int row = 0;
        int col = 0;

        for (int i = 0; i < 2 * n - 1; i++) {
            switch (direction) {
                case 0:
                    for (; col < cornerP; col++) {
                        result[index++] = array[row][col];
                    }
                    col--;
                    row++;
                    direction = 1;
                    break;

                case 1:
                    for (; row < cornerP; row++) {
                        result[index++] = array[row][col];
                    }
                    row--;
                    col--;
                    cornerP--;
                    direction = 2;
                    break;
                case 2:
                    for(; col >= cornerM; col--) {
                        result[index++] = array[row][col];
                    }
                    col++;
                    row--;
                    cornerM++;
                    direction = 3;
                    break;
                case 3:
                    for(; row >= cornerM; row--) {
                        result[index++] = array[row][col];
                    }
                    row++;
                    col++;
                    direction = 0;
                    break;
            }
        }
        return result;
    }
}
