package cyanide.cnenigma;

import java.util.Scanner;

import cyanide.cnenigma.Misc;

public class Encryption {
    public String cShift(String input, int ln)
    {
        String result = ""; String temp ="";
        int ascii = 0; int newAscii = 0;
        char character;
        for (int i=0;i<input.length();i++)
        {
            character = input.charAt(i);
            ascii = (int) character;
            newAscii = ascii + ln;
            temp = Character.toString((char) newAscii);
            result = result + temp;
        }
        return result;
    }
    public String cShiftAdv(String input)
    {
        Misc hash = new Misc();
        int inputHash = makePositive(input.hashCode());
        int jumpHash = hash.hashCalc(makePositive(inputHash));
        int jump = makePositive(hash.jumpCalc(jumpHash));
        String encryptedInput = cShift(input,jump);
        int encryptedHash = makePositive (encryptedInput.hashCode());
        int attHash = Integer.parseInt("" + jumpHash);
        String result = encryptedInput + "&*&&" + attHash;
        return result;
    }
    public int makePositive (int input)
    {
        if (input<0)
        {
            input = input*(-1);
        }
        return input;
    }
    public String reverse (String input)
    {
        Scanner scline = new Scanner (input);
        String temp = ""; String temp2 = "";
        String result="";
        while (scline.hasNext())
        {
            temp = scline.next();
            temp2="";
            for (int i=temp.length()-1;i>=0;i--)
            {
                temp2=temp2 + temp.charAt(i);
            }
            result = result + " " + temp2;
        }
        scline.close();
        return result;
    }
    public String reverseMidDummy (String input, char dummy)
    {
        Scanner scline = new Scanner (input);
        String temp = ""; String temp2 = "";
        String result="";
        while (scline.hasNext())
        {
            temp = scline.next();
            temp2="";
            for (int i=temp.length()-1;i>=0;i--)
            {
                temp2=temp2 + temp.charAt(i);
            }
            result = result + dummy + temp2;
        }
        scline.close();
        return result;
    }
    public String biReverse (String input)
    {
        char l1;
        boolean even,pairComplete=false;
        String temp = "", pair="";
        Misc misc = new Misc();
        for (int i=0;i<input.length();i++)
        {
            even = misc.checkEven(i);
            l1=input.charAt(i);
            if (i==0)
            {
                pair = "" + l1;
            }
            if (even==false && i!=0)
            {
                pair = l1+pair;
            }
            if (even == true && i!=0)
            {
                pair = "" + l1;
            }
            if (pair.length()==2)
            {
                pairComplete=true;
                temp=temp+pair;
                pair="";
            }
            else
            {
                pairComplete=false;
            }
            if (i==(input.length()-1) && pairComplete==false)
            {
                temp=temp+l1;
            }
        }
        return temp;
    }
    public String fullReverse (String input)
    {

        String result="";
        for (int i=input.length()-1;i>=0;i--)
        {
            result = result + input.charAt(i);
        }
        return result;
    }
    public String haphazard (String input)
    {
        Scanner scLine = new Scanner(input);
        Misc misc = new Misc();
        int counter =0;
        String strEven="", strOdd="";
        boolean even = false;
        while (scLine.hasNext())
        {
            String temp = scLine.next();
            counter++;
        }
        scLine.close();
        String result[]= new String [counter];
        Scanner scLine2 = new Scanner (input);
        while (scLine2.hasNext())
        {
            for (int k =0;k<counter;k++)
            {
                result[k]=scLine2.next();
            }
        }
        scLine2.close();
        for (int j = 0;j<counter;j++)
        {
            even = misc.checkEven(j);
            if (even==true )
            {
                strEven = strEven + " " + result[j];
            }
            else
            {
                strOdd = strOdd + " " + result[j];
            }
        }
        String finalResult = strEven + strOdd;
        finalResult= finalResult.substring(1,finalResult.length());
        return finalResult;
    }
    public String binary (String input)
    {
        char dummy='#';
        char ltr;
        int ascii=0;
        String binary ="";
        String result="";
        for (int i=0;i<input.length();i++)
        {
            ltr = input.charAt(i);
            ascii = (int) ltr;
            binary = Integer.toBinaryString(ascii);
            result=result + dummy + binary;
        }
        return result.substring(1,result.length());
    }
    public String binaryMidDummy (String input,char dummy)
    {
        char ltr;
        int ascii=0;
        String binary ="";
        String result="";
        for (int i=0;i<input.length();i++)
        {
            ltr = input.charAt(i);
            ascii = (int) ltr;
            binary = Integer.toBinaryString(ascii);
            result=result + dummy + binary;
        }
        return result.substring(1,result.length());
    }
    public String cShiftSentence (String input)
    {
        Misc misc=new Misc();
        int words = misc.wordsCount(input);
        int hash = misc.hashCalc(makePositive(input.hashCode()));
        String arrInput []=new String [words];
        String arrOutput [] = new String [words];
        int arrJump [] = new int [words];
        int jump = misc.jumpCalc(hash);
        for (int i=0;i<words;i++)
        {
            int temp = jump * i;
            arrJump[i]= misc.jumpCalc(temp);
        }
        Scanner scline = new Scanner(input);
        while (scline.hasNext())
        {
            for (int j=0;j<words;j++)
            {
                arrInput[j]=scline.next();
            }
        }
        scline.close();
        String result="";
        for (int k=0;k<words;k++)
        {
            arrOutput[k]=cShift(arrInput[k],arrJump[k]+1);
            result= result + " " + arrOutput[k];
        }
        return hash + "&*&&" + result.substring(1,result.length());
    }
}
