package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        protected A clone() throws CloneNotSupportedException {
            return new A(i,j);
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
//            return new B(super.getI(),super.getJ(),new String(this.name));
            throw new CloneNotSupportedException();
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            return new C(super.getI(),super.getJ(),super.getName());
        }
    }

    public static void main(String[] args) throws Exception {
        A a1 = new A(1,2);
        A a2 = a1.clone();
/*        B b1 = new B(1,2,"a");
        B b2 = b1.clone();*/
        C c1 = new C(1,2,"a");
        C c2 = c1.clone();

        System.out.println("a1 " + a1);
        System.out.println("a2 " + a2);
/*        System.out.println("b1 " + b1);
        System.out.println("b2 " + b2);*/
        System.out.println("c1 " + c1);
        System.out.println("c2 " + c2);
    }
}
