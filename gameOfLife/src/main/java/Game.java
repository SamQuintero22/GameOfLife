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
                        break; //aplico solo una regla a la vez 
                    }

                }

            }

        }

        board = nuevoBoard;

    }

    public void setCell(Cell cell) {
    board.setCell(cell.getCoorX(), cell.getCoorY(), cell);
    }

    public void mostrarTablero() throws InterruptedException{

    for (int i = 0; i < board.totalRows; i++) {
        for (int j = 0; j < board.totalCols; j++) {
            if (board.matriz[i][j] != null && board.matriz[i][j].isAlive()) {
                System.out.print(" O "); // viva
            } else {
                System.out.print(" . "); // muerta o null
            }

        }

        System.out.println(); 
    }

    System.out.println(); 
    Thread.sleep(300); // esperar 300 ms entre generaciones

    }

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game(20,20);

        game.rules.add(new BirthRule());
        game.rules.add(new DeadRule());
        game.rules.add(new survivorRule());

        // --- Esquina superior izquierda ---
        game.setCell(new Cell(0, 1, true));
        game.setCell(new Cell(1, 2, true));
        game.setCell(new Cell(2, 0, true));
        game.setCell(new Cell(2, 1, true));
        game.setCell(new Cell(2, 2, true));

        // --- Esquina inferior derecha ---
        game.setCell(new Cell(17, 16, true));
        game.setCell(new Cell(18, 17, true));
        game.setCell(new Cell(19, 15, true));
        game.setCell(new Cell(19, 16, true));
        game.setCell(new Cell(19, 17, true));



        while (true) {
            game.mostrarTablero();
            game.nextGeneration(); 
        }

    }
}
