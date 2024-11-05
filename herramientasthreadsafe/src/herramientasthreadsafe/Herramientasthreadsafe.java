package herramientasthreadsafe;

import java.util.Random;


public class Herramientasthreadsafe {

    public static void main(String[] args) {
        // Constantes.
        final int minimoTiempoRealizacion= 1;
        final int maximoTiempoRealizacion = 30;
        final int minimoTiempoDescanso = 10;
        final int maximoTiempoDescanso = 50;
        
        // Variables.
        final Herramienta herramienta = new Herramienta();
        int tiempoRealizacion = 0;
        int tiempoDescanso = 0;
        boolean hayAlicates = true;
        boolean hayDestornillador = true;
        boolean hayTaladro = true;
        String idPersona = "";
        String idActividadARealizar = "";
    
    int numeroAgentes = 0;

    while (numeroAgentes<5) {
        // Crear agente.
        numeroAgentes ++;
        idPersona = "Agente " + numeroAgentes;
        idActividadARealizar="Actividad"+numeroAgentes;
        tiempoDescanso = numeroAleatorio(minimoTiempoDescanso, maximoTiempoDescanso);
        tiempoRealizacion = numeroAleatorio(minimoTiempoRealizacion, maximoTiempoRealizacion);
        
            
        System.out.printf(">>>El %s solicita realizar la %s.Necesita %s %s",
                idPersona,idActividadARealizar);

        Thread hiloPersona = new Thread(new Agente( idPersona, tiempoDescanso, idActividadARealizar,  tiempoRealizacion, hayAlicates, hayDestornillador, hayTaladro, herramienta));
        // Esperar a que llegue.
        try {
            // Esperar un tiempo.
            Thread.sleep(tiempoDescanso * 100);
        }catch (InterruptedException ex) {
        }
        // Cruzar.
        hiloPersona.start();
    }
}
    
    public static int numeroAleatorio(int valorMinimo, int valorMaximo) {
        Random r = new Random();
        return valorMinimo + r.nextInt(valorMaximo - valorMinimo + 1);
    } 
}
    
    

