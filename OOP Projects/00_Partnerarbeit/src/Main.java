import com.sun.source.tree.CaseTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Kontakte erfassen");
        erfassenKontakte("mark","peter","hgjdfuklhgjfdu");
        aufrufenKontakte();

    }
    public static void erfassenKontakte (String vorname, String nachname, String email) {

        boolean quit = false;
        while (quit == false) {
            String[][] kontaktenName = new String[3][1000000000];

            for (int counter = 1; counter < 500000; counter++) {
                System.out.println(counter + ". Kontakt");

                System.out.println("Vorname:");
                Scanner scan1 = new Scanner(System.in);
                String Vorname = scan1.nextLine();

                System.out.println("Nachname:");
                Scanner scan2 = new Scanner(System.in);
                String Nachname = scan2.nextLine();

                System.out.println("Email Adresse:");
                Scanner scan3 = new Scanner(System.in);
                String Email = scan3.nextLine();

                System.out.println("Beenden? (j/n)");
                Scanner scan4 = new Scanner(System.in);
                String ende = scan4.nextLine();
                ende = ende.toLowerCase();

                if (ende.equals("j")) {
                    for (int i = 0; i < 3; i++) {
                        System.out.println(kontaktenName[i]);
                    }
                    System.exit(0);
                } else if (ende.equals("n")) {
                    //nichts, soll sich wieder wiederholen
                } else {
                    System.out.println("Bitte gib \"j\" oder \"n\"");
                }
            }
        }
    }
    public static void aufrufenKontakte () {

        System.out.println("Wie sollen die Kontakte ausgegeben werden? Vor- oder Nachname zu erst? (v/n)");
        Scanner scan5 = new Scanner(System.in);
        String stricher = scan5.nextLine();
        stricher = stricher.toLowerCase();

        if (stricher.equals("v")) {

        }
    }
    public String[] askForData() {
        String[] userInput = new String[3];
        for (int i = 0; i < userInput.length; i++) {
            userInput[i] = /* ask the user for a digit*/;
        }
        return userInput;
    }

}
