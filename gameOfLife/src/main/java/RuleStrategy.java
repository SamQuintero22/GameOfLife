public interface RuleStrategy {

    boolean canApply (Cell cell, int neighbours); //cuando es posible aplicarlas?

    Cell apply(Cell cell); //consecuencia de la regla


}
