public class Exercise15 {

    // 1. Create a new method in the Hero class.
    // Name: toLine
    // Inputs: none
    // Output: String
    // Description: returns the Hero's name and powers as a single line of text.

    public static void main(String[] args) {

        // 2. Instantiate your three favorite super heroes with appropriate powers.
        Power[] powers1 = {
                new Power("Web Slinging"),
                new Power("Strength")
        };
        Hero spiderman = new Hero("Spider-Man", powers1);

        Hero[] heroes = {
                spiderman,
                new Hero("Iron Man", new Power[]{new Power("Rich"), new Power("Flying")}),
                new Hero("The Hulk", new Power[]{new Power("Hulking Out"), new Power("Being Green")})
        };

        // 3. Use the `toLine` method to print each hero's details to the console.

        for (Hero hero : heroes) {
            System.out.println(hero.toLine());
        }
    }
}
