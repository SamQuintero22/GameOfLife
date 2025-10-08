public class ApliedRulesDisplay implements DisplayElement, Observer{
    private BoardStrategy actualBoard;
    private Game game;
    private String actualRules;
    private int actualIteration;
    private int totalIteration;
    private int totalRules;
    private OutputStrategy output;

    public ApliedRulesDisplay(Game game, int iteration, OutputStrategy output) {
    this.game = game;
    actualIteration = 0;
    this.totalIteration = iteration;
    actualBoard = game.getBoard().copyBoard();
    this.totalRules = 0;
    this.output = output;
  }

    @Override
    public void update() {
        int totalRows = actualBoard.getRowLength();
        int totalCols = actualBoard.getColLength();
        actualIteration++;
        BoardStrategy newboard = game.getBoard().copyBoard();
        actualRules = "";

        for (int actualRow = 0; actualRow < totalRows; actualRow++) {
            for (int actualCol = 0; actualCol < totalCols; actualCol++) {
                Boolean isAliveActualCell = actualBoard.isAlive(actualRow, actualCol);
                Boolean isAliveNewlCell = newboard.isAlive(actualRow, actualCol);

                if(isAliveActualCell == true && isAliveNewlCell == true){

                    actualRules += "Supervivencia, ";
                    totalRules++;

                }else if (isAliveActualCell == true && isAliveNewlCell == false) {
                    
                    actualRules += "Muerte, ";
                    totalRules++;

                }else if(isAliveActualCell == false && isAliveNewlCell == true){

                    actualRules += "Nacimiento, ";
                    totalRules++;

                }

            }
        }

        actualBoard = newboard;
        actualRules = actualRules.substring(0, actualRules.length() - 2); //eliminar , al ultimo
        display();

    }

    @Override
    public void display() {
        
    StringBuilder sb = new StringBuilder();
    sb.append("Regla aplicada: ").append(actualRules).append("\n");

    if (actualIteration == totalIteration) {
        sb.append("Total de reglas aplicadas: ");
        sb.append(totalRules);
        actualIteration = 0;
    }

    output.output(sb.toString());

    }

    public void setOutput(OutputStrategy output) {
    this.output = output;
  }
}
