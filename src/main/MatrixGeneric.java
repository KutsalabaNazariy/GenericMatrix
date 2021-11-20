package main;

import org.apache.commons.lang3.RandomStringUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;


public class MatrixGeneric<T> implements Matrixer<T> {

    ArrayList<ArrayList<Object>> matrix;
    int rows;
    int columns;
    private final Class<T> typeObj;

    public MatrixGeneric(int columns, int rows, Class<T> typeObj) {
        this.typeObj = typeObj;
        this.columns = columns;
        this.rows = rows;
        this.matrix = new ArrayList<ArrayList<Object>>();
        for (int i = 0; i < columns; i++) {
            ArrayList<Object> row = new ArrayList<>();
            for (int j = 0; j < rows; j++) {
                row.add(null);
            }
            this.matrix.add(row);
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    @Override
    public void fillRandomMatrix() throws IllegalAccessException {
        if(this.typeObj.isAssignableFrom(Integer.class)) {
            fillRandomMatrixInteger();
        }
        else if(this.typeObj.isAssignableFrom(String.class)) {
            fillRandomMatrixString();
        }
        else if(this.typeObj.isAssignableFrom(Double.class)) {
            fillRandomMatrixDouble();
        }
        else {
            System.out.println("Incorrect type of Matrix");
        }
    }

    private void fillRandomMatrixString() {
        String elem;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                elem = RandomStringUtils.randomAlphanumeric(4);
                matrix.get(i).set(j, elem);
            }
        }
    }

    private void fillRandomMatrixInteger() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix.get(i).set(j, (int)(Math.random()*200 - 100));
            }
        }
    }

    private void fillRandomMatrixDouble() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix.get(i).set(j, Double.parseDouble(decimalFormat.format(Math.random()*200 - 100)));
            }
        }
    }

    @Override
    public T giveElement(int row, int column) throws IllegalAccessException {
        if(!(this.rows >= row && this.columns >= column && row > 0 && column > 0)) {
            throw new IllegalAccessException("Incorrect dimension");
        }
        System.out.println("Element (row = " + row + ", column = " + column + "):");
        row -= 1;
        column -= 1;
        return (T) matrix.get(row).get(column);
    }

    @Override
    public ArrayList<T> giveRow(int row) throws IllegalAccessException {
        if(!(this.rows >= row && row > 0)) {
            throw new IllegalAccessException("Incorrect dimension");
        }
        System.out.println("(Row = " + row + "):");
        row -= 1;
        return (ArrayList<T>) matrix.get(row);
    }

    @Override
    public ArrayList<T> giveColumn(int column) throws IllegalAccessException {
        if(!(this.rows >= column && column > 0)) {
            throw new IllegalAccessException("Incorrect dimension");
        }
        ArrayList<T> currentColumn = new ArrayList<>();
        for(ArrayList<Object> row: matrix) {
            currentColumn.add((T)row.get(column-1));
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
        int countStr = 0;
        result = prime * result + rows;
        result = prime * result + columns;

        for(int k = 0; k < rows; k++) {
            for(int j = 0; j < columns; j++) {
                if(this.typeObj.getSimpleName().equals("String")) {
                    for(int h = 0; h < matrix.get(k).get(j).toString().length(); h++) {
                        countStr += (int) matrix.get(k).get(j).toString().charAt(h);
                    }
                    result = prime * result + countStr;
                }
                else {
                    result = prime * result + Integer.parseInt(matrix.get(k).get(j).toString());
                }
            }
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MatrixGeneric<T> su = (MatrixGeneric<T>) obj;
        if (rows != su.rows || columns != su.columns)
            return false;
        for (int i = 0; i < rows; i++) {
            if(!Objects.equals(matrix.get(i), su.matrix.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void printMatrix() {
        for(ArrayList<Object> row: matrix) {
            System.out.println(row);
        }
        System.out.println("--------------------");
    }
}



