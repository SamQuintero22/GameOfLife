//Debes escribir un programa que pueda aceptar una 
//cuadrícula arbitraria de celdas y que genere una 
//cuadrícula similar que muestre la próxima generación.

import java.util.List;
import java.util.ArrayList;

public class Game {
      Board board; 
      List<Rule> rules;

    public Game(int filas, int columnas){

        board = new Board(filas, columnas);
        rules = new ArrayList<>();
        
    }

    public void nextGeneration(){

        Board nuevoBoard = new Board(board.getRowLength(), board.getColLength());

        for (int filas = 0; filas < nuevoBoard.getRowLength(); filas++) {
            
            for (int columnas = 0; columnas < nuevoBoard.getColLength(); columnas++) {
                
                for (Rule ruleActual : rules) {
                    
                    if(ruleActual.canApply(board.matriz[filas][columnas],
                    board.countlivingNeighbours(filas,columnas))){

                        nuevoBoard.matriz[filas][columnas] = ruleActual.apply(board.matriz[filas][columnas]);
                        break; //para no sobreescribir reglas 
                    }

                }

            }

        }

        board = nuevoBoard;

    }

    public void setCell(Cell cell) {
    board.setCell(cell.getCoorX(), cell.getCoorY(), cell);
    }

    public void mostrarTablero(){

    for (int i = 0; i < board.totalRows; i++) {
        for (int j = 0; j < board.totalCols; j++) {
            if (board.matriz[i][j] != null && board.matriz[i][j].isAlive()) {
                System.out.print(" O "); // viva
            } else {
                System.out.print(" . "); // muerta o null
            }

        }

        System.out.println(); // salto de línea al terminar la fila
    }

    System.out.println(); // espacio extra entre tableros

    }

    public static void main(String[] args) {

        Game game = new Game(4,4);

        game.rules.add(new BirthRule());
        game.rules.add(new DeadRule());
        game.rules.add(new survivorRule());

        game.setCell(new Cell(0, 0, true));
        game.setCell(new Cell(0,2,true));
        game.setCell(new Cell(1, 1, true));

        game.mostrarTablero();

        game.nextGeneration();

        game.mostrarTablero();
        

    }
}
