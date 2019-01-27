package matrix.validation;

public class MatrixValidator {

    public boolean isValid(int[][] matrix, int size) {
        if (matrix.length != size) {
            return false;
        }

        for (int[] row : matrix) {
            if (row.length != size) {
                return false;
            }
        }

        return true;
    }
}
