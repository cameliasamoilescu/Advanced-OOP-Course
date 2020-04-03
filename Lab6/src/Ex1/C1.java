package Ex1;

public class C1 implements  Interface1, Interface2 {

    @Override
    public void m1(){
        Interface1.super.m1();
    }
}
