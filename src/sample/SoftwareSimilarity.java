package sample;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class SoftwareSimilarity {

    public static void main(String[] args) throws Exception
    {

        System.out.print("Enter your username: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        //System.out.println(name);

        System.out.println("\nEnter Program #1 File Name: ");
//        Scanner in = new Scanner(System.in);
//        String name = in.nextLine();

        System.out.print("\nPAIR 1\n\n");
        //System.out.print("PAIR 2\n\n");

        StringBuilder prog1String = new StringBuilder();
        StringBuilder prog2String = new StringBuilder();

        //PAIR 1
        File prog1File = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\prog1.java");
        File prog2File = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\prog2.java");

        //PAIR 2
//        File prog1File = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\prog1.cpp.txt");
//        File prog2File = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\prog2.cpp.txt");

        Scanner prog1Scan = new Scanner(prog1File);
        Scanner prog2Scan = new Scanner(prog2File);

        String longestSamedtString = "";
        float sameLines = 0,totalLines = 0,lineLength = 0;

        while(prog1Scan.hasNextLine() || prog2Scan.hasNextLine()){
            String prog1Word = prog1Scan.nextLine();
            String prog2Word = prog2Scan.nextLine();

            prog1String.append(prog1Word + "\n");
            prog2String.append(prog2Word + "\n");

            if(prog1Word.equals(prog2Word)){
                int newLineLength = prog1Word.length();

                if(newLineLength > lineLength){
                    longestSamedtString = prog1Word;
                    lineLength = newLineLength;
                }

                sameLines++;
            }

            totalLines++;
        }

        float percentage = (sameLines / totalLines) * 100;

        System.out.println("PROG #1: \n" + prog1String);
        System.out.println("PROG #2: \n" + prog2String);

        System.out.println("\nLongest Similar String: \n" + longestSamedtString);

        System.out.println("\nSimilarity Percentage when Checked per Line: " + percentage + "%");

        ReadCodeCharacter();

    }

    public static void ReadCodeCharacter() {

        int countChar=0;
        int countTotal=0;
        float percentage;
        try {
            File program1 = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\prog1.java");
            File program2 = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\prog2.java");
            Scanner myProg1 = new Scanner(program1);
            Scanner myProg2 = new Scanner(program2);
            while (true) {
                if(myProg1.hasNext() && myProg2.hasNext())
                {
                    String data1 = myProg1.nextLine();
                    String data2 = myProg2.nextLine();
                    int i=0;
                    while(true)
                    {
                        if(i<data1.length() && i<data2.length()){
                            if(data1.charAt(i)==data2.charAt(i))
                            {
                                countChar++;
                                countTotal++;
                            }
                            i++;
                        }
                        else if(i<data2.length())
                        {
                            countTotal++;
                            i++;
                        }
                        else if(i<data1.length())
                        {
                            countTotal++;
                            i++;
                        }
                        else
                        {
                            break;
                        }
                    }

                }
                else if(myProg1.hasNext())
                {
                    countTotal=countTotal+myProg1.nextLine().length();
                }
                else if(myProg2.hasNext())
                {
                    countTotal=countTotal+myProg2.nextLine().length();
                }
                else{
                    break;
                }

            }
            myProg1.close();
            myProg2.close();
            percentage=(float)countChar/(float) countTotal;
            System.out.println("\nSimilarity Percentage when Checked per Character: " + percentage*100+"%");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
