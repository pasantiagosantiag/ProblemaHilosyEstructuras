package ies.sequeros.psp.hilos.problemas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;


public class Main {
    public static void main(String[] args) {
        List lista= new  ArrayList();
        List<Thread> threads= new ArrayList();
        Productor p1= new Productor(lista,1000,1000);
        threads.add(new Thread(p1));
        Productor p2= new Productor(lista,1000,1000);
        threads.add(new Thread(p2));
        Productor p3= new Productor(lista,1000,1000);
        threads.add(new Thread(p3));
        Consumidor c1= new Consumidor(lista,1000,1000);
        threads.add(new Thread(c1));
        Consumidor c2= new Consumidor(lista,1000,1000);
        threads.add(new Thread(c2));
        Consumidor c3= new Consumidor(lista,1000,1000);
        threads.add(new Thread(c3));

        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {}
        }
        System.out.println("Tamaño final del array"+lista.size());
        System.out.println("Tamaño esperado del array: 0");

    }
}