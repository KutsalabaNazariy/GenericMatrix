package main;

import java.util.ArrayList;

public interface Matrixer<T> {

    void fillRandomMatrix() throws IllegalAccessException;

    T giveElement(int row, int column) throws IllegalAccessException;

    ArrayList<T> giveRow(int row) throws IllegalAccessException;

    ArrayList<T> giveColumn(int column) throws IllegalAccessException;

    String sizeMatrix();

    boolean equals(Object obj);

    int hashCode();

    void printMatrix();
}
