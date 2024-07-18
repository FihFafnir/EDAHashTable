package br.edu.ifpb.eda;

import br.edu.ifpb.eda.student.Alunos;

public class Main {
    public static void main(String[] args) {
        Alunos alunos = new Alunos();
        alunos.adicionarEstudante(123, "TESTE");

        System.out.println(alunos.pegarNome(123));
        alunos.removeEstudante(123);
        System.out.println(alunos.pegarNome(123));
    }
}
