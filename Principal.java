import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        InicioSesion inicioSesion = new InicioSesion();
        Usuario ingresado = inicioSesion.iniciarSesion();
        if (ingresado != null) {
            JOptionPane.showMessageDialog(null, "Ingreso correcto\nUsuario: "
                    + ingresado.getNombreCompleto() + "\nRol: " + ingresado.getRol());
        }
    }
}
