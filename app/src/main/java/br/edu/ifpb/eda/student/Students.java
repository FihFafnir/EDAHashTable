package br.edu.ifpb.eda.student;

import br.edu.ifpb.eda.hashtable.HashTable;
import br.edu.ifpb.eda.hashtable.SHashTable;
import br.edu.ifpb.eda.hashtable.IHashTable;

public class Students {
    private final IHashTable<Integer, Student> table = new SHashTable<>();

    public String getName(int registrationCode) {
        Student student = table.get(registrationCode);
        return student == null ? "Aluno não existente." : table.get(registrationCode).getName();
    }

    public void addStudent(int registrationCode, String name) {
        table.add(registrationCode, new Student(name, registrationCode));
    }

    public Student removeStudent(int registrationCode) {
        return table.remove(registrationCode);
    }
}
