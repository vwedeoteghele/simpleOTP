import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import  java.lang.Character;

import static java.lang.Character.*;

public class Ecryption {

    private Scanner scanner;
    private Random random;
    ArrayList<Character> list;
    ArrayList<Character> shuffledList;
    char[] letters;
    private char character;
    private String line;
    public Ecryption() {
        scanner = new Scanner(System.in);
        random = new Random();
        list = new ArrayList<>();
        shuffledList = new ArrayList<>();
        character = ' ';

        newKey();
        ask();
    }
    private void ask() {
        while (true) {
            System.out.println("*******************************");
            System.out.println("What do you want to do?");
            System.out.println("(N)ewKey, (G)etKey, (E)ncrypt, (Q)uit");

            char response = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch (response) {
                case 'N':
                    newKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encryptKey();
                    break;
                case 'D':
                    decryptKey();
                    break;
                case 'Q':
                    quit();
                    break;
                default:
                    System.out.println("Not a valid answer");
            }
        }
    }

    private void newKey() {
        character = ' ';
        System.out.println(character+=10);
        list.clear();
        shuffledList.clear();
        for(int i = 32; i < 127; i++) {
            list.add(Character.valueOf(character));
            character++;
        }
        shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);
    }
    private void getKey() {
        for(char x : list) {
            System.out.print(x);
        }
        System.out.println();
        for(char x : shuffledList) {
            System.out.print(x);
        }
        System.out.println();
    }
    private void encryptKey() {
        newKey();
        System.out.println("Enter a message to encrypt: ");
        String message = scanner.nextLine();
        letters = message.toCharArray();

        for(int i = 0; i < letters.length; i++) {
            for(int j = 0; j < list.size(); j++) {
                if(letters[i] == list.get(j)) {
                    letters[i] = shuffledList.get(j);
                    break;
                }
            }
        }
        System.out.println("Encrypted message: ");
        for(char x: letters) {
            System.out.print(x);
        }
        System.out.println();
    }
    private void decryptKey() {
        System.out.println("What would you like to decrypt: ");
        String message = scanner.nextLine();
        letters = message.toCharArray();
        for(int i = 0; i < letters.length; i++) {
            for(int j = 0; j < shuffledList.size(); j++) {
                if(letters[i] == shuffledList.get(j)) {
                    letters[i] = list.get(j);
                    break;

                }
            }
        }
        System.out.println("Decrypted message: ");
        for(char x : letters) {
            System.out.print(x);
        }
        System.out.println();
    }
    private void quit() {
        System.exit(0);
    }
}
