package backToTheFuture;

import java.util.ArrayList;
import java.util.List;

public class Quote {
    private final String quote;
    private final Character mainCharacter;
    private Character otherCharacter;
    private List<String> manyQuotes = new ArrayList<>();

    public Quote(String quote, Character mainCharacter) {
        this.quote = quote;
        this.mainCharacter = mainCharacter;
    }

    public String getQuote() {
        return quote;
    }

    public Character getMainCharacter() {
        return mainCharacter;
    }

    public Character getOtherCharacter() {
        return otherCharacter;
    }

    public List<String> getManyQuotes() {
        return new ArrayList<>(manyQuotes);
    }

    public void setManyQuotes(List<String> manyQuotes) {
        this.manyQuotes = manyQuotes;
    }

    public void setOtherCharacter(Character otherCharacter) {
        this.otherCharacter = otherCharacter;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quote='" + quote + '\'' +
                ", mainCharacter=" + mainCharacter +
                ", otherCharacter=" + otherCharacter +
                ", manyQuotes=" + manyQuotes +
                '}';
    }
}
