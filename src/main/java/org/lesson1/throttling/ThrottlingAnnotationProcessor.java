package org.lesson1.throttling;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ThrottlingAnnotationProcessor {

    public Object process(Object object) {
        Class<?> someClass = object.getClass();
        Method[] declaredMethods = someClass.getDeclaredMethods();

        for (Method method : declaredMethods) {
            Throttling annotation = method.getAnnotation(Throttling.class);
            if (annotation != null) {
                return proxy(object, declaredMethods, annotation);
            }
        }
        return object;
    }

    private Object proxy(final Object object, final Method[] anMethod, Throttling annotation) {
       return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                                     object.getClass().getInterfaces(),
                                     new InvocationHandler() {
                                     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                        for (Method method1 : anMethod) {
                                            if (method.getName().equals(method1.getName())) {
                                                System.out.println("Invoke");
                                            }
                                        }
                                        //gateway.processRequest(args)
                                       return method.invoke(object, args);
                                     }
                                     });
    }
}
