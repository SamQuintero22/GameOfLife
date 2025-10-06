//3. Cualquier célula viva con dos o tres vecinas vivas sobrevive a la siguiente generación.

public class survivorRule implements RuleStrategy{
    
    int neighbours;

    @Override
    public boolean canApply(Cell cell, int neighbours) {
        return cell.isAlive() && (neighbours == 2 || neighbours == 3) ;
    } 

    @Override
    public Cell apply(Cell cell) {
        return cell;
    }

}
