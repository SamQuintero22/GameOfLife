import java.util.List;
import java.util.ArrayList;

public class Game implements Subject{
      BoardStrategy board; 
      List<RuleStrategy> rules;
      private List<Observer> observers;
      private int generation;

    public Game(BoardStrategy board, List<RuleStrategy> rules) {
    this.board = board;
    this.rules = rules;
    generation = 0;
    observers = new ArrayList<>();
  }

    public void nextGeneration(){

        Board nuevoBoard = new Board(board.getRowLength(), board.getColLength());

        for (int filas = 0; filas < nuevoBoard.getRowLength(); filas++) {
            
            for (int columnas = 0; columnas < nuevoBoard.getColLength(); columnas++) {
                Cell celulaActual = board.getCell(filas, columnas);
                Boolean reglacumplida = false;
                for (RuleStrategy ruleActual : rules) {
                    if(ruleActual.canApply(celulaActual,
                        board.countlivingNeighbours(celulaActual.getCoorX(),celulaActual.getCoorY()))){

                        nuevoBoard.setCell(filas, columnas, ruleActual.apply(celulaActual));
                        reglacumplida = true;    
                        break; //aplico solo una regla a la vez 
                    }

                }   
                        if (!reglacumplida) {
                            nuevoBoard.setCell(filas, columnas, celulaActual); 
                        }

            }

        }

        board = nuevoBoard;
        generation++;

    try {
        // Pausa la ejecución por 500 milisegundos (medio segundo)
        Thread.sleep(500); 
    } catch (InterruptedException e) {
        // Maneja la interrupción, si ocurre (p. ej., si el usuario detiene el programa)
        Thread.currentThread().interrupt(); 
    }

        notifyObservers();

    }

    public void setCell(Cell cell) {
    board.setCell(cell.getCoorX(), cell.getCoorY(), cell);
    }

    public int getGeneration(){
        
        return generation;

    }

    public BoardStrategy getBoard(){

        return board;

    }

    public void mostrarTablero(){
    int totalRows = board.getRowLength();
    int totalCols = board.getColLength();
    for (int row = 0; row < totalRows; row++) {
        for (int col = 0; col < totalCols; col++) {
            Cell celula = board.getCell(row, col);
            if (celula != null && celula.isAlive()) {
                System.out.print(" O "); // viva
            } else {
                System.out.print(" . "); // muerta o null
            }

        }

        System.out.println(); 
    }

    System.out.println(); 

    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        removeObserver(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observerActual : observers) {
            observerActual.update();
        }
    }

    public List<Observer> getObservers(){
        return observers;
    }

    public static void main(String[] args) {
        
BoardStrategy miBoard = new Board(8, 8);
        List<RuleStrategy> miRules = new ArrayList<>();
        miRules.add(new survivorRule());
        miRules.add(new DeadRule());
        miRules.add(new BirthRule());
        System.out.println("Reglas aniadidas:" +  miRules.size());

        Game game = new Game(miBoard, miRules);

        game.setCell(new Cell(1, 2, true));
        game.setCell(new Cell(2, 3, true));
        game.setCell(new Cell(3, 1, true));
        game.setCell(new Cell(3, 2, true));
        game.setCell(new Cell(3, 3, true));

        ApliedRules aplied = new ApliedRules(game, 5, new PrintOutput());
        game.registerObserver(aplied);
        OriginalDisplay original = new OriginalDisplay(game);
        game.registerObserver(original);

        System.out.println("Observers aniadidos: " + game.getObservers().size());

        while (true) {
            game.nextGeneration();
        }

    }

}
