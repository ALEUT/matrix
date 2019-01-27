package matrix.multiplication;

import matrix.validation.MatrixValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MatrixMultiplier {

    private MatrixValidator matrixValidator = new MatrixValidator();

    public int[][] multiply(int[][] matrix1, int[][] matrix2) throws InterruptedException, ExecutionException {
        int matrixSize = matrix1.length;

        if (!matrixValidator.isValid(matrix1, matrixSize)) {
            throw new IllegalArgumentException("Invalid matrix1");
        }
        if (!matrixValidator.isValid(matrix2, matrixSize)) {
            throw new IllegalArgumentException("Invalid matrix2");
        }

        List<Callable<int[]>> rowTasks = new ArrayList<>();
        for (int[] matrix1Row : matrix1) {
            rowTasks.add(new MatrixRowMultiplierCallable(matrix1Row, matrix2));
        }

        int coresCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(coresCount);
        List<Future<int[]>> resultRows = executorService.invokeAll(rowTasks);

        int[][] result = new int[matrixSize][];
        for (int i = 0; i < matrixSize; i++) {
            result[i] = resultRows.get(i).get();
        }

        executorService.shutdown();

        return result;
    }
}
