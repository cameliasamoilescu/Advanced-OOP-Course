package io;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ex3 {

        public static void main(String[] args) throws FileNotFoundException {
            try{
                FileReader in = new FileReader("src/io/file.txt");
                BufferedReader br = new BufferedReader(in);

                ArrayList<String> strings = new ArrayList<>();


                String line;
                while ((line = br.readLine()) != null) {
                        strings.add(line);
                }
//
//                for(String s:strings){
//                    System.out.println(s);
//                }
                in.close();
                br.close();

                System.out.println(strings.size());

            }catch (IOException e) {
                System.out.println(e);
            }

        }
}
