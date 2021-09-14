/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;

import java.util.ArrayList;

/**
 *
 * @author Juancho
 */
public class InformacionFacturacion {
     public int id;
        public String tipoTramite;
        public String numeroJuicio;
        public String juszgado;
        public String notaria;
        public String parroquia;
        public short numeroRazon ;
        public double valorRegistro ;
        public double valorRazon;
        public double valorMat;
        public double valorGasto;
        public double valorIva;
        public short estado;
        public String motivo;
        public String fechaIngreso;
        public String fechaEntrega;
        public String valorLetras;
        public short descuento;
        public int numeroComprobante;
        public String tipoComprobante;
        public String identificacion;
        public String nombres ;
        public String direccion;
        public String telefono;
        public String tipoIdentificacion;
        public String tipoPago;
        public String detalleExcencion ;
        public String revisor;
        public boolean entregado;
        public String cajero ;
        public String entregadoFecha;
        public String entregadoObservacion;
        public String claveAccesso;
        public String canton;
        public boolean envioMail;
        public String turnoIngreso;
        public String turnoEntrega;
        public String numeroCaso;

        public String CorreoElectronico ;

    public InformacionFacturacion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public String getNumeroJuicio() {
        return numeroJuicio;
    }

    public void setNumeroJuicio(String numeroJuicio) {
        this.numeroJuicio = numeroJuicio;
    }

    public String getJuszgado() {
        return juszgado;
    }

    public void setJuszgado(String juszgado) {
        this.juszgado = juszgado;
    }

    public String getNotaria() {
        return notaria;
    }

    public void setNotaria(String notaria) {
        this.notaria = notaria;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public short getNumeroRazon() {
        return numeroRazon;
    }

    public void setNumeroRazon(short numeroRazon) {
        this.numeroRazon = numeroRazon;
    }

    public double getValorRegistro() {
        return valorRegistro;
    }

    public void setValorRegistro(double valorRegistro) {
        this.valorRegistro = valorRegistro;
    }

    public double getValorRazon() {
        return valorRazon;
    }

    public void setValorRazon(double valorRazon) {
        this.valorRazon = valorRazon;
    }

    public double getValorMat() {
        return valorMat;
    }

    public void setValorMat(double valorMat) {
        this.valorMat = valorMat;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }

    public double getValorIva() {
        return valorIva;
    }

    public void setValorIva(double valorIva) {
        this.valorIva = valorIva;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getValorLetras() {
        return valorLetras;
    }

    public void setValorLetras(String valorLetras) {
        this.valorLetras = valorLetras;
    }

    public short getDescuento() {
        return descuento;
    }

    public void setDescuento(short descuento) {
        this.descuento = descuento;
    }

    public int getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(int numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getDetalleExcencion() {
        return detalleExcencion;
    }

    public void setDetalleExcencion(String detalleExcencion) {
        this.detalleExcencion = detalleExcencion;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }

    public String getEntregadoFecha() {
        return entregadoFecha;
    }

    public void setEntregadoFecha(String entregadoFecha) {
        this.entregadoFecha = entregadoFecha;
    }

    public String getEntregadoObservacion() {
        return entregadoObservacion;
    }

    public void setEntregadoObservacion(String entregadoObservacion) {
        this.entregadoObservacion = entregadoObservacion;
    }

    public String getClaveAccesso() {
        return claveAccesso;
    }

    public void setClaveAccesso(String claveAccesso) {
        this.claveAccesso = claveAccesso;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public boolean isEnvioMail() {
        return envioMail;
    }

    public void setEnvioMail(boolean envioMail) {
        this.envioMail = envioMail;
    }

    public String getTurnoIngreso() {
        return turnoIngreso;
    }

    public void setTurnoIngreso(String turnoIngreso) {
        this.turnoIngreso = turnoIngreso;
    }

    public String getTurnoEntrega() {
        return turnoEntrega;
    }

    public void setTurnoEntrega(String turnoEntrega) {
        this.turnoEntrega = turnoEntrega;
    }

    public String getNumeroCaso() {
        return numeroCaso;
    }

    public void setNumeroCaso(String numeroCaso) {
        this.numeroCaso = numeroCaso;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

   
       
        public double Total()
        {
            return valorGasto + valorIva + valorMat + valorRazon + valorRegistro;
        }
}
