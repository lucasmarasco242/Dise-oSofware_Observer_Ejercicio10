public class ModuloPrevencionLavado implements ObservadorRiesgo {
    public String obtenerNombre() {
        return "PrevencionLavado";
    }

    public void alCambiarRiesgo(String clienteId, String riesgoAnterior, String riesgoNuevo) throws Exception {
        if ("CRITICO".equals(riesgoNuevo)) {
            throw new Exception("Alerta crítica en PrevencionLavado para cliente " + clienteId);
        }
        System.out.println("[PREVENCION LAVADO] Evaluando operaciones de " + clienteId + " con riesgo " + riesgoNuevo);
    }
}