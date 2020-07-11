package ru.job4j.chapter001;

public class SimpleListTest {
    public class A {
    }

    public class B extends A {
    }

    public class C extends B {
    }


    public void wildTest() {
        SimpleList<A> list = new SimpleList<>(10);
        list.add(new A());
        list.add(new B());
        list.add(new C());

        print(list);

        printUpper(list);

        printLower(list);
    }

    public void print(SimpleList<?> list) {
        //todo
    }

    public void printUpper(SimpleList<? extends A> list) {
        //todo
    }

    public void printLower(SimpleList<? super B> list) {
        //todo
    }

}
