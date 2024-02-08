/**
 * @author      Grupo 6
 * @version     1.0
 * */

public class Main {
    public static void main(String[] args) {
        Juego badIceCream = new Juego();
        Nivel nivel = new Nivel();
        Helado helado = new Helado();
        helado.setPos(new Posicion(Nivel.ANCHO / 2, Nivel.ALTO / 2)); // Helado aparece en la mitad del mapa
        badIceCream.pintarHabitacion(nivel, helado);
        badIceCream.jugar(helado, nivel);
    }
}