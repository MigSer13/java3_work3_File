package ru.geekbrains.java3_work3_Files;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Main {

    public static void main(String[] args) {
        //Task 1
//	   readFileInBytes();
//     readFileInBytesWhith_UTF8();

        //Task 2
//        makeFromMultipleFiles();

        //Task 3
        consoleApplication();
    }

    private static void consoleApplication()
    {
        int pageNumber = 2;
        int readsBytes = 18;
        long pos = (long) (pageNumber-1) * readsBytes;
        byte[] bytes = new byte[readsBytes];
        try {
            RandomAccessFile raf = new RandomAccessFile("task3.txt", "r");
            raf.seek(pos);
            int x;
            while ((x = raf.read(bytes)) != -1){
                for (int i = 0; i < x; i++) {
                    System.out.print((char)bytes[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void makeFromMultipleFiles() {
        char[] chars = new char[1500];
        ArrayList<InputStream> listTexts = new ArrayList<>();
        try {
            listTexts.add(new FileInputStream("Files/1.txt"));
            listTexts.add(new FileInputStream("Files/2.txt"));
            listTexts.add(new FileInputStream("Files/3_1.txt"));
            listTexts.add(new FileInputStream("Files/3_2.txt"));
            listTexts.add(new FileInputStream("Files/4.txt"));

            Enumeration<InputStream> enumeration = Collections.enumeration(listTexts);
            InputStreamReader isr = null;
            int numCh;
            FileWriter fout = new FileWriter("Files/result.txt");
            BufferedWriter buf = new BufferedWriter(fout);
            String newString = "\nНовая статья_____________________________\n";
            while (enumeration.hasMoreElements()){
                isr = new InputStreamReader(enumeration.nextElement(), "UTF-8");
                while ((numCh = isr.read(chars)) != -1){
                    for (int i = 0; i < numCh; i++) {
                        buf.write(chars[i]);
                    }
                }
                buf.write(newString);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void readFileInBytesWhith_UTF8() {
        char[] chars = new char[50];
        try {
            FileInputStream is = new FileInputStream("read byte.txt");
            InputStreamReader inputStream = new InputStreamReader(is, "UTF-8");
            int x;
            while ((x = inputStream.read(chars)) != -1){
                for (int i = 0; i < x; i++) {
                    System.out.print(chars[i]);
                }
            }
            System.out.println("\n___________________________________________________");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileInBytes()  {
        byte[] bytes = new byte[50];
        try {
            FileInputStream is = new FileInputStream("read byte.txt");
            int x;
            while ((x = is.read(bytes)) != -1){
                for (int i = 0; i < x; i++) {
                    System.out.print((char)bytes[i]);
                }
            }
            System.out.println("\n___________________________________________________");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
