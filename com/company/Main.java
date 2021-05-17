package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        outer:
        while (true){
            FileUtils.menu();
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    FileUtils.createNewNote();
                    break;
                case 2:
                    FileUtils.showSummaryOfAllNotes();
                    break;
                case 3:
                    FileUtils.showSpecifyNote();
                    break;
                case 4:
                    FileUtils.deleteNote();
                    break;
                case 5:
                    System.out.println("goodbye.see you later");
                    break outer;
            }
        }
    }

}
