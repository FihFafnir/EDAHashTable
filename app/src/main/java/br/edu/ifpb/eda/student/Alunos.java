package br.edu.ifpb.eda.student;

public class Alunos {
    private final Students students = new Students();

    public String pegarNome(int registrationCode) {
        return students.getName(registrationCode);
    }

    public void adicionarEstudante(int registrationCode, String name) {
        students.addStudent(registrationCode, name);
    }

    public Student removeEstudante(int registrationCode) {
        return students.removeStudent(registrationCode);
    }
}
