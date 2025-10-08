public class ColorizedDisplay implements DisplayElement, Observer {
    
    private Game game;
    int generation;
    private BoardStrategy actualBoard;
    private BoardStrategy previousBoard;


   public ColorizedDisplay(Game game) {
        this.game = game;
        this.actualBoard = game.getBoard().copyBoard(); 
        this.previousBoard = game.getBoard().copyBoard(); 
    }

    
    @Override
    public void update() {
        previousBoard = actualBoard.copyBoard(); //le asignamos el tablero actual al anterior

        actualBoard = game.getBoard().copyBoard(); //obtenemos el nuevo desde game

        generation = game.getGeneration(); //obtenemos la generacion desde game 
        display();
    }

    @Override
    public void display() {

        int totalRows = actualBoard.getRowLength();
        int totalCols = actualBoard.getColLength();

        System.out.println("Generation: " + generation + "colorized");

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {

                Cell oldCell = previousBoard.getCell(row, col);
                Cell actualCell = actualBoard.getCell(row, col);

                Colors colorCell = Colors.NEUTRO;
                if (oldCell.isAlive() && actualCell.isAlive()) {
                    
                    colorCell = Colors.AZUL;

                }else if(oldCell.isAlive() && actualCell.isDead()){

                    colorCell = Colors.ROJO;

                }else if(oldCell.isDead() && actualCell.isAlive()){

                    colorCell = Colors.VERDE;

                }

                actualCell.setColor(colorCell);
                
                System.out.print(actualCell.getSymbol() + " "); 
            }
            System.out.println();

        }

            System.out.println(); 
    }


}
