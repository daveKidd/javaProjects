package learn;

import java.util.Objects;

public class HarryPotterCharacter {
    private String name;
    private String quote;
    private String spell;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    @Override
    public String toString() {
        return "HarryPotterCharacter{" +
                "name='" + name + '\'' +
                ", quote='" + quote + '\'' +
                ", spell='" + spell + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HarryPotterCharacter character = (HarryPotterCharacter) o;
        return name.equals(character.name) && quote.equals(character.quote) && spell.equals(character.spell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quote, spell);
    }
}
