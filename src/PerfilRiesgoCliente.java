public class PerfilRiesgoCliente {
    private String clienteId;
    private String nivelRiesgo;
    private ObservadorRiesgo[] observadores = new ObservadorRiesgo[20];
    private int cantidad = 0;

    public PerfilRiesgoCliente(String clienteId, String nivelRiesgoInicial) {
        this.clienteId = clienteId;
        this.nivelRiesgo = nivelRiesgoInicial;
    }

    public synchronized void suscribir(ObservadorRiesgo observador) {
        if (observador == null || cantidad >= observadores.length) {
            return;
        }
        for (int i = 0; i < cantidad; i++) {
            if (observadores[i] == observador) {
                return;
            }
        }
        observadores[cantidad] = observador;
        cantidad++;
    }

    public synchronized void desuscribir(ObservadorRiesgo observador) {
        for (int i = 0; i < cantidad; i++) {
            if (observadores[i] == observador) {
                for (int j = i; j < cantidad - 1; j++) {
                    observadores[j] = observadores[j + 1];
                }
                observadores[cantidad - 1] = null;
                cantidad--;
                return;
            }
        }
    }

    public synchronized RegistroAuditoriaRiesgo cambiarNivelRiesgo(String nuevoNivel) {
        String anterior = this.nivelRiesgo;
        this.nivelRiesgo = nuevoNivel;

        ObservadorRiesgo[] copia = new ObservadorRiesgo[cantidad];
        for (int i = 0; i < cantidad; i++) {
            copia[i] = observadores[i];
        }

        String[] tempExitosos = new String[copia.length];
        String[] tempIncidencias = new String[copia.length];
        int cantExitosos = 0;
        int cantIncidencias = 0;

        for (int i = 0; i < copia.length; i++) {
            ObservadorRiesgo obs = copia[i];
            try {
                obs.alCambiarRiesgo(clienteId, anterior, nuevoNivel);
                tempExitosos[cantExitosos] = obs.obtenerNombre();
                cantExitosos++;
            } catch (Exception e) {
                tempIncidencias[cantIncidencias] = obs.obtenerNombre() + ": " + e.getMessage();
                cantIncidencias++;
            }
        }

        String[] exitososFinal = new String[cantExitosos];
        for (int i = 0; i < cantExitosos; i++) {
            exitososFinal[i] = tempExitosos[i];
        }

        String[] incidenciasFinal = new String[cantIncidencias];
        for (int i = 0; i < cantIncidencias; i++) {
            incidenciasFinal[i] = tempIncidencias[i];
        }

        return new RegistroAuditoriaRiesgo(clienteId, anterior, nuevoNivel, exitososFinal, incidenciasFinal);
    }
}