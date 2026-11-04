import java.util.Date;

public class OrdenServicio {

    private int numeroOrden;
    private Cliente cliente;
    private Usuario tecnico;
    private TipoDispositivo tipoDispositivo;
    private String marca;
    private String modelo;
    private String problema;
    private EstadoOrden estado;
    private java.sql.Date fechaIngreso;
    private String solucion;
    private double costo;
    private double precioFinal;

    public OrdenServicio(int numeroOrden, Cliente cliente, Usuario tecnico, TipoDispositivo tipoDispositivo,
            String marca, String modelo, String problema) {
        this.numeroOrden = numeroOrden;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.tipoDispositivo = tipoDispositivo;
        this.marca = marca;
        this.modelo = modelo;
        this.problema = problema;
        this.estado = EstadoOrden.ASIGNADA;
        this.fechaIngreso = new java.sql.Date(new Date().getTime());
        this.solucion = "";
        this.costo = 0;
        this.precioFinal = 0;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getTecnico() {
        return tecnico;
    }

    public void setTecnico(Usuario tecnico) {
        this.tecnico = tecnico;
    }

    public TipoDispositivo getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public java.sql.Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(java.sql.Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String mostrarDatos() {
        return "Numero de orden: " + numeroOrden
                + "\nCliente: " + cliente.getNombreCompleto()
                + "\nTecnico: " + tecnico.getNombreCompleto()
                + "\nDispositivo: " + tipoDispositivo
                + "\nMarca: " + marca
                + "\nModelo: " + modelo
                + "\nProblema: " + problema
                + "\nEstado: " + estado
                + "\nFecha de ingreso: " + fechaIngreso;
    }
}
