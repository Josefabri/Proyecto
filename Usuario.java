public class Usuario {

    private String codigo;
    private String nombreCompleto;
    private String usuario;
    private String clave;
    private EstadoUsuario estado;
    private Rol rol;

    public Usuario(String codigo, String nombreCompleto, String usuario, String clave, EstadoUsuario estado, Rol rol) {
        this.codigo = codigo;
        this.nombreCompleto = nombreCompleto;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
        this.rol = rol;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public EstadoUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadoUsuario estado) {
        this.estado = estado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getClaveOculta() {
        String asteriscos = "";
        for (int i = 0; i < clave.length(); i++) {
            asteriscos += "*";
        }
        return asteriscos;
    }

    public String mostrarDatos() {
        return "Codigo: " + codigo
                + "\nNombre completo: " + nombreCompleto
                + "\nUsuario: " + usuario
                + "\nClave: " + getClaveOculta()
                + "\nEstado: " + estado
                + "\nRol: " + rol;
    }
}
