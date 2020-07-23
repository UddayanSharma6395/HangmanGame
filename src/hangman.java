import java.io.*;
import java.util.*;
import java.lang.*;
public class hangman
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        Random random=new Random();
        ArrayList<String> word=new ArrayList<String>();
        ArrayList<String> hint1=new ArrayList<String>();
        ArrayList<String> hint2=new ArrayList<String>();
        word.add("MICROSOFT");hint1.add("WINDOWS OS");hint2.add("BILL GATES AND PAUL ALLEN STARTED THE COMPANY");
        word.add("DELL");hint1.add("lAPTOP COMPANY SOUNDS LIKE BELL");hint2.add("FOUNDER IS MICHAEL ..");
        word.add("APPLE");hint1.add("iPhone");hint2.add("Macbook");
        word.add("ADOBE");hint1.add("Photoshop");hint2.add("also have a pdf viewer");
        word.add("INFOSYS");hint1.add("Mass Recrutement");hint2.add("indian multinational corporation");
        word.add("YAHOO");hint1.add("a search engine");hint2.add("founders are JERREY YANK and DAVID FILO");
        word.add("GOOGLE");hint1.add("android");hint2.add("founders are LARRY PAGE and SERGEY BRIN");
        String s="";
        int ran=random.nextInt(word.size());
        int f=0;
        s=word.get(ran);
        char c[]=new char[s.length()];
        for(int i=0;i<s.length();i++)
        {
            c[i]='#';
        }
        System.out.println(s);
        System.out.println("MAKE A CHOICE");
        System.out.println("USING A HINT OR WRONG GUESSES WILL REDUCE YOUR LIFE BY ONE");
        System.out.println("1--> GUESS THE LETTER");
        System.out.println("2--> HINT 1");
        System.out.println("3--> HINT 2");
        System.out.println("4--> IF YOU KNOW THE WORD");
        for(int i=3;i>0;i--)
        {
            System.out.println("-----LIVES REMAINING-----");
            for(int j=0;j<i;j++)
            {
                System.out.print("♥");
            }
            System.out.println("");
            int ch=sc.nextInt();
            System.out.println(c);
            switch(ch)
            {
                case 1:f=0;
                    System.out.println("enter the letter");
                    char letter=sc.next().charAt(0);
                    for(int j=0;j<s.length();j++)
                    {
                        if(s.charAt(j)==letter)
                        {
                            c[j]=letter;
                            f=1;
                        }
                    }
                    if(i<=3&&f==1)
                    {
                        i++;
                    }
                    System.out.println(c);
                    break;
                case 2:
                    System.out.println("HINT 1");
                    System.out.println(hint1.get(ran));
                    break;
                case 3:
                    System.out.println("HINT 2");
                    System.out.println(hint2.get(ran));
                    break;
                case 4:
                      System.out.println("enter the word");
                      String str=br.readLine();
                    if(s.equalsIgnoreCase(str))
                    {
                        System.out.println("Correct");
                        i=0;
                        break;
                    }
                    else
                    {
                        if (i>1)
                        {
                            System.out.println("dont worry you still have " + (i-1) + " lives");
                        }
                        else
                        {
                            System.out.println("-----sorry you lost-----");
                        }
                    }
                    break;
                default:
                    System.out.println("wrong choice");

            }
        }


    }
}
