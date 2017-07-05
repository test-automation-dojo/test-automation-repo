import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tleibri on 5/7/17.
 */
public class SuprimeIngredientsBuilder {

    private List<String> thickCrust = new ArrayList<String>(Arrays.asList(
            "2 cups (300g) plain flour",
            "1/2 teaspoon salt",
            "2 teaspoon (1 sachet/7g) dried yeast",
            "Pinch of caster sugar"
    ));

    private List<String> thinCrust = new ArrayList<String>(Arrays.asList(
            "1 cups (150g) plain flour",
            "1/3 teaspoon salt",
            "Pinch of caster sugar"
    ));

    private List<String> pizzaBase = thickCrust;

    private List<String> pizzaToppings = new ArrayList<String>(Arrays.asList(
            "1/3 cup (80ml) passata",
            "100g Hungarian salami",
            "4 slices prosciutto, halved crossways",
            "40g button mushrooms, thinly sliced",
            "1/2 red capsicum, seeded, thinly sliced",
            "1/4 cup (40g) pitted kalamata olives",
            "4 bocconcini, coarsely torn",
            "50g vine-ripened cherry tomatoes",
            "Rocket leaves, to serve",
            "Shaved parmesan, to serve"
    ));


    public SuprimeIngredientsBuilder with(String ingredient) {
        pizzaToppings.add(ingredient);
        return this;
    }

    public SuprimeIngredientsBuilder withThinCrust() {
        this.pizzaBase = thinCrust;
        return this;
    }

    public String[] build() {
        List<String> completeList = new ArrayList<String>(pizzaBase);
        completeList.addAll(pizzaToppings);
        return completeList.toArray(new String[0]);
    }
}
