package forms;

import sun.plugin2.main.server.ProxySupport;

public class Test {
    public static void main(String[] args) {
        Triangle tr = new Triangle();
        Circle ci = new Circle();

        System.out.println(ci.toString());
        System.out.println(tr.toString());


        Form[] forms = new Form[5];

        forms[0] = new Circle("rosu", 3);
        forms[1] = new Triangle("alb", 2, 3);
        forms[2] = new Triangle("roz", 4, 5);
        forms[3] = new Circle("albastru", 2);
        forms[4] = new Circle("galben", 5);

        for(int i = 0; i < forms.length; i ++){
            System.out.println(forms[i].toString());
        }

        for(int i = 0; i < forms.length; i ++){
           if(forms[i] instanceof Circle) {
               ((Circle) forms[i]).printCircleDimensions();
           }
           else
           {
               if(forms[i] instanceof Triangle) {
                   ((Triangle) forms[i]).printTriangleDimensions();
               }
           }
            System.out.println("\n");
        }

    }


}
