import matrix.io.MatrixIO;
import matrix.model.Matrix;
import matrix.operations.MatrixOperations;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        MatrixIO matrixIO = new MatrixIO();

        Matrix matrix1 = matrixIO.readFromJSON(new File("matrix1.json"));
        Matrix matrix2 = matrixIO.readFromJSON(new File("matrix2.json"));

        MatrixOperations matrixOperations = new MatrixOperations();
        Matrix resultMatrix = matrixOperations.multiply(matrix1, matrix2);

        matrixIO.writeToJSON(new File("resultMatrix.json"), resultMatrix);
    }

}
