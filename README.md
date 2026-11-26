Ejercicio 10 - Sistema Empresarial de Notificación de Riesgos y Cumplimiento Legal

Explicación del programa

En este ejercicio se implementó el patrón de diseño Observer para notificar cambios en el perfil de riesgo de un cliente a módulos regulatorios, aislando errores por observador y generando un registro inmutable de auditoría, sin utilizar librerías externas ni imports.
El programa cuenta con:
- Una interfaz ObservadorRiesgo con los métodos obtenerNombre() y alCambiarRiesgo(String clienteId, String riesgoAnterior, String riesgoNuevo).
- Una clase inmutable RegistroAuditoriaRiesgo que guarda los observadores notificados con éxito y las incidencias ocurridas.
- Tres clases observadoras (ModuloCumplimientoLegal, ModuloPrevencionLavado y ModuloReportesRegulatorios) que procesan el cambio de riesgo.
- Una clase PerfilRiesgoCliente que sincroniza la gestión de observadores, aísla fallos con try-catch por observador y devuelve el registro de auditoría.

Luego, dentro del método main, se crea un perfil de riesgo, se suscriben los módulos y se realizan cambios de nivel de riesgo mostrando el resumen de auditoría.

Lógica utilizada

La lógica del programa consiste en:
- Sincronizar la suscripción, desuscripción y el cambio de riesgo en PerfilRiesgoCliente trabajando sobre una copia de los observadores.
- Envolver cada llamada a alCambiarRiesgo en un bloque try-catch individual para evitar fallos en cascada.
- Registrar éxitos e incidencias en la clase inmutable RegistroAuditoriaRiesgo.

Resultado de la ejecución

La ejecución del programa muestra en la consola lo siguiente:
[CUMPLIMIENTO LEGAL] Cliente CLI-901 actualizado de BAJO a ALTO
[PREVENCION LAVADO] Evaluando operaciones de CLI-901 con riesgo ALTO
[REPORTES REGULATORIOS] Registrando cambio de CLI-901 (BAJO -> ALTO)
Auditoria [CLI-901: BAJO -> ALTO] Exitosos: CumplimientoLegal, PrevencionLavado, ReportesRegulatorios | Incidencias: ninguna
[CUMPLIMIENTO LEGAL] Cliente CLI-901 actualizado de ALTO a CRITICO
[REPORTES REGULATORIOS] Registrando cambio de CLI-901 (ALTO -> CRITICO)
Auditoria [CLI-901: ALTO -> CRITICO] Exitosos: CumplimientoLegal, ReportesRegulatorios | Incidencias: PrevencionLavado: Alerta crítica en PrevencionLavado para cliente CLI-901

Captura de pantalla

<img width="1527" height="292" alt="image" src="https://github.com/user-attachments/assets/2da4109c-697d-40cc-b38e-19f16aa6f10c" />
