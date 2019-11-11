package org.lesson1.hW1;

public class HWClass1 {
    private String name;
    private int age;
    private boolean sex;

    public HWClass1() {
        name = "Ivan";
        age = 14;
        sex = true;
    }

    @Override
    public String toString() {
        return "HWClass1{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", sex=" + sex
                + '}';
    }
}
