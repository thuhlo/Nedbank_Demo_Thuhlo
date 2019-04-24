package com.expleo.qe.PageObjects;

public class IterCounter
{

    static int counter;
    static int counter2;

    public void incrmentCounter()
    {
        counter = counter + 1 ;
    }
    public int getCounter()
    {
        return counter;
    }

    public void incrementCounter2(){counter = counter + 1;}
    public int getCounter2(){return counter2;}


    public boolean setNewsLetter(String newsLetter)
    {
        boolean returnGender = false;

        if(newsLetter.equalsIgnoreCase("true"))
        {
           returnGender = true;
        }
        else if(newsLetter.equalsIgnoreCase("false"))
        {
            returnGender = false;
        }
        return returnGender;
    }

    public boolean chooseMSOffice(String msOffice)
    {
        boolean returnMSOffice = false;

        if(msOffice.equalsIgnoreCase("true"))
        {
            returnMSOffice = true;
        }
        return returnMSOffice;
    }

    public boolean chooseAcrobat(String acrobatReader)
    {
        boolean returnAcrobat = false;

        if(acrobatReader.equalsIgnoreCase("true"))
        {
            returnAcrobat = true;
        }
        return returnAcrobat;
    }

    public boolean chooseTotalCommander(String totalCommander)
    {
        boolean returnTotalCommander = false;

        if(totalCommander.equalsIgnoreCase("true"))
        {
            returnTotalCommander = true;
        }
        return returnTotalCommander;
    }
}
