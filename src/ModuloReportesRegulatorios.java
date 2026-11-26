public class ModuloReportesRegulatorios implements ObservadorRiesgo {
    public String obtenerNombre() {
        return "ReportesRegulatorios";
    }

    public void alCambiarRiesgo(String clienteId, String riesgoAnterior, String riesgoNuevo) throws Exception {
        System.out.println("[REPORTES REGULATORIOS] Registrando cambio de " + clienteId + " (" + riesgoAnterior + " -> " + riesgoNuevo + ")");
    }
}