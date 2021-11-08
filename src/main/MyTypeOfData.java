package main;

import java.util.ArrayList;

public class MyTypeOfData <T> implements Matrixer<T> {

    ArrayList<ArrayList<Object>> matrix;
    int rows;
    int columns;

    public MyTypeOfData(int columns, int rows) {
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

    public void fillMatrixString() {
        String text = "The University has 16 faculties, 11 educational and research institutions, several research institutes and research centers. The training of bachelors, " +
                "specialists and masters, candidates and doctors of sciences is carried out in the University.";
        String[] arrText = text.split(" ");
        int count = 1;
        for (int i = columns - 1; i >= 0; i--) {
            count++;
            for (int j = 0; j < rows; j++) {
                matrix.get(i).set(j, arrText[count * (j + 1)]);
            }
        }
    }

    public void fillMatrixInt() {

    }

    public void fillMatrixDouble() {

    }
}

//        if(this.typeObj.isAssignableFrom(Integer.class)){
//            System.out.println("Integer");
//        }


