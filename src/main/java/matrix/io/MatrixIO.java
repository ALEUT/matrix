package matrix.io;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;

public class MatrixIO {

    private final ObjectMapper objectMapper = new ObjectMapper()
            .enable(INDENT_OUTPUT);

    public int[][] readFromJSON(File file) throws IOException {
        int [][] matrix = objectMapper.readValue(file,
                new TypeReference<int [][]>() {
                });

        return matrix;
    }

    public void writeToJSON(File file, int[][] matrix) throws IOException {
        objectMapper.writeValue(file, matrix);
    }
}
