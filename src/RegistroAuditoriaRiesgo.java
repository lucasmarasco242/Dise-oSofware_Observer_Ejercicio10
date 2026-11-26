public final class RegistroAuditoriaRiesgo {
    private final String clienteId;
    private final String riesgoAnterior;
    private final String riesgoNuevo;
    private final String[] exitosos;
    private final String[] incidencias;

    public RegistroAuditoriaRiesgo(String clienteId, String riesgoAnterior, String riesgoNuevo, String[] exitosos, String[] incidencias) {
        this.clienteId = clienteId;
        this.riesgoAnterior = riesgoAnterior;
        this.riesgoNuevo = riesgoNuevo;
        this.exitosos = exitosos;
        this.incidencias = incidencias;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getRiesgoAnterior() {
        return riesgoAnterior;
    }

    public String getRiesgoNuevo() {
        return riesgoNuevo;
    }

    public String[] getExitosos() {
        return exitosos;
    }

    public String[] getIncidencias() {
        return incidencias;
    }

    public String obtenerResumen() {
        String texto = "Auditoria [" + clienteId + ": " + riesgoAnterior + " -> " + riesgoNuevo + "] Exitosos: ";
        for (int i = 0; i < exitosos.length; i++) {
            texto = texto + exitosos[i];
            if (i < exitosos.length - 1) {
                texto = texto + ", ";
            }
        }
        texto = texto + " | Incidencias: ";
        if (incidencias.length == 0) {
            texto = texto + "ninguna";
        } else {
            for (int i = 0; i < incidencias.length; i++) {
                texto = texto + incidencias[i];
                if (i < incidencias.length - 1) {
                    texto = texto + "; ";
                }
            }
        }
        return texto;
    }
}