package ies.sequeros.psp.hilos.problemas;

import java.util.List;
import java.util.Random;

public class Consumidor implements Runnable {
    private final int numGenerator;
    private final long sleepTime;
    private List<Integer> buffer;
    public Consumidor(List<Integer> buffer, int numberGenerator, long sleepTime) {
        this.buffer = buffer;
        this.numGenerator=numberGenerator;
        this.sleepTime=sleepTime;
    }
    @Override
    public void run() {
        Random rand = new Random();
        int contador = 0;
        while(contador<this.numGenerator){
            if(buffer.size()>0) {
                int tempo = rand.nextInt(100);
                buffer.get(0);
                //forzar el fallo
                Thread.yield();
                buffer.remove(0);
                contador++;
            }
        }
    }
}
