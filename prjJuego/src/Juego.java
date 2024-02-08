import java.util.Scanner;

/**
 * La clase Juego representa la lógica del juego y contiene los métodos para ejecutarlo.
 * Esta clase gestiona la interacción con el usuario y controla el flujo del juego.
 *
 * @author Grupo 6
 * @version 1.0
 */
public class Juego {
    private final Scanner scanner;

    /**
     * Constructor de la clase Juego.
     * Inicializa el objeto Scanner para leer la entrada del usuario.
     */
    public Juego() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Método para pintar la habitación del juego con el helado en su posición actual.
     *
     * @param nivel El nivel del juego.
     * @param helado El helado que se muestra en la habitación.
     */
    public void pintarHabitacion(Nivel nivel, Helado helado) {
        System.out.println("--------------         MAPA          --------------");
        for (int fil = -1; fil < Nivel.ALTO; fil++) {
            for (int col = 0; col <= Nivel.ANCHO; col++) {
                if (fil == -1 && col != Nivel.ANCHO) {
                    if (col > 9) System.out.print(col % 10);
                    else System.out.print(col);
                } else if (col == Nivel.ANCHO && fil != -1) System.out.print(fil);
                else if (col == 0 || col == Nivel.ANCHO - 1) System.out.print("#"); // Paredes izquierda y derecha
                else if (fil == 0 || fil == Nivel.ALTO - 1) System.out.print("#"); // Paredes primera y última fila
                else if (col == helado.getPos().getPosX() && fil == helado.getPos().getPosY())
                    System.out.print("H"); // Helado
                else System.out.print(" "); // Mapa

                if (col == Nivel.ANCHO) System.out.println(); // Siguiente línea
            }
        }
        System.out.println("---------------------------------------------------");
    }

    /**
     * Método principal para ejecutar el juego.
     * Permite al usuario mover el helado por la habitación y gestiona las colisiones con las paredes.
     *
     * @param helado El helado que se mueve por la habitación.
     * @param nivel El nivel del juego.
     */
    public void jugar(Helado helado, Nivel nivel) {
        char movimiento;
        while (true) {
            System.out.println("Ingresa tu movimiento (w/a/s/d): ");
            movimiento = scanner.next().charAt(0);
            int posX = helado.getPos().getPosX();
            int posY = helado.getPos().getPosY();
            try {
                if (movimiento == 'w') {
                    // Movimiento hacia arriba
                    if (posY > 1) {
                        helado.getPos().setPosY(posY - 1);
                    }
                } else if (movimiento == 's') {
                    // Movimiento hacia abajo
                    if (posY < Nivel.ALTO - 2) {
                        helado.getPos().setPosY(posY + 1);
                    }
                } else if (movimiento == 'a') {
                    // Movimiento hacia la izquierda
                    if (posX > 1) {
                        helado.getPos().setPosX(posX - 1);
                    }
                } else if (movimiento == 'd') {
                    // Movimiento hacia la derecha
                    if (posX < Nivel.ANCHO - 2) {
                        helado.getPos().setPosX(posX + 1);
                    }
                } else {
                    System.out.println("Movimiento no válido. Ingresa w/a/s/d.");
                }
                pintarHabitacion(nivel, helado);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("¡Has chocado contra la pared! Inténtalo de nuevo.");
            }
        }
    }
}
