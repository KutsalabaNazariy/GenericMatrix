package main;

public class Main {

    public static void main(String [] args) throws InstantiationException, IllegalAccessException {

        MatrixMutable<String> obj = new MatrixMutable<String>(8, 8);
        for(int j = 0; j < obj.matrix.size(); j++) {
            System.out.println(obj.matrix.get(j));
        }
        System.out.println(obj.getClass());
        obj.fillMatrixString();
        for(int j = 0; j < obj.matrix.size(); j++) {
            System.out.println(obj.matrix.get(j));
        }
        obj.fillMatrixInteger(-80);
        System.out.println("Integer Matrix");
        for(int j = 0; j < obj.matrix.size(); j++) {
            System.out.println(obj.matrix.get(j));
        }
        obj.fillMatrixDouble(20);
        System.out.println("Double Matrix");
        for(int j = 0; j < obj.matrix.size(); j++) {
            System.out.println(obj.matrix.get(j));
        }
    }
}
