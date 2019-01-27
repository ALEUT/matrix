import matrix.io.MatrixIO;
import matrix.multiplication.MatrixMultiplier;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        MatrixIO matrixIO = new MatrixIO();

        int [][] matrix1 = matrixIO.readFromJSON(new File("matrix1.json"));
        int [][] matrix2 = matrixIO.readFromJSON(new File("matrix2.json"));

        MatrixMultiplier matrixMultiplier = new MatrixMultiplier();
        int [][] resultMatrix = matrixMultiplier.multiply(matrix1, matrix2);

        matrixIO.writeToJSON(new File("resultMatrix.json"), resultMatrix);
    }

}
