public class Cell{

    boolean estadoVital; 
    private int coorX;
    private int coorY;
    private Colors color;

    public Cell(int filaCelula, int columnaCelula, boolean estadoVital, Colors color){

        this.coorX = filaCelula;
        this.coorY = columnaCelula;
        this.estadoVital = estadoVital;
        this.color = color;
    }

    public int getCoorX(){
        return coorX;
    }

    public int getCoorY(){
        return coorY;
    }

    public Colors getColor(){
        return color;
    }

    public void setColor(Colors color){
        this.color = color;
    }

    public boolean isAlive(){
        return this.estadoVital;
    }

    public boolean isDead(){
        return !this.estadoVital;
    }

    public String getSymbol() {
    String symbol = isAlive() ? "[#]" : "[_]";
    return color.getCodigoColor() + symbol + "\u001B[0m";
  }


}
