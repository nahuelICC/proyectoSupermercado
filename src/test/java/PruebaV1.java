import org.example.enumerados.TipoCliente;
import org.example.enumerados.TipoProducto;
import org.example.modelos.Almacen;
import org.example.modelos.Cliente;
import org.example.modelos.Producto;

import java.time.LocalDate;

public class PruebaV1 {
    public static void main(String[] args) {
        Almacen almacen1 = new Almacen(1, "Camas", 400);
        Producto producto1 = new Producto(1, "22A", "Monster", LocalDate.of(2024, 4, 1), TipoProducto.BEBIDA, almacen1);
        Cliente cliente1 = new Cliente(1, "12345678A", "José", "Pérez", "C/Cuarzo 8", TipoCliente.PARTICULAR);
        System.out.println(almacen1);
        System.out.println(producto1);
        System.out.println(cliente1);
    }
}