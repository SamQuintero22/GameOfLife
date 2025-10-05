public class Cell{

    boolean estadoVital; 
    int coorX;
    int coorY;

    public Cell(int filaCelula, int columnaCelula, boolean estadoVital){

        this.coorX = filaCelula;
        this.coorY = columnaCelula;
        this.estadoVital = estadoVital;
    }

    public int getCoorX(){
        return coorX;
    }

    public int getCoorY(){
        return coorY;
    }

    public boolean isAlive(){
        return this.estadoVital;
    }

    public boolean isDead(){
        return !this.estadoVital;
    }

    public String getColoredSymbol() {
    String symbol = isAlive() ? "●" : ".";
    return symbol;
  }


}
