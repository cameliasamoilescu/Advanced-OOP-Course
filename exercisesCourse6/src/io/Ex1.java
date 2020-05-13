package io;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) throws FileNotFoundException {
        try{

            FileReader in = new FileReader("src/io/file.txt");
            BufferedReader br = new BufferedReader(in);

            int maxL = -1;
            String result = "";
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("[ ,.?!;]");
                for(String word : words)
                {
//                    System.out.println(word);

                    if(word.length() > maxL){
                        maxL = word.length();
                        result = word;
                    }
                }
            }

            in.close();
            br.close();
            System.out.println("Cel mai lung cuvant: " + result);


        }catch (IOException e) {
            System.out.println(e);

        }

    }

}
