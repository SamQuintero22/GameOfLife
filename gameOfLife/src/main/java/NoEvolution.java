public class NoEvolution implements CellEvolutionStrategy {

  @Override
  public Cell evolve(int row, int col, BoardStrategy board) {
    return board.getCell(row, col);
  }

}