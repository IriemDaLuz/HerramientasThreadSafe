package herramientasthreadsafe;

import java.util.Random;

public class Herramienta {
    // Variables. 
    private int numeroAgentes = 0;
    
    private boolean hayAlicates = true;
    private boolean hayDestornillador = true;
    private boolean hayTaladro = true;
    
    synchronized public int getNumeroAgentes() {
        return numeroAgentes;
    }
    synchronized public boolean getHayAlicates() {
        return hayAlicates;
    }
    synchronized public boolean getHayDestornillador() {
        return hayDestornillador;
    }
    synchronized public boolean getHayTaladro() {
        return hayTaladro;
    }

    public Herramienta(){
        
    }
    // Realizar Actividad.
    public void solicitar(Agente agente) throws InterruptedException {
        synchronized(this) {
            while ((this.hayAlicates = false) || (this.hayDestornillador=false) || (this.hayDestornillador=false)){
                 System.out.printf("--- %s debe esperar.\n", agente.getIdPersona());
                 this.wait();
            }
        }        
    }
    //Terminar Actividad.
    public void finalizar(Agente agente) {
        synchronized(this) {
            if (this.hayAlicates=false){
                this.hayAlicates=true;
            }{
            if (this.hayDestornillador=false){
                this.hayDestornillador=true;
            }
{
            if (this.hayTaladro=false){
                this.hayTaladro=true;
            }

            this.notifyAll();
            System.out.printf("<<<< %s finaliza %s. Devuelve %s.\n", 
                    agente.getIdPersona());
        }
    }
}
    }}
