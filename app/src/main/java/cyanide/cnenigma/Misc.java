package cyanide.cnenigma;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Scanner;

public class Misc
{
    public int jumpCalc (int input)
    {
        String in = "" + input;
        int result = 0;
        char fig;
        int intFig=0;
        int tempJump=0;
        while (in.length()>=2)
        {
            tempJump=0;
            for (int i=0;i<in.length();i++)
            {
                fig = in.charAt(i);
                intFig=Integer.parseInt("" + fig);
                tempJump = tempJump + intFig;
            }
            in = "" + tempJump;
        }
        result = tempJump;
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
    public int hashCalc(int input)
    {
        input=makePositive(input);
        String strInput = "" + input;
        int f2 = Integer.parseInt(strInput.substring(0,2));
        int l2 = Integer.parseInt(strInput.substring(strInput.length()-2,strInput.length()));
        String strLn = "" + strInput.length();
        int ln = Integer.parseInt(strLn.substring(0,1));
        int result = Integer.parseInt("" + l2 + f2 + ln);
        return result;
    }

    public boolean checkEven (int input)
    {
        int remainder = input % 2;

        boolean even = false;
        if (remainder == 0)
        {
            even=true;
        }
        else
        {
            even=false;
        }
        return even;
    }
    public int evenCount (int input)
    {
        boolean even =false;
        int counter=0;
        for (int i=1;i<=input;i++)
        {
            even = checkEven(i);
            if (even==true)
            {
                counter++;
            }
        }
        return counter;
    }
    public int oddCount (int input)
    {
        boolean even =true;
        int counter=0;
        for (int i=1;i<=input;i++)
        {
            even = checkEven(i);
            if (even==false)
            {
                counter++;
            }
        }
        return counter;
    }
    public String oneEach (String even[],String odd[],int words)
    {
        int evenctr = oddCount(words);
        int oddctr = evenCount(words);
        String result="";
        if (evenctr==oddctr)
        {
            for (int i = 0; i <evenctr;i++)
            {
                result = result + " " + even[i] + " " + odd[i];
            }
        }
        if (evenctr>oddctr)
        {
            int i=0;
            for (i = 0; i <oddctr;i++)
            {
                result = result + " " + even[i] + " " + odd[i];
            }

            result=result+" " + even[i];
        }
        if (oddctr>evenctr)
        {
            int i=0;
            for (i = 0; i <evenctr;i++)
            {
                result = result + " " + even[i] + " " + odd[i];
            }

            result=result+" " + odd[i];
        }
        return result.substring(1,result.length());
    }
    public int convertBinary (String input)
    {
        int place=0;
        int power=0;
        int value=0;
        int total=0;
        for (int i=0; i<input.length(); i++)
        {
            char ltr = input.charAt(i);
            place = input.length()-1-i;
            power = power(2,place);
            value = Integer.parseInt("" + ltr) * power;
            total=total+value;
        }
        return total;
    }
    public int power (int input,int power)
    {
        int result = input;
        if (power==0)
        {
            result=1;
        }
        for (int i=1;i<power;i++)
        {
            result=result*input;
        }
        return result;
    }
    public int wordsCount (String input)
    {
        Scanner scline = new Scanner(input);
        int count = 0 ;
        while (scline.hasNext())
        {
            String temp = scline.next();
            count++;
        }
        scline.close();
        return count;
    }
}



