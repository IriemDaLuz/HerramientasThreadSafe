package herramientasthreadsafe;

public class Agente implements Runnable {

    // Atributos.
    private final String idPersona;
    private final int tiempoDescanso;
    private final int tiempoRealizacion;
    private final String idActividadARealizar;
    private final boolean hayAlicates;
    private final boolean hayDestornillador;
    private final boolean hayTaladro;
    private final Herramienta herramienta;

    // Constructor.
    public Agente(String idPersona, int tiempoDescanso, String idActividadARealizar, int tiempoRealizacion, boolean hayAlicates, boolean hayDestornillador, boolean hayTaladro, Herramienta herramienta) {
        this.idPersona = idPersona;
        this.tiempoDescanso = tiempoDescanso;
        this.tiempoRealizacion = tiempoRealizacion;
        this.idActividadARealizar = idActividadARealizar;
        this.herramienta = herramienta;
        this.hayAlicates = hayAlicates;
        this.hayDestornillador = hayDestornillador;
        this.hayTaladro = hayTaladro;
    }

    //Getters and Setters
    public String getIdPersona() {
        return idPersona;
    }

    public int getTiempoRealizacion() {
        return tiempoRealizacion;
    }

    public int getTiempoDescanso() {
        return tiempoDescanso;
    }


    public boolean getHayAlicates() {
        return hayAlicates;
    }

    public boolean getHayTaladro() {
        return hayTaladro;
    }

    public boolean getHayDestornillador() {
        return hayDestornillador;
    }

    // M�todo run.
    @Override
    public void run() {
        System.out.printf(">>>El %s solicita realizar la %s.Necesita %s %s",
                idPersona, idActividadARealizar);
        // solicitar.
        try {
            herramienta.solicitar(this);
        } catch (InterruptedException ex) {
        }
        // realizar.
        try {
            Thread.sleep(tiempoDescanso * 100);
        } catch (InterruptedException ex) {
        }
        // Salir.
        herramienta.finalizar(this);
    }
}
