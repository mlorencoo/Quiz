package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/*



XASKNXLKASXKLAS
 */


public class Main {

    public static void main(String[] args) throws IOException {
        readQuestionFile ();
        System.out.println ( "odpowiedz na pytania" );
        List myAnswersList = new ArrayList ();
        List corectAnswersList = new ArrayList ();
        myAnswersList = myAnswers ();
        corectAnswersList = readAnswersFile ();
        if (checkResult ( myAnswersList, corectAnswersList )) {
            System.out.println ( "wow brawo moj ty prumsie" );
            System.out.println ( "Twoje odpowiedzi " + myAnswersList );
            System.out.println ( "Poprawne odpowiedzi " + corectAnswersList );
        } else {
            System.out.println ( "Popraw sie gamoniu" );
            System.out.println ( "Twoje odpowiedzi " + myAnswersList );
            System.out.println ( "Poprawne odpowiedzi " + corectAnswersList );
        }
    }

    public static boolean checkResult(List myAnswersList, List corectAnswersList) {
        int counter=0;
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            if (myAnswersList.get ( i ).equals ( corectAnswersList.get ( i ) )) {
                counter++;
            }
        }
        if(counter==5){
            flag=true;
        }
        System.out.println ("procent poprawynych odpowiedzi "+100*counter/5+" %");
        return flag;
    }

    public static List<String> myAnswers() {
        int i = 0;
        List list = new ArrayList ();
        while (i < 5) {
            Scanner scanner = new Scanner ( System.in );
            list.add ( scanner.next () );
            i++;
        }
        return list;
    }

    public static List<String> readAnswersFile() throws IOException {
        FileReader fileReader = new FileReader ( "C:\\Users\\Użytkownik\\IdeaProjects\\Quiz\\QuizOdp.txt" );
        BufferedReader bufferedReader = new BufferedReader ( fileReader );
        List list = new ArrayList ();
        try {
            String textLine = bufferedReader.readLine ();

            do {
                list.add ( textLine );
                textLine = bufferedReader.readLine ();
            } while (textLine != null);
        } finally {
            bufferedReader.close ();
        }
        return list;
    }

    public static void readQuestionFile() throws IOException {
        FileReader fileReader = new FileReader ( "C:\\Users\\Użytkownik\\IdeaProjects\\Quiz\\QuizPytania.txt" );
        BufferedReader bufferedReader = new BufferedReader ( fileReader );

        try {
            String textLine = bufferedReader.readLine ();
            do {
                System.out.println ( textLine );

                textLine = bufferedReader.readLine ();
            } while (textLine != null);
        } finally {
            bufferedReader.close ();
        }
    }
}
