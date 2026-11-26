public class ModuloCumplimientoLegal implements ObservadorRiesgo {
    public String obtenerNombre() {
        return "CumplimientoLegal";
    }

    public void alCambiarRiesgo(String clienteId, String riesgoAnterior, String riesgoNuevo) throws Exception {
        if (riesgoNuevo == null || riesgoNuevo.isEmpty()) {
            throw new Exception("Nivel de riesgo vacío en CumplimientoLegal.");
        }
        System.out.println("[CUMPLIMIENTO LEGAL] Cliente " + clienteId + " actualizado de " + riesgoAnterior + " a " + riesgoNuevo);
    }
}