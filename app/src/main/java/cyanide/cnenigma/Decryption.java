package cyanide.cnenigma;

import java.util.Scanner;

public class Decryption {
    public String deReverse (String input)
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
    public String deReverseMidDummy (String input, char dummy)
    {
        Scanner scline = new Scanner (input).useDelimiter("" + dummy);
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
        return result.substring(1);
    }
    public String deCShift(String input, int ln)
    {
        String result = ""; String temp ="";
        int ascii = 0; int newAscii = 0;
        char character;
        for (int i=0;i<input.length();i++)
        {
            character = input.charAt(i);
            ascii = (int) character;
            newAscii = ascii - ln;
            temp = Character.toString((char) newAscii);
            result = result + temp;
        }
        return result;
    }
    public String deCShiftAdv(String input)
    {
        Misc hash = new Misc();
        Scanner scLine = new Scanner(input).useDelimiter("&*&&");
        String temp = scLine.next();
        String encryptedInput = temp.substring(0, temp.length()-2);
        int attHash = makePositive(scLine.nextInt());
        scLine.close();
        int encryptedHash = hash.hashCalc(makePositive (encryptedInput.hashCode()));
        int jumpHash = attHash;
        int inputLength = makePositive(encryptedInput.length());
        int inputHash = hash.hashCalc(makePositive (jumpHash / inputLength));
        int jump = makePositive (hash.jumpCalc(jumpHash));
        String decryptedInput = deCShift (encryptedInput,jump);
        int decryptedHash = makePositive (decryptedInput.hashCode());
        return decryptedInput;
    }
    public int makePositive (int input)
    {
        if (input<0)
        {
            input = input*(-1);
        }
        return input;
    }
    public String deBiReverse(String input)
    {
        char l1;
        boolean even=false,pairComplete=false;
        String temp = "", pair="";
        Misc misc = new Misc();
        for (int i=0;i<input.length();i++)
        {
            even =misc.checkEven(i);
            l1=input.charAt(i);
            if (i==0)
            {
                pair="" + l1;
            }
            if (even == false && i!=0)
            {
                pair = l1+pair;
            }
            if (even==true && i!=0)
            {
                pair="" + l1;
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
    public String deFullReverse (String input)
    {
        String result="";
        for (int i=input.length()-1;i>=0;i--)
        {
            result = result + input.charAt(i);
        }
        return result;
    }
    public String deHaphazard (String input)
    {
        Scanner scline = new Scanner(input);
        int words= 0;
        while(scline.hasNext())
        {
            String temp = scline.next();
            words++;
        }
        scline.close();
        Misc misc = new Misc();
        int even = misc.oddCount(words);
        int odd = misc.evenCount(words);
        String strEven[]= new String [even];
        String strOdd[]= new String [odd];
        Scanner scan = new Scanner (input);
        while (scan.hasNext())
        {
            for (int i=0;i<words;i++)
            {
                if (i< even)
                {
                    strEven[i]=scan.next();
                }
                else
                {
                    strOdd[i-even]=scan.next();
                }
            }
        }
        scan.close();
        String finalResult = misc.oneEach(strEven, strOdd, words);
        return finalResult;
    }
    public String deBinary (String input)
    {
        char dummy='#';
        char ltr;
        int ascii=0;
        String binary="";
        String result="";
        Scanner scline = new Scanner(input).useDelimiter("" + dummy);
        Misc misc = new Misc();
        while (scline.hasNext())
        {
            binary=scline.next();
            ascii = misc.convertBinary(binary);
            ltr = (char)ascii;
            result = result + ltr;
        }
        scline.close();
        return result;
    }
    public String deBinaryMidDummy (String input, char dummy)
    {
        char ltr;
        int ascii=0;
        String binary="";
        String result="";
        Scanner scline = new Scanner(input).useDelimiter("" + dummy);
        Misc misc = new Misc();
        while (scline.hasNext())
        {
            binary=scline.next();
            ascii = misc.convertBinary(binary);
            ltr = (char)ascii;
            result = result + ltr;
        }
        scline.close();
        return result;
    }
    public String deCShiftSentence (String input)
    {
        int hashPlace = input.indexOf("&*&&");
        int hash = Integer.parseInt(input.substring(0,hashPlace));
        String text = input.substring(hashPlace+4);
        Misc misc = new Misc();
        int words=misc.wordsCount(input);
        String arrOutput[]= new String [words];
        String arrInput[]= new String [words];
        int arrJump[] = new int [words];
        int jump = misc.jumpCalc(makePositive(hash));
        for (int i=0;i<words;i++)
        {
            int temp = jump * i;
            arrJump[i]= misc.jumpCalc(temp);
        }
        Scanner scline = new Scanner (text);
        while (scline.hasNext())
        {
            for (int j=0;j<words;j++)
            {
                arrOutput [j]= scline.next();
            }
        }
        scline.close();
        String result="";
        for (int k=0;k<words;k++)
        {
            arrInput[k]=deCShift(arrOutput[k],arrJump[k]+1);
            result= result + " " + arrInput[k];
        }
        return result.substring(1,result.length());
    }
}
