package io;

import java.io.*;

public class Ex4 {
    public static void main(String[] args) {
        codare(3);
        decodare(3);

    }


    public static void codare(int offset){

        try{

            BufferedReader br = new BufferedReader(new FileReader("src/io/file.txt"));
            FileWriter fw = new FileWriter("src/io/codat.txt");
            BufferedWriter bf = new BufferedWriter(fw);


            int cod;
            while((cod = br.read()) != -1){
                cod += offset;
                bf.write((char)cod);
            }

            bf.close();
            br.close();
            fw.close();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void decodare(int offset){

        try{

            BufferedReader br = new BufferedReader(new FileReader("src/io/codat.txt"));
            FileWriter fw = new FileWriter("src/io/decodat.txt");
            BufferedWriter bf = new BufferedWriter(fw);

            int cod;
            while((cod = br.read()) != -1){
                cod -= offset;
                bf.write((char)cod);
            }

            bf.close();
            br.close();
            fw.close();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
