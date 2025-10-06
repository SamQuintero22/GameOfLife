//4. Cualquier célula muerta con exactamente tres vecinas vivas se convierte en una célula viva.


public class BirthRule implements RuleStrategy {
    
    @Override
    public boolean canApply(Cell cell, int neighboursLive) {
        return cell.isDead() && neighboursLive == 3;
    }

    @Override
    public Cell apply(Cell cell) {
        return new Cell(cell.getCoorX(), cell.getCoorY(),true);
    }

}
