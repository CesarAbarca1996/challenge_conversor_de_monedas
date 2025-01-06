import java.text.DecimalFormat;

public class Moneda {
    private String nombre;
    private double valor;

    public Moneda() {
    }

    public Moneda(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#########");
        return "Divisa='" + nombre + "', valor= $" + df.format(valor);
    }
}
