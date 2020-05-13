package ex1;

import com.sun.codemodel.internal.JTryBlock;

import java.util.*;

public class Ex1 {

    public static void main(String[] args) {
        Set<String> s1= new LinkedHashSet<>(Arrays.asList("Ana", "are", "mere"));
        adaugaElement(s1, "Ana");
        System.out.println(s1);

        adaugaElement(s1,"coapte");
        System.out.println(s1);


    }

    public static void adaugaElement(Set<String> set, String s){
        if (set.contains(s)){
            System.out.println("Element existent");
        }
        else
            set.add(s);
    }



}
