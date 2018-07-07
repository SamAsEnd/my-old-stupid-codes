package com.samasend;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


public class Test {

    public static void main(String[] args) {
       
        disp("java.util.Scanner");
        
    }

    private static void disp(String className) throws SecurityException {
        Class<?> c;
        try {
            c = Class.forName(className);
        } catch (ClassNotFoundException ex) {
            System.out.println("Class is not found");
            return;
        }
        Field[] declaredFields = c.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("Field: "+field.getType().getTypeName()+" "+field.getName());
        }
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.print("Method: "+method.getReturnType().getTypeName()+" "+method.getName()+"(");
            for(Parameter p : method.getParameters()) {
                System.out.print(p.getType().getName() + " ");
            }
            System.out.println(")");
        }
    }

}
