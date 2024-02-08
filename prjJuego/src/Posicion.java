/**
 * La clase Posición representa una posición en el mapa del juego.
 * Esta clase almacena las coordenadas X e Y de una posición en el mapa.
 *
 * @author Grupo 6
 * @version 1.0
 */
public class Posicion {
    private int posX;
    private int posY;

    /**
     * Constructor de la clase posición.
     *
     * @param posx La coordenada X de la posición.
     * @param posy La coordenada Y de la posición.
     */
    public Posicion(int posx, int posy) {
        this.posX = posx;
        this.posY = posy;
    }

    /**
     * Método para obtener la coordenada X de la posición.
     *
     * @return La coordenada X de la posición.
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Método para establecer la coordenada X de la posición.
     *
     * @param posX La nueva coordenada X de la posición.
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Método para obtener la coordenada Y de la posición.
     *
     * @return La coordenada Y de la posición.
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Método para establecer la coordenada Y de la posición.
     *
     * @param posY La nueva coordenada Y de la posición.
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }
}
