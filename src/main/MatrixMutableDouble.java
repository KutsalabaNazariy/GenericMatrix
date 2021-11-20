package main;

import java.util.ArrayList;


public class MatrixMutableDouble extends MatrixImmutableDouble {

    private ArrayList<ArrayList<Double>> matrix;
    private int rows;
    private int columns;

    public MatrixMutableDouble() {
        this.rows = 0;
        this.columns = 0;
        this.matrix = new ArrayList<ArrayList<Double>>();
        matrix.add(null);
    }

    public MatrixMutableDouble(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Double> row = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                row.add(0.0);
            }
            this.matrix.add(row);
        }
    }

    public MatrixMutableDouble(MatrixImmutableDouble matrixOfCopy) {
        rows = matrixOfCopy.getRows();
        columns = matrixOfCopy.getColumns();
        matrix = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Double> row = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                row.add(matrixOfCopy.getMatrix().get(i).get(j));
            }
            matrix.add(row);
        }
    }

    public ArrayList<ArrayList<Double>> getMatrix() {
        return this.matrix;
    }

    public void setMatrix(MatrixMutableDouble obj) {
        this.matrix = obj.matrix;
        this.rows = obj.rows;
        this.columns = obj.columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void fillMatrix(double firstNum) {
        for (int i = 0; i < rows; i++) {
            getMatrix().get(i).clear();
            for (int j = 0; j < columns; j++) {
                if(j % 2 == 0) {
                    getMatrix().get(i).add(Double.parseDouble(decimalFormat.format(firstNum + 1.7)));
                    firstNum += 0.9;
                }
                else {
                    getMatrix().get(i).add(Double.parseDouble(decimalFormat.format(firstNum - 1)));
                    firstNum *= -0.9;
                }
            }
        }
    }

    public void randomFillingMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                getMatrix().get(i).set(j, Double.parseDouble(decimalFormat.format(Math.random()*200 - 100)));
            }
        }
    }



}

//        if(this.typeObj.isAssignableFrom(Integer.class)){
//            System.out.println("Integer");
//        }


