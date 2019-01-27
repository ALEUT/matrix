package matrix.operations.multiplication;

import matrix.model.Matrix;

import java.util.concurrent.Callable;

public class MatrixRowMultiplierCallable implements Callable<int[]> {

    private final Matrix matrix1;
    private final Matrix matrix2;
    private final int matrix1RowIndex;

    public MatrixRowMultiplierCallable(Matrix matrix1, Matrix matrix2, int matrix1RowIndex) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.matrix1RowIndex = matrix1RowIndex;
    }

    @Override
    public int[] call() {
        int rowLength = matrix1.getColumnsCount();

        int[] resultRow = new int[rowLength];

        for (int colIndex = 0; colIndex < rowLength; colIndex++) {
            int cellResult = 0;
            for (int i = 0; i < rowLength; i++) {
                cellResult += matrix1.getValue(matrix1RowIndex, i) * matrix2.getValue(i, colIndex);
            }

            resultRow[colIndex] = cellResult;
        }

        return resultRow;
    }
}
