package com.oneleggedchicken.learnfortran;

import java.io.Serializable;


public class Data implements Cloneable, Serializable {



    private String[] questionhead;
    private String[] questiontext;
    private String[] gridtext;
    private String[] gridsectext;


    public Data(String[] questionhead,String[] questiontext,String[] gridtext,String[] gridsectext) {
        this.questionhead = questionhead;
        this.questiontext = questiontext;
        this.questiontext=questiontext;
        this.gridtext = gridtext;
        this.gridsectext = gridsectext;
    }

    public String[] getquestionhead() {
        return questionhead;
    }
    public String[] getquestiontext() {
        return questiontext;
    }
    public String[] getgridtext() {
        return gridtext;
    }
    public String[] getgridsectext() {
        return gridsectext;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
