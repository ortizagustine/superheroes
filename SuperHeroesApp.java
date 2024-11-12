
// Clase Superheroe
public class Superheroe {
    private String nombre;
    private String descripcion;
    private boolean capa;

    public Superheroe(String nombre) {
        this.nombre = nombre;
        this.descripcion = "";
        this.capa = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean tieneCapa() {
        return capa;
    }

    public void setCapa(boolean capa) {
        this.capa = capa;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Descripción: " + descripcion + ", Capa: " + (capa ? "Sí" : "No");
    }
}

// Clase Dimension
public class Dimension {
    private double alto;
    private double ancho;
    private double profundidad;

    public Dimension() {
        this.alto = 0;
        this.ancho = 0;
        this.profundidad = 0;
    }

    public Dimension(double alto, double ancho, double profundidad) {
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public double getVolumen() {
        return alto * ancho * profundidad;
    }

    @Override
    public String toString() {
        return "Alto: " + alto + ", Ancho: " + ancho + ", Profundidad: " + profundidad + ", Volumen: " + getVolumen();
    }
}

// Clase Figura
public class Figura {
    private String codigo;
    private double precio;
    private Superheroe superheroe;
    private Dimension dimension;

    public Figura(String codigo, double precio, Dimension dimension, Superheroe superheroe) {
        this.codigo = codigo;
        this.precio = precio;
        this.dimension = dimension;
        this.superheroe = superheroe;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Superheroe getSuperheroe() {
        return superheroe;
    }

    public void setSuperheroe(Superheroe superheroe) {
        this.superheroe = superheroe;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public void subirPrecio(double cantidad) {
        this.precio += cantidad;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Precio: " + precio + ", Superheroe: [" + superheroe + "], Dimensión: [" + dimension + "]";
    }
}

// Clase Coleccion
import java.util.ArrayList;

public class Coleccion {
    private String nombreColeccion;
    private ArrayList<Figura> listaFiguras;

    public Coleccion(String nombreColeccion) {
        this.nombreColeccion = nombreColeccion;
        this.listaFiguras = new ArrayList<>();
    }

    public String getNombreColeccion() {
        return nombreColeccion;
    }

    public void setNombreColeccion(String nombreColeccion) {
        this.nombreColeccion = nombreColeccion;
    }

    public void añadirFigura(Figura fig) {
        listaFiguras.add(fig);
    }

    public void subirPrecio(double cantidad, String id) {
        for (Figura figura : listaFiguras) {
            if (figura.getCodigo().equals(id)) {
                figura.subirPrecio(cantidad);
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Colección: " + nombreColeccion + "\n");
        for (Figura figura : listaFiguras) {
            sb.append(figura).append("\n");
        }
        return sb.toString();
    }

    public String conCapa() {
        StringBuilder sb = new StringBuilder();
        for (Figura figura : listaFiguras) {
            if (figura.getSuperheroe().tieneCapa()) {
                sb.append(figura).append("\n");
            }
        }
        return sb.toString();
    }

    public Figura masValioso() {
        if (listaFiguras.isEmpty()) return null;
        Figura masValiosa = listaFiguras.get(0);
        for (Figura figura : listaFiguras) {
            if (figura.getPrecio() > masValiosa.getPrecio()) {
                masValiosa = figura;
            }
        }
        return masValiosa;
    }

    public double getValorColeccion() {
        double total = 0;
        for (Figura figura : listaFiguras) {
            total += figura.getPrecio();
        }
        return total;
    }

    public double getVolumenColeccion() {
        double volumenTotal = 0;
        for (Figura figura : listaFiguras) {
            volumenTotal += figura.getDimension().getVolumen();
        }
        return volumenTotal + 200;
    }
}
