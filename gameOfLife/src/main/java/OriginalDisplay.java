public class OriginalDisplay implements DisplayElement, Observer{
    private Game game;
    int generation;
    private BoardStrategy board;

  public OriginalDisplay(Game game) {
    this.game = game;
  }
    
    @Override
    public void update() {
        generation = game.getGeneration();
        board = game.getBoard();
        display();
    }

    @Override
    public void display() {

        int totalRows = board.getRowLength();
        int totalCols = board.getColLength();

        System.out.println("Generation: " + generation);

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                Cell cell = board.getCell(row, col);
                System.out.print(cell.getSymbol() + " "); 
            }
            System.out.println();

        }

            System.out.println(); 
    }


}
