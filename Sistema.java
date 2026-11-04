import javax.swing.JOptionPane;

public class Sistema {

    private static final int CAPACIDAD = 100;

    private Usuario[] usuarios;
    private Cliente[] clientes;
    private OrdenServicio[] ordenes;
    private int totalUsuarios;
    private int totalClientes;
    private int totalOrdenes;
    private Usuario usuarioActivo;

    public Sistema() {
        usuarios = new Usuario[CAPACIDAD];
        clientes = new Cliente[CAPACIDAD];
        ordenes = new OrdenServicio[CAPACIDAD];
        totalUsuarios = 0;
        totalClientes = 0;
        totalOrdenes = 0;
        usuarioActivo = null;
        cargarUsuariosIniciales();
    }

    private void cargarUsuariosIniciales() {
        usuarios[totalUsuarios] = new Usuario("A-200", "Administrador", "admin", "AG123456",
                EstadoUsuario.ACTIVO, Rol.ADMINISTRADOR);
        totalUsuarios++;
        usuarios[totalUsuarios] = new Usuario("T-100", "Juan Garcia", "juan123", "JG123456",
                EstadoUsuario.ACTIVO, Rol.TECNICO);
        totalUsuarios++;
    }

    public void iniciar() {
        boolean ejecutando = true;
        while (ejecutando) {
            boolean ingreso = iniciarSesion();
            if (!ingreso) {
                ejecutando = false;
            } else {
                boolean volverAlLogin;
                if (usuarioActivo.getRol() == Rol.ADMINISTRADOR) {
                    volverAlLogin = menuAdministrador();
                } else {
                    volverAlLogin = menuTecnico();
                }
                usuarioActivo = null;
                if (!volverAlLogin) {
                    ejecutando = false;
                }
            }
        }
        mostrarMensaje("Gracias por usar el sistema CompuTech");
    }

    private boolean iniciarSesion() {
        boolean autenticado = false;
        while (!autenticado) {
            String entrada = JOptionPane.showInputDialog(null, "Ingrese el usuario:",
                    "Inicio de sesion", JOptionPane.QUESTION_MESSAGE);
            if (entrada == null) {
                return false;
            }
            Usuario encontrado = buscarUsuarioPorNombre(entrada.trim());
            if (encontrado == null) {
                mostrarMensaje("El usuario no existe");
            } else if (encontrado.getEstado() == EstadoUsuario.INACTIVO) {
                mostrarMensaje("Usuario inactivo");
            } else {
                String clave = JOptionPane.showInputDialog(null, "Ingrese la clave de acceso:",
                        "Inicio de sesion", JOptionPane.QUESTION_MESSAGE);
                if (clave != null) {
                    if (clave.equals(encontrado.getClave())) {
                        usuarioActivo = encontrado;
                        autenticado = true;
                    } else {
                        mostrarMensaje("Clave incorrecta");
                    }
                }
            }
        }
        return true;
    }

    private Usuario buscarUsuarioPorNombre(String nombreUsuario) {
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i].getUsuario().equals(nombreUsuario)) {
                return usuarios[i];
            }
        }
        return null;
    }

    private boolean menuAdministrador() {
        boolean enMenu = true;
        boolean volverAlLogin = true;
        while (enMenu) {
            String opcion = JOptionPane.showInputDialog(null, textoMenuAdministrador(),
                    "Menu del Administrador", JOptionPane.PLAIN_MESSAGE);
            if (opcion == null) {
                opcion = "11";
            }
            switch (opcion.trim()) {
                case "1":
                    opcionEnDesarrollo("Generar datos");
                    break;
                case "2":
                    opcionEnDesarrollo("Mostrar clientes");
                    break;
                case "3":
                    mostrarUsuarios();
                    break;
                case "4":
                    opcionEnDesarrollo("Mostrar ordenes de servicios");
                    break;
                case "5":
                    opcionEnDesarrollo("Agregar nuevo cliente");
                    break;
                case "6":
                    opcionEnDesarrollo("Agregar nuevo usuario");
                    break;
                case "7":
                    opcionEnDesarrollo("Crear orden de servicio");
                    break;
                case "8":
                    opcionEnDesarrollo("Buscar cliente");
                    break;
                case "9":
                    opcionEnDesarrollo("Buscar usuario");
                    break;
                case "10":
                    opcionEnDesarrollo("Buscar orden de servicio");
                    break;
                case "11":
                    enMenu = false;
                    volverAlLogin = true;
                    break;
                case "12":
                    enMenu = false;
                    volverAlLogin = false;
                    break;
                default:
                    mostrarMensaje("Opcion invalida");
                    break;
            }
        }
        return volverAlLogin;
    }

    private boolean menuTecnico() {
        boolean enMenu = true;
        boolean volverAlLogin = true;
        while (enMenu) {
            String opcion = JOptionPane.showInputDialog(null, textoMenuTecnico(),
                    "Menu del Tecnico", JOptionPane.PLAIN_MESSAGE);
            if (opcion == null) {
                opcion = "3";
            }
            switch (opcion.trim()) {
                case "1":
                    opcionEnDesarrollo("Mostrar ordenes de servicios");
                    break;
                case "2":
                    opcionEnDesarrollo("Buscar orden de servicio");
                    break;
                case "3":
                    enMenu = false;
                    volverAlLogin = true;
                    break;
                case "4":
                    enMenu = false;
                    volverAlLogin = false;
                    break;
                default:
                    mostrarMensaje("Opcion invalida");
                    break;
            }
        }
        return volverAlLogin;
    }

    private String textoMenuAdministrador() {
        return "Bienvenido " + usuarioActivo.getNombreCompleto() + "\n\n"
                + "1. Generar datos\n"
                + "2. Mostrar clientes\n"
                + "3. Mostrar usuarios\n"
                + "4. Mostrar ordenes de servicios\n"
                + "5. Agregar nuevo cliente\n"
                + "6. Agregar nuevo usuario\n"
                + "7. Crear orden de servicio\n"
                + "8. Buscar cliente\n"
                + "9. Buscar usuario\n"
                + "10. Buscar orden de servicio\n"
                + "11. Cerrar sesion\n"
                + "12. Salir del sistema\n\n"
                + "Digite el numero de la opcion:";
    }

    private String textoMenuTecnico() {
        return "Bienvenido " + usuarioActivo.getNombreCompleto() + "\n\n"
                + "1. Mostrar ordenes de servicios\n"
                + "2. Buscar orden de servicio\n"
                + "3. Cerrar sesion\n"
                + "4. Salir del sistema\n\n"
                + "Digite el numero de la opcion:";
    }

    private void mostrarUsuarios() {
        String texto = "";
        for (int i = 0; i < totalUsuarios; i++) {
            texto += usuarios[i].mostrarDatos() + "\n\n";
        }
        mostrarMensaje(texto);
    }

    private void opcionEnDesarrollo(String nombreOpcion) {
        mostrarMensaje(nombreOpcion + ": opcion pendiente de implementar");
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
