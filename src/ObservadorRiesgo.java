public interface ObservadorRiesgo {
    String obtenerNombre();
    void alCambiarRiesgo(String clienteId, String riesgoAnterior, String riesgoNuevo) throws Exception;
}