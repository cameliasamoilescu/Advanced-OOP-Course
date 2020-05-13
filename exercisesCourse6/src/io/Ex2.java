package io;

import java.io.*;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("src/io/file.txt", true);

            BufferedWriter bf = new BufferedWriter(fw);


            FileReader in = new FileReader("src/io/Ex2.java");
            BufferedReader br = new BufferedReader(in);

            String line ;
            while ((line = br.readLine()) != null) {

                bf.write(line);
                bf.write("\n");
            }

            in.close();
            br.close();
            bf.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
