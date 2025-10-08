import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


public class TestGame {
    
    @Test 
    public void GameOfLife(){
        BoardStrategy miBoard = new MatrizBoard(5, 8);
        List<RuleStrategy> miRules = new ArrayList<>();
        miRules.add(new survivorRule());
        miRules.add(new DeadRule());
        miRules.add(new BirthRule());
        System.out.println("Reglas aniadidas:" +  miRules.size());

        Game game = new Game(miBoard, miRules);

        game.setCell(new Cell(1, 2, true,Colors.NEUTRO));
        game.setCell(new Cell(2, 3, true,Colors.NEUTRO));
        game.setCell(new Cell(3, 1, true,Colors.NEUTRO));
        game.setCell(new Cell(3, 2, true,Colors.NEUTRO));
        game.setCell(new Cell(3, 3, true,Colors.NEUTRO));


        ApliedRulesDisplay aplied = new ApliedRulesDisplay(game, 3, new PrintOutput());
        OriginalDisplay original = new OriginalDisplay(game);
        BlackAndWhiteDisplay BAW = new BlackAndWhiteDisplay(game);
        WhiteAndBLackDisplay WAB = new WhiteAndBLackDisplay(game);
        ColorizedDisplay colores = new ColorizedDisplay(game);


        game.registerObserver(aplied);
        game.registerObserver(original);
        game.registerObserver(BAW);
        game.registerObserver(WAB);
        game.registerObserver(colores);


        System.out.println("Observers aniadidos: " + game.getObservers().size());

        game.nextGeneration();


        game.nextGeneration();


        game.nextGeneration();
    

    }



}
