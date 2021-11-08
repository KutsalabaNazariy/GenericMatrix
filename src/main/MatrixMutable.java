package main;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MatrixMutable<T> implements Matrixer<T> {

    ArrayList<ArrayList<Object>> matrix;
    int rows;
    int columns;

    public MatrixMutable(int columns, int rows) {
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

    @Override
    public void fillMatrixString() {
        String text = "The Univ ers ity has ul ies 11 educat ional an d re se arch ins tit utions " +
                "seve ral resea %%% +== %%% 1131 few rch insti tutes and rese arch cent ers. The tr ain ing of bachelors " +
                "spe cia lists and masters/ can di dates and doc t ors of sci ences is carri ed out in the Univ ersit";
        String[] arrText = text.split(" ");
        int firstNum = 15;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if(firstNum % 5 == 0 && firstNum > 0) {
                    firstNum = (firstNum/5);
                    matrix.get(i).set(j, arrText[firstNum]);
                    firstNum *= -1;
                }
                else if(firstNum < 0) {
                    firstNum *= -1;
                    matrix.get(i).set(j, arrText[firstNum+1]);
                    firstNum += 17;
                }
                else {
                    matrix.get(i).set(j, arrText[firstNum+1]);
                    firstNum += 7;
                }
            }
        }
    }

    @Override
    public void fillMatrixInteger(int firstNum) {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if(firstNum % 5 == 0) {
                    firstNum = -1 * (firstNum/5);
                    matrix.get(i).set(j, firstNum);
                }
                else {
                    matrix.get(i).set(j, firstNum + 1);
                    firstNum += 7;
                }
            }
        }
    }

    public void fillMatrixDouble(double firstNum) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if(j % 2 == 0) {
                    matrix.get(i).set(j, decimalFormat.format(firstNum + 1.7));
                    firstNum += 0.9;
                }
                else {
                    matrix.get(i).set(j, decimalFormat.format(firstNum - 1));
                    firstNum *= -0.9;
                }
            }
        }
    }
}

//        if(this.typeObj.isAssignableFrom(Integer.class)){
//            System.out.println("Integer");
//        }


