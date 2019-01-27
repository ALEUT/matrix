package matrix.multiplication;

import java.util.concurrent.Callable;

public class MatrixRowMultiplierCallable implements Callable<int[]> {

    private final int[] matrix1row;
    private final int[][] matrix2;

    public MatrixRowMultiplierCallable(int[] matrix1row, int[][] matrix2) {
        this.matrix1row = matrix1row;
        this.matrix2 = matrix2;
    }

    @Override
    public int[] call() {
        int[] resultRow = new int[matrix1row.length];

        for (int colIndex = 0; colIndex < matrix1row.length; colIndex++) {
            int cellResult = 0;
            for (int i = 0; i < matrix1row.length; i++) {
                cellResult += matrix1row[i] * matrix2[i][colIndex];
            }

            resultRow[colIndex] = cellResult;
        }

        return resultRow;
    }
}
