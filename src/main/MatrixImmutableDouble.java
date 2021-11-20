package main;

import java.util.ArrayList;
import java.util.Objects;

public class MatrixImmutableDouble implements MatrixNumber {

    private final ArrayList<ArrayList<Double>> matrix;
    private final int rows;
    private final int columns;

    public MatrixImmutableDouble() {
        this.rows = 0;
        this.columns = 0;
        this.matrix = new ArrayList<ArrayList<Double>>();
        matrix.add(null);
    }

    public MatrixImmutableDouble(int rows, int columns, boolean flag) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new ArrayList<ArrayList<Double>>();

        for (int i = 0; i < rows; i++) {
            final ArrayList<Double> row = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                if(!flag) {
                    row.add(null);
                }
                else {
                    row.add(Double.parseDouble(decimalFormat.format(Math.random()*200 - 100)));
                }
            }
            this.matrix.add(row);
        }
    }

    public MatrixImmutableDouble(MatrixMutableDouble matrixOfCopy) {
        rows = matrixOfCopy.getRows();
        columns = matrixOfCopy.getColumns();
        double current = 0.0;

        matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            final ArrayList<Double> row = new ArrayList<>(matrixOfCopy.getMatrix().get(i));
            matrix.add(new ArrayList<>(row));
        }
    }

    public ArrayList<ArrayList<Double>> getMatrix() {
        ArrayList<ArrayList<Double>> reserveMatrix = new ArrayList<>();
        for(int i = 0; i < matrix.size(); i++) {
            ArrayList<Double> reserveCopy = new ArrayList<>(matrix.get(i));
            reserveMatrix.add(reserveCopy);
        }
        return reserveMatrix;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    @Override
    public double giveElement(int row, int column) throws IllegalAccessException {
        if(!(this.rows >= row && this.columns >= column && row > 0 && column > 0)) {
            throw new IllegalAccessException("Incorrect dimension");
        }
        System.out.println("Element (row = " + row + ", column = " + column + "):");
        row -= 1;
        column -= 1;
        return Double.parseDouble(matrix.get(row).get(column).toString());
    }

    @Override
    public ArrayList<Double> giveRow(int row) throws IllegalAccessException {
        if(!(this.rows >= row && row > 0)) {
            throw new IllegalAccessException("Incorrect dimension");
        }
        System.out.println("(Row = " + row + "):");
        row -= 1;
        return matrix.get(row);
    }

    @Override
    public ArrayList<Double> giveColumn(int column) throws IllegalAccessException {
        if(!(this.rows >= column && column > 0)) {
            throw new IllegalAccessException("Incorrect dimension");
        }
        ArrayList<Double> currentColumn = new ArrayList<>();
        for(ArrayList<Double> row: matrix) {
            currentColumn.add(row.get(column-1));
        }
        return currentColumn;
    }


    @Override
    public String sizeMatrix() {
        return rows + "x" + columns;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + rows;
        result = prime * result + columns;
        for(ArrayList<Double> row: getMatrix()) {
            for(Double arr : row) {
                result = (int) (prime * result + arr);
            }
        }
        return result;
    }

    @Override
    public boolean equals(MatrixImmutableDouble obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        if (rows != obj.getRows() || columns != obj.getColumns())
            return false;
        for (int i = 0; i < rows; i++) {
            if(!Objects.equals(getMatrix().get(i), obj.getMatrix().get(i))) {
                return false;
            }
        }
        return true;
    }

    static MatrixMutableDouble createMatrixRow(int columns) {
        MatrixMutableDouble objMatrixRow = new MatrixMutableDouble(1, columns);
        objMatrixRow.randomFillingMatrix();
        return objMatrixRow;
    }

    @Override
    public MatrixMutableDouble multiplicationOfMatrices(MatrixImmutableDouble objMatrix) {
        if(getColumns() != objMatrix.getRows()) {
            throw new IllegalArgumentException("The number of rows of the first matrix should be equal " +
                "to the number of columns of the second matrix");
        }

        MatrixMutableDouble objResultMatrix = new MatrixMutableDouble(getRows(), objMatrix.getColumns());
        double result;
        for(int i = 0; i < getRows(); i++) {
            for(int j = 0; j < objMatrix.getColumns(); j++) {
                result = 0.0;
                for(int k = 0; k < getColumns(); k++) {
                    result += getMatrix().get(i).get(k) * objMatrix.getMatrix().get(k).get(j);
                }
                objResultMatrix.getMatrix().get(i).set(j, Double.parseDouble(decimalFormat.format(result)));
            }
        }
        return objResultMatrix;
    }

    @Override
    public void printMatrix() {
        for(ArrayList<Double> row: getMatrix()) {
            System.out.println(row);
        }
        System.out.println("--------------------");
    }
}
