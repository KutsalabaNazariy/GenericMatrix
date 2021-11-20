package main;

public class Main {

    public static void main(String [] args) throws InstantiationException, IllegalAccessException {
        /*MatrixGeneric<String> str = new MatrixGeneric<>(3, 3, String.class);
        MatrixGeneric<String> str2 = str;
        MatrixImmutableDouble str3 = new MatrixImmutableDouble(2,3, true);

        str.fillRandomMatrix();
        str.printMatrix();
        str2.printMatrix();

        System.out.println(str2.hashCode() == str.hashCode());
        System.out.println();*/
        MatrixGeneric<Integer> A = new MatrixGeneric<>(3,3, Integer.class);
        A.fillRandomMatrix();
        A.printMatrix();

    }
}
