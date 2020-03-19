package asociere;

public class Main {
    public static void main(String[] args) {
        Profesor profesorPrincipalMate = new Profesor(1, "Popescu");
        Profesor profesorSecundarMate = new Profesor(2, "Ionescu");

        Profesor profesorInfo = new Profesor(3, "Anghel");
        Profesor profesorMateSiInfo = new Profesor(4, "Pretrescu");
        Profesor profesorInfoSiMate = new Profesor(5, "Andrei");

        Profesor[] profesoriDepartamentMate = new Profesor[]{profesorPrincipalMate, profesorSecundarMate, profesorInfoSiMate, profesorMateSiInfo};
        Profesor[] profesoriDepartamentInfo = new Profesor[]{profesorInfo, profesorInfoSiMate, profesorMateSiInfo};

        Departament departamentInfo = new Departament("info", profesoriDepartamentInfo);
        Departament departamentMate = new Departament("mate", profesoriDepartamentMate);
        departamentMate.setProfesori(new Profesor[]{profesorPrincipalMate,profesorSecundarMate,profesorMateSiInfo,profesorInfoSiMate});

        Universitate unibuc = new Universitate("unibuc", new Departament[]{departamentInfo,departamentMate});

        //System.out.println(unibuc);


        departamentInfo = null;
        System.out.println(unibuc); // nu se pierde referinta catre obiectul asociat

        System.out.println(departamentMate);
        departamentMate.getProfesori()[1] = null;
        System.out.println(departamentMate);

        System.out.println(profesorSecundarMate);

    }
}
