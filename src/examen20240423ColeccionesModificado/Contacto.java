package examen20240423ColeccionesModificado;



// --- CLASE CONTACTO ---
class Contacto {
    private String nombre;
    private Integer telefono;

    public Contacto(String nombre, Integer telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
}

