public class Main {
    public static void main(String[] args) {
        PerfilRiesgoCliente perfil = new PerfilRiesgoCliente("CLI-901", "BAJO");

        ObservadorRiesgo cumplimiento = new ModuloCumplimientoLegal();
        ObservadorRiesgo lavado = new ModuloPrevencionLavado();
        ObservadorRiesgo reportes = new ModuloReportesRegulatorios();

        perfil.suscribir(cumplimiento);
        perfil.suscribir(lavado);
        perfil.suscribir(reportes);

        RegistroAuditoriaRiesgo auditoria1 = perfil.cambiarNivelRiesgo("ALTO");
        System.out.println(auditoria1.obtenerResumen());

        RegistroAuditoriaRiesgo auditoria2 = perfil.cambiarNivelRiesgo("CRITICO");
        System.out.println(auditoria2.obtenerResumen());
    }
}