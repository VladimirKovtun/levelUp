package org.lesson1.hW1.level0;

public class HWClass2 {
    private String name;
    private int age;
    private boolean sex;

    public HWClass2() {
        name = "Marina";
        age = 16;
        sex = false;
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
