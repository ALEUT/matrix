package matrix.validation;

import matrix.model.Matrix;

public class MatrixValidator {

    public boolean isValidSquareMatrix(Matrix matrix, int size) {
        return matrix.getRowsCount() == size && matrix.getColumnsCount() == size;
    }
}
