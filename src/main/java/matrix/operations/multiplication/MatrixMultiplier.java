package matrix.operations.multiplication;

import matrix.model.Matrix;
import matrix.validation.MatrixValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MatrixMultiplier {

    private final MatrixValidator matrixValidator = new MatrixValidator();

    public Matrix multiply(Matrix matrix1, Matrix matrix2) throws InterruptedException, ExecutionException {
        int matrixSize = matrix1.getRowsCount();

        if (!matrixValidator.isValidSquareMatrix(matrix1, matrixSize)) {
            throw new IllegalArgumentException("Invalid matrix1");
        }
        if (!matrixValidator.isValidSquareMatrix(matrix2, matrixSize)) {
            throw new IllegalArgumentException("Invalid matrix2");
        }

        List<Callable<int[]>> rowTasks = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
            rowTasks.add(new MatrixRowMultiplierCallable(matrix1, matrix2, rowIndex));
        }

        int coresCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(coresCount);
        List<Future<int[]>> resultRows = executorService.invokeAll(rowTasks);

        Matrix result = new Matrix(matrixSize, matrixSize);
        for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
            int[] row = resultRows.get(rowIndex).get();
            for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                result.setValue(row[columnIndex], rowIndex, columnIndex);
            }
        }

        executorService.shutdown();

        return result;
    }
}
