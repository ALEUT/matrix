package matrix.io;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import matrix.model.Matrix;

import java.io.File;
import java.io.IOException;

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;

public class MatrixIO {

    private final ObjectMapper objectMapper = new ObjectMapper()
            .enable(INDENT_OUTPUT);

    public Matrix readFromJSON(File file) throws IOException {
        int [][] matrix = objectMapper.readValue(file,
                new TypeReference<int [][]>() {
                });

        return new Matrix(matrix);
    }

    public void writeToJSON(File file, Matrix matrix) throws IOException {
        objectMapper.writeValue(file, matrix.getDataCopy());
    }
}
