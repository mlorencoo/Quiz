package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int counter = 0;
        int counterCorectAnswers = 0;
        List myAnswersList = new ArrayList ();
        Random random = new Random ();
        List questionList = readQuestionFile ();
        List corectAnswersList = readAnswersFile ();
        int numberQuestion;
        int howManyQuestion = 5;
        List useNumber = new ArrayList ();
        System.out.println ( "Quiz z wiedzy o postawach automatyki" );
        System.out.println ( "Odpowiedz na piec pytan " );
        while (counter < howManyQuestion) {
            numberQuestion = random.nextInt ( 10 );
            if (!useNumber.contains ( numberQuestion )) {
                randomQuestion ( questionList, numberQuestion );
                System.out.println ( "odpowiedz na pytanie" );
                myAnswersList = myAnswers ( myAnswersList );
                if (checkResult ( myAnswersList, corectAnswersList, counter, numberQuestion )) {
                    counterCorectAnswers++;
                }
                counter++;
                useNumber.add ( numberQuestion );
            }
        }
        System.out.println ( "Koniec" );
        System.out.println ( "Uzyskales " + 100 * counterCorectAnswers / howManyQuestion + " % poprawnych odpowiedzi" );
    }

    public static void randomQuestion(List questionList, int numberQuestion) {

        for (int i = numberQuestion * 5; i < numberQuestion * 5 + 5; i++) {
            System.out.println ( questionList.get ( i ) );
        }
    }

    public static boolean checkResult(List myAnswersList, List corectAnswersList, int counter, int numberQuestion) {
        boolean flag = false;
        if (myAnswersList.get ( counter ).equals ( corectAnswersList.get ( numberQuestion ) )) {
            System.out.println ( "poprawna odpowiedz " );
            flag = true;
        } else System.out.println ( "zle!!! poprawna odpowiedz to " + corectAnswersList.get ( numberQuestion ) );
        return flag;
    }

    public static List<String> myAnswers(List myAnswersList) {
        Scanner scanner = new Scanner ( System.in );
        myAnswersList.add ( scanner.next () );
        return myAnswersList;
    }

    public static List<String> readAnswersFile() throws IOException {
        FileReader fileReader = new FileReader ( "C:\\Users\\Użytkownik\\IdeaProjects\\Quiz\\QuizOdp.txt" );
        BufferedReader bufferedReader = new BufferedReader ( fileReader );
        List corectAnswersList = new ArrayList ();
        try {
            String textLine = bufferedReader.readLine ();
            do {
                corectAnswersList.add ( textLine );
                textLine = bufferedReader.readLine ();
            } while (textLine != null);
        } finally {
            bufferedReader.close ();
        }
        return corectAnswersList;
    }

    public static List readQuestionFile() throws IOException {
        FileReader fileReader = new FileReader ( "C:\\Users\\Użytkownik\\IdeaProjects\\Quiz\\QuizPytania.txt" );
        BufferedReader bufferedReader = new BufferedReader ( fileReader );
        List listQuestion = new ArrayList ();
        try {
            String textLine = bufferedReader.readLine ();
            do {
                listQuestion.add ( textLine );
                textLine = bufferedReader.readLine ();

            } while (textLine != null);
        } finally {
            bufferedReader.close ();
        }
        return listQuestion;
    }
}
