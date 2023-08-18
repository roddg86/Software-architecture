package cocktailbar;

import java.util.ArrayList;
import java.util.List;

class Cocktail {
    private String name;
    private String description;
    private List<Ingredient> ingredients;
    private Recipe recipe;

    public Cocktail(String name, String description, List<Ingredient> ingredients, Recipe recipe) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.recipe = recipe;
    }

    // геттеры и сеттеры для всех полей
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Cocktail{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                ", recipe=" + recipe +
                '}';
    }

}

class CocktailBar {
    private List<Cocktail> cocktails;

    public CocktailBar() {
        this.cocktails = new ArrayList<>();
    }

    public List<Cocktail> getCocktails() {
        return cocktails;
    }

    public void setCocktails(List<Cocktail> cocktails) {
        this.cocktails = cocktails;
    }

    public Cocktail createCocktail(String name, String description, List<Ingredient> ingredients, Recipe recipe) {
        Cocktail cocktail = new Cocktail(name, description, ingredients, recipe);
        cocktails.add(cocktail);
        return cocktail;
    }

    public void editCocktail(Cocktail cocktail, String name, String description, List<Ingredient> ingredients,
                             Recipe recipe) {
        cocktail.setName(name);
        cocktail.setDescription(description);
        cocktail.setIngredients(ingredients);
        cocktail.setRecipe(recipe);
    }

    public void saveCocktail(Cocktail cocktail) {
        // сохранить коктейль в базу данных или другое хранилище
    }

}

class User {
    private String name;
    private String email;
    private String password;
    private List<Cocktail> savedCocktails;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.savedCocktails = new ArrayList<>();
    }

    // геттеры и сеттеры для всех полей

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Cocktail> getSavedCocktails() {
        return savedCocktails;
    }

    public void setSavedCocktails(List<Cocktail> savedCocktails) {
        this.savedCocktails = savedCocktails;
    }

    public void saveCocktail(Cocktail cocktail) {
        savedCocktails.add(cocktail);
    }
}

class Ingredient {
    private String name;
    private String description;

    public Ingredient(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // геттеры и сеттеры для всех полей

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ингредиент{" +
                "название='" + name + '\'' +
                ", описание='" + description + '\'' +
                '}';
    }
}

class Recipe {
    private List<String> steps;

    public Recipe(List<String> steps) {
        this.steps = steps;
    }

    // геттеры и сеттеры для всех полей
    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Рецепт{" +
                "шаги=" + steps +
                '}';
    }
}

class Image {
    private String path;

    public Image(String path) {
        this.path = path;
    }

    // геттеры и сеттеры для всех полей

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}

public class Main {
    public static void main(String[] args) {
        // Создание списка шагов рецепта
        List<String> recipeSteps = new ArrayList<>();
        recipeSteps.add("Шаг 1: Приготовить ингредиенты");
        recipeSteps.add("Шаг 2: Смешать все ингредиенты в шейкере");
        recipeSteps.add("Шаг 3: Взболтать шейкер");
        recipeSteps.add("Шаг 4: Процедить в бокал");

        // Создание объекта Recipe
        Recipe recipe = new Recipe(recipeSteps);

        // Создание объектов Ingredient
        Ingredient vodka = new Ingredient("Водка", "Алкогольный напиток");
        Ingredient orangeJuice = new Ingredient("Апельсиновый сок", "Фруктовый сок");
        Ingredient ice = new Ingredient("Лед", "Охлаждающий элемент");

        // Создание объекта Cocktail
        Cocktail screwdriver = new Cocktail("Screwdriver", "Водка с апельсиновым соком",
                List.of(vodka, orangeJuice, ice), recipe);

        // Создание объекта CocktailBar
        CocktailBar cocktailBar = new CocktailBar();

        // Создание объекта User
        User user = new User("John Doe", "john@example.com", "password123");

        // Добавление коктейля в бар
        cocktailBar.createCocktail(screwdriver.getName(), screwdriver.getDescription(),
                screwdriver.getIngredients(), screwdriver.getRecipe());

        // Сохранение коктейля пользователем
        user.saveCocktail(screwdriver);

        // Вывод информации о коктейле
        System.out.println("Название коктейля: " + screwdriver.getName());
        System.out.println("Описание коктейля: " + screwdriver.getDescription());
        System.out.println("Ингредиенты коктейля: " + screwdriver.getIngredients());
        System.out.println("Рецепт коктейля: " + screwdriver.getRecipe().getSteps());
        System.out.println("Сохраненные коктейли пользователя: " + user.getSavedCocktails());
    }
}