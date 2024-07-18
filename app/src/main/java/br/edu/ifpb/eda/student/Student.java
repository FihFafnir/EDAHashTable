package br.edu.ifpb.eda.student;

public class Student {
    private String name;
    private Integer registrationCode;

    public Student(String name, Integer registrationCode) {
        this.name = name;
        this.registrationCode = registrationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(int registrationCode) {
        this.registrationCode = registrationCode;
    }
}
