public class Cliente {

    public static final int MAXIMO_ORDENES = 4;

    private String id;
    private String nombreCompleto;
    private String telefono;
    private String correo;
    private TipoCliente tipoCliente;
    private int[] numerosOrden;
    private int cantidadOrdenes;

    public Cliente(String id, String nombreCompleto, String telefono, String correo, TipoCliente tipoCliente) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoCliente = tipoCliente;
        this.numerosOrden = new int[MAXIMO_ORDENES];
        this.cantidadOrdenes = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public int[] getNumerosOrden() {
        return numerosOrden;
    }

    public void setNumerosOrden(int[] numerosOrden) {
        this.numerosOrden = numerosOrden;
    }

    public int getCantidadOrdenes() {
        return cantidadOrdenes;
    }

    public void setCantidadOrdenes(int cantidadOrdenes) {
        this.cantidadOrdenes = cantidadOrdenes;
    }

    public boolean puedeAgregarOrden() {
        return cantidadOrdenes < MAXIMO_ORDENES;
    }

    public boolean agregarNumeroOrden(int numeroOrden) {
        if (!puedeAgregarOrden()) {
            return false;
        }
        numerosOrden[cantidadOrdenes] = numeroOrden;
        cantidadOrdenes++;
        return true;
    }

    public String mostrarDatos() {
        String ordenes = "";
        for (int i = 0; i < cantidadOrdenes; i++) {
            ordenes += numerosOrden[i] + " ";
        }
        if (cantidadOrdenes == 0) {
            ordenes = "Sin ordenes";
        }
        return "ID: " + id
                + "\nNombre completo: " + nombreCompleto
                + "\nTelefono: " + telefono
                + "\nCorreo: " + correo
                + "\nTipo de cliente: " + tipoCliente
                + "\nOrdenes: " + ordenes;
    }
}
