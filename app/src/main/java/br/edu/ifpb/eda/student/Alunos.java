package br.edu.ifpb.eda.student;

import br.edu.ifpb.eda.hashtable.HashTable;

public class Alunos {
    private final HashTable<Integer, Student> table = new HashTable<>();

    public String pegarNome(int registrationCode) {
        Student student = table.get(registrationCode);
        return student == null ? "Aluno não existente." : table.get(registrationCode).getName();
    }

    public void adicionarEstudante(int registrationCode, String name) {
        table.add(registrationCode, new Student(name, registrationCode));
    }

    public Student removeEstudante(int registrationCode) {
        return table.remove(registrationCode);
    }
}
