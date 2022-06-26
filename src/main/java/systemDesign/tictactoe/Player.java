package systemDesign.tictactoe;

public class Player {
    private String name;
    private String email;
    private char symbol;
    private long ratting;

    public Player(String name, String email, char symbol) {
        this.name = name;
        this.email = email;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public long getRatting() {
        return ratting;
    }

    public void setRatting(long ratting) {
        this.ratting = ratting;
    }

    @Override public String toString() {
        return "Player{" + "name='" + name + '\'' + ", email='" + email + '\'' + ", symbol='" + symbol + '\''
                + ", ratting=" + ratting + '}';
    }
}
