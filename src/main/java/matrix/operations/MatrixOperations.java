package matrix.operations;

import matrix.model.Matrix;
import matrix.operations.multiplication.MatrixMultiplier;

import java.util.concurrent.ExecutionException;

public class MatrixOperations {

    private final MatrixMultiplier matrixMultiplier = new MatrixMultiplier();

    public Matrix multiply(Matrix matrix1, Matrix matrix2) throws ExecutionException, InterruptedException {
        return matrixMultiplier.multiply(matrix1, matrix2);
    }
}
