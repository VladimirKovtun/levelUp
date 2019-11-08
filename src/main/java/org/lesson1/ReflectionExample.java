package org.lesson1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ReflectionExample {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        User user = new User();

        Class<?> userClass = user.getClass();
        Class<?> userClass2 = user.getClass();
        System.out.println(userClass == userClass2);

        ClassLoader classLoader = userClass.getClassLoader();
        System.out.println(classLoader.getClass().getClassLoader());

        Class<?> hashMapClass = classLoader.loadClass(HashMap.class.getName());
        System.out.println(hashMapClass.getClassLoader());

        Class.forName(String.class.getName());

        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        Method[] declaredMethods = userClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }

        Constructor[] declaredConstructor = userClass.getDeclaredConstructors();
        for (Constructor constr : declaredConstructor) {
            System.out.println(constr.getName());
        }

        Field fieldName = userClass.getDeclaredField("name");
        fieldName.setAccessible(true);
        fieldName.set(user, "Mark");
        System.out.println(fieldName.get(user));
    }
}
