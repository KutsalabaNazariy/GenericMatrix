package main;

public class Main {

    public static void main(String [] args) throws InstantiationException, IllegalAccessException {

        MyTypeOfData<String> obj = new MyTypeOfData<String>(3, 3);
        for(int j = 0; j < obj.matrix.size(); j++) {
            System.out.println(obj.matrix.get(j));
        }
        System.out.println(obj.getClass());
        obj.fillMatrixString();

        for(int j = 0; j < obj.matrix.size(); j++) {
            System.out.println(obj.matrix.get(j));
        }
    }
}
