package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * this class include some static methods that manage a note storage software.
 * all notes in this program store in separate file to binary format.
 * this class can create note, show all notes that exist, show specifiec note
 * and also delete a note if exist.
 *
 * @author  mahmood-saneian
 * @since   2021-5-17
 * @version 15.0.2
 */

public class FileUtils {

    static Scanner scanner = new Scanner(System.in);

    /**
     * this method show menu to user.
     */
    public static void menu() {
        System.out.println("1.add new note" + "\n" +
                "2.summary of all notes" + "\n" +
                "3.choose a note and see it" + "\n" +
                "4.delete a note" + "\n" +
                "5.exit");
    }

    /**
     * this method get a name and create a note by this name.
     */
    public static void createNewNote() {
        System.out.println("please enter name of your note");
        String address = scanner.nextLine();
        address = "D:/mahmood/binarynotes/" + address + ".bin";


        try (FileOutputStream outputStream = new FileOutputStream(address)) {
            System.out.println("please enter your note");
            String note = scanner.nextLine();
//            note = scanner.nextLine();
            byte[] data = note.getBytes(StandardCharsets.UTF_8);
            outputStream.write(data);
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * this method show a first line of each note that exist.
     */
    public static void showSummaryOfAllNotes() {
        File folders = new File("D:/mahmood/binarynotes");
        File[] files = folders.listFiles();

        for (int i = 0; i < files.length; i++) {
            try (FileInputStream inputStream = new FileInputStream(files[i]);){
                int c;
                while ((c = inputStream.read()) != -1)
                    System.out.print((char) c);
                System.out.println("\n");
            }catch (FileNotFoundException f){
                System.out.println(f.getStackTrace());
            }catch (IOException e){
                System.out.println(e.getStackTrace());
            }
        }
    }

    /**
     * this method get a name and show a note by this name(if this note exist.)
     */
    public static void showSpecifyNote() {
        System.out.println("enter name of a note that you want to see");
        String name = scanner.nextLine();
        name = name + ".bin";
        boolean find = false;

        File folders = new File("D:/mahmood/binarynotes");
        File[] files = folders.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().equals(name)) {
                try(FileInputStream inputStream = new FileInputStream(files[i].getAbsolutePath());) {
                    int c;
                    while ((c = inputStream.read()) != -1)
                        System.out.print((char) c);
                    System.out.println("\n");
                    find = true;
                    break;
                }catch (FileNotFoundException f){
                    System.out.println(f.getStackTrace());
                }catch (IOException e){
                    System.out.println(e.getStackTrace());
                }
            }
        }
        if (find == false)
            System.out.println("this file doesn't exist");
    }

    /**
     * this method get a name of note that user wants to delete it.
     * if this note exists , delete it.
     * and if it desn't exist print suitable message.
     */
    public static void deleteNote() {
        System.out.println("enter name of note that you want delete it");
        String name = scanner.next();
        name = name + ".bin";
        boolean find = false;

        File folders = new File("D:/mahmood/binarynotes");
        File[] files = folders.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().equals(name)) {
                new File(files[i].getAbsolutePath()).delete();
                find = true;
                break;
            }
        }

        if (find == false)
            System.out.println("this note doesn' exist");
    }

}
