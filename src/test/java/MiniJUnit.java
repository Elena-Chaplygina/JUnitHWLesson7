import org.junit.jupiter.api.*;

import java.lang.reflect.Method;

public class MiniJUnit {


    public static void main(String[] args) throws Exception {

        Method[] methods = DemoTest.class.getDeclaredMethods();


        for (Method method : methods) {
            BeforeAll annotation = method.getAnnotation(BeforeAll.class);
            if (annotation != null) {
                DemoTest instance = DemoTest.class.getConstructor().newInstance();
                method.invoke(instance);
            }
        }
        for (Method method : methods) {
            Test annotation = method.getAnnotation(Test.class);
            if (annotation != null) {
                for (Method methodBE : methods) {
                    BeforeEach annotationBE = methodBE.getAnnotation(BeforeEach.class);
                    if (annotationBE != null) {
                        DemoTest instanceBE = DemoTest.class.getConstructor().newInstance();
                        methodBE.invoke(instanceBE);
                    }
                }
                DemoTest instance = DemoTest.class.getConstructor().newInstance();
                try {
                    method.invoke(instance);
                    System.out.println("TEST PASSED!!!");
                } catch (Exception e) {
                    System.out.println("TEST BROKEN!!!");

                }

                for (Method methodAE : methods) {
                    AfterEach annotationAE = methodAE.getAnnotation(AfterEach.class);
                    if (annotationAE != null) {
                        DemoTest instanceAE = DemoTest.class.getConstructor().newInstance();
                        methodAE.invoke(instanceAE);
                    }
                }
            }
        }
        for (Method method : methods) {
            AfterAll annotation = method.getAnnotation(AfterAll.class);
            if (annotation != null) {
                DemoTest instance = DemoTest.class.getConstructor().newInstance();
                method.invoke(instance);
            }
        }
    }
}



