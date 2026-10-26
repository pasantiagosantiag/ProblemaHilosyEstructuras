package ies.sequeros.psp.hilos.problemas;

import java.util.List;
import java.util.Random;

public class Productor implements Runnable {
    private final int numGenerator;
    private final long sleepTime;
    private List<Integer> buffer;
    public Productor(List<Integer> buffer, int numberGenerator, long sleepTime) {
        this.buffer = buffer;
        this.numGenerator=numberGenerator;
        this.sleepTime=sleepTime;
    }
    @Override
    public void run() {
        Random rand = new Random();
        int contador = 0;
        while(contador<this.numGenerator){
            int tempo=rand.nextInt(100);
            buffer.add(tempo);
            contador++;
        }
    }
}
