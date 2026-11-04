import javax.swing.JOptionPane;

public class InicioSesion {

    private static final int CAPACIDAD = 100;

    private Usuario[] usuarios;
    private int totalUsuarios;

    public InicioSesion() {
        usuarios = new Usuario[CAPACIDAD];
        totalUsuarios = 0;
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

    public Usuario iniciarSesion() {
        while (true) {
            String entrada = JOptionPane.showInputDialog(null, "Ingrese el usuario:",
                    "Inicio de sesion", JOptionPane.QUESTION_MESSAGE);
            if (entrada == null) {
                return null;
            }
            Usuario encontrado = buscarUsuarioPorNombre(entrada.trim());
            if (encontrado == null) {
                JOptionPane.showMessageDialog(null, "El usuario no existe");
            } else if (encontrado.getEstado() == EstadoUsuario.INACTIVO) {
                JOptionPane.showMessageDialog(null, "Usuario inactivo");
            } else {
                String clave = JOptionPane.showInputDialog(null, "Ingrese la clave de acceso:",
                        "Inicio de sesion", JOptionPane.QUESTION_MESSAGE);
                if (clave != null) {
                    if (clave.equals(encontrado.getClave())) {
                        return encontrado;
                    }
                    JOptionPane.showMessageDialog(null, "Clave incorrecta");
                }
            }
        }
    }

    private Usuario buscarUsuarioPorNombre(String nombreUsuario) {
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i].getUsuario().equals(nombreUsuario)) {
                return usuarios[i];
            }
        }
        return null;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public int getTotalUsuarios() {
        return totalUsuarios;
    }
}
