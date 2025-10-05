import java.util.List;

public interface BoardStrategy {
    
  public void initializeGridWithDeadCells();

  public void setCell(int row, int col, Cell cell);

  public Cell getCell(int row, int col);

  public List<Cell> livingNeighbours(int row, int col);

  public int countlivingNeighbours(int row, int col);

  public boolean isInTheGrid(int row, int col);

  public boolean isAlive(int row, int col);

  public int getRowLength();

  public int getColLength();

  public BoardStrategy copyBoard();

}
