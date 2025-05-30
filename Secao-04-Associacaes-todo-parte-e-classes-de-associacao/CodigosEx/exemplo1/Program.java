package exemplo1;

public class Program {
    public static void main(String[] args) {

        Professor prof1 = new Professor("Jose", "Eng. Software");
        Professor prof2 = new Professor("Luciana", "Eventos");

        Departamento dep1 = new Departamento("Ciencia da Computação");
        Departamento dep2 = new Departamento("Turismo");

        dep1.addProfessor(prof1);
        dep2.addProfessor(prof2);

        dep1.listarProfessores();
        dep2.listarProfessores();
    }
}
