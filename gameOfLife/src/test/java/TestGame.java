import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


public class TestGame {
    
    @Test 
    public void GameOfLife(){
        BoardStrategy miBoard = new Board(5, 8);
        List<RuleStrategy> miRules = new ArrayList<>();
        miRules.add(new survivorRule());
        miRules.add(new DeadRule());
        miRules.add(new BirthRule());
        System.out.println("Reglas aniadidas:" +  miRules.size());

        Game game = new Game(miBoard, miRules);

        game.setCell(new Cell(1, 4, true));
        game.setCell(new Cell(2, 4, true));
        game.setCell(new Cell(2, 3, true));

        ApliedRules aplied = new ApliedRules(game, 5, new PrintOutput());
        game.registerObserver(aplied);
        OriginalDisplay original = new OriginalDisplay(game);
        game.registerObserver(original);

        System.out.println("Observers aniadidos: " + game.getObservers().size());

        game.nextGeneration();
        game.nextGeneration();
        game.nextGeneration();

}



}
