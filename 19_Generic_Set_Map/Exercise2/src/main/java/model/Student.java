package model;

public class Student {
    private Integer number;

    public Student(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;
        return number.equals(student.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
