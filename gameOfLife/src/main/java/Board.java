import java.util.ArrayList;
import java.util.List;

public class Board implements BoardStrategy {
    Cell [][] matriz;
    int totalRows;
    int totalCols;


    public Board(int totalRows, int totalCols){

        matriz = new Cell[totalRows][totalCols];
        this.totalRows = totalRows;
        this.totalCols = totalCols;
        initializeGridWithDeadCells();
    }

    public void initializeGridWithDeadCells() {
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
            matriz[i][j] = new Cell(i, j,false);
            }
        }
    }

    @Override
    public boolean isInTheGrid(int coorX, int coorY) {

        return coorX >= 0 && coorY >= 0 && 
        coorX < totalRows && coorY < totalCols;

    }

    @Override
    public Cell getCell(int coorX, int coorY){

        return matriz[coorX][coorY];

    }

    @Override
    public void setCell(int row, int col, Cell cell) {
    matriz[row][col] = cell;
    }

    @Override
    public List<Cell> livingNeighbours(int coorX, int coorY) {

        List<Cell> AliveNeighbours = new ArrayList<>();

        int[][] celulasACheckear = {
            {coorX + 1, coorY},
            {coorX, coorY + 1},
            {coorX - 1, coorY},
            {coorX, coorY - 1},
            {coorX + 1, coorY + 1},
            {coorX - 1, coorY - 1},
            {coorX + 1, coorY - 1},
            {coorX - 1, coorY + 1}};

        for (int[] celulaActual : celulasACheckear) {
            
            int coorXActual = celulaActual[0];
            int coorYActual = celulaActual[1];


            if (isInTheGrid(coorXActual,coorYActual) &&
             getCell(coorXActual, coorYActual).isAlive())
                AliveNeighbours.add(getCell(coorXActual, coorYActual));
        }

        return AliveNeighbours;

    }

    @Override
    public int countlivingNeighbours(int coorX, int coorY){
        
        List<Cell> AliveNeighbours = livingNeighbours(coorX, coorY);
        
        return AliveNeighbours.size();
    }

    @Override
    public boolean isAlive(int row, int col) {
        Cell cell = getCell(row, col);
        return cell.isAlive();
    }

    @Override
    public int getRowLength() {
        return totalRows;
    }

    @Override
    public int getColLength() {
        return totalCols;

    }

    @Override
    public BoardStrategy copyBoard() {
        int rows = getRowLength();
    int cols = getColLength();
    BoardStrategy newBoard = new Board(rows, cols);
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        Cell cell = getCell(row, col);
        Cell newCell = (cell.isAlive()) ? new Cell(row, col, true)
            : new Cell(row, col, false);
        newBoard.setCell(row, col, newCell);
      }
    }
    return newBoard;
  }
    
}
