package matrix.model;

import java.util.Arrays;

public class Matrix {

    private final int[][] data;
    private final int rowsCount;
    private final int columnsCount;

    public Matrix(int rowsCount, int columnsCount) {
        data = new int[rowsCount][columnsCount];
        this.rowsCount = rowsCount;
        this.columnsCount = columnsCount;
    }

    public Matrix(int[][] data) {
        this.data = Arrays.stream(data).map((int[]::clone)).toArray(int[][]::new);
        this.rowsCount = data.length;
        this.columnsCount = data[0].length;
    }

    public int getValue(int row, int column) {
        return data[row][column];
    }

    public void setValue(int value, int row, int column) {
        data[row][column] = value;
    }

    public int getRowsCount() {
        return rowsCount;
    }

    public int getColumnsCount() {
        return columnsCount;
    }

    public int[][] getDataCopy() {
        return Arrays.stream(data).map((int[]::clone)).toArray(int[][]::new);
    }
}
