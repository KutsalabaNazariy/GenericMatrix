package main;

import java.text.DecimalFormat;
import java.util.ArrayList;

public interface MatrixNumber {
    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    double giveElement(int row, int column) throws IllegalAccessException;

    ArrayList<Double> giveRow(int row) throws IllegalAccessException;

    ArrayList<Double> giveColumn(int column) throws IllegalAccessException;

    String sizeMatrix();

    boolean equals(MatrixImmutableDouble obj);

    int hashCode();

    MatrixMutableDouble multiplicationOfMatrices(MatrixImmutableDouble objMatrix);

    void printMatrix();
}
