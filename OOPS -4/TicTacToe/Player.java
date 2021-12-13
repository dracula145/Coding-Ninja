public class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol){
        setName(name);
        setSymbol(symbol);
    }
    public void setName(String name){
        if(name.isEmpty()) this.name = "Player";
        else this.name = name;
    }
    public void setSymbol(char symbol){
        if(symbol != '\0') this.symbol = symbol;
    }
    public String getName(){ return name; }
    public char getSymbol(){ return symbol; }
}