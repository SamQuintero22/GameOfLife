//1. Cualquier célula viva con menos de dos vecinas vivas muere, como si se debiera a la subpoblación.
//2. Cualquier célula viva con más de tres vecinas vivas muere, como si se debiera a la sobrepoblación.


public class DeadRule implements RuleStrategy{

    @Override
    public boolean canApply(Cell cell, int neighboursLive) {
        return cell.isAlive() && (subPoblation(cell,neighboursLive) || overPoblation(cell, neighboursLive));
    }

    private boolean subPoblation(Cell cell, int neighboursLive){

        return cell.isAlive() && neighboursLive < 2 ;
    }

    private boolean overPoblation(Cell cell, int neighboursLive){

        return cell.isAlive() && neighboursLive > 3 ;
    }

    @Override
    public Cell apply(Cell cell) {
        return new Cell(cell.getCoorX(), cell.getCoorY(),false,Colors.NEUTRO);
    }
    
}
