package com.oneleggedchicken.learnfortran;

import java.io.Serializable;


public class Data implements Cloneable, Serializable {



    private String[] firstquestionhead;
    private String[] secondquestionhead;
    private String[] thirdquestionhead;
    private String[] fourthquestionhead;
    private String[] fifthquestionhead;
    private String[] sixthquestionhead;
    private String[] seventhquestionhead;
    private String[] firstquestiontext;
    private String[] secondquestiontext;
    private String[] thirdquestiontext;
    private String[] fourthquestiontext;
    private String[] fifthquestiontext;
    private String[] sixthquestiontext;
    private String[] seventhquestiontext;
    private String[] gridtext;
    private String[] gridsectext;


    public Data(String[] firstquestionhead,String[] firstquestiontext,String[] secondquestionhead,String[] secondquestiontext,String[] thirdquestionhead,String[] thirdquestiontext,String[] fourthquestionhead,String[] fourthquestiontext,
                String[] fifthquestionhead,String[] fifthquestiontext,String[] sixthquestionhead,String[] sixthquestiontext ,String[] seventhquestionhead,String[] seventhquestiontext,String[] gridtext,String[] gridsectext) {
        this.firstquestionhead = firstquestionhead;
        this.secondquestionhead = secondquestionhead;
        this.thirdquestionhead = thirdquestionhead;
        this.fourthquestionhead = fourthquestionhead;
        this.fifthquestionhead = fifthquestionhead;
        this.sixthquestionhead = sixthquestionhead;
        this.seventhquestionhead = seventhquestionhead;
        this.firstquestiontext = firstquestiontext;
        this.secondquestiontext = secondquestiontext;
        this.thirdquestiontext = thirdquestiontext;
        this.fourthquestiontext = fourthquestiontext;
        this.fifthquestiontext = fifthquestiontext;
        this.sixthquestiontext = sixthquestiontext;
        this.seventhquestiontext = seventhquestiontext;

        this.gridtext = gridtext;
        this.gridsectext = gridsectext;
    }



    public String[] getfirstquestionhead() {
        return firstquestionhead;
    }
    public String[] getfirstquestiontext() {
        return firstquestiontext;
    }
    public String[] getsecondquestionhead() {
        return secondquestionhead;
    }
    public String[] getsecondquestiontext() {
        return secondquestiontext;
    }
    public String[] getthirdquestionhead() {
        return thirdquestionhead;
    }
    public String[] getthirdquestiontext() {
        return thirdquestiontext;
    }
    public String[] getfourthquestionhead() {
        return fourthquestionhead;
    }
    public String[] getfourthquestiontext() {
        return fourthquestiontext;
    }
    public String[] getfifthquestionhead() {
        return fifthquestionhead;
    }
    public String[] getfifthquestiontext() {
        return fifthquestiontext;
    }
    public String[] getsixthquestionhead() {
        return sixthquestionhead;
    }
    public String[] getsixthquestiontext() {
        return sixthquestiontext;
    }
    public String[] getseventhquestionhead() {
        return seventhquestionhead;
    }
    public String[] getseventhquestiontext() {
        return seventhquestiontext;
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
