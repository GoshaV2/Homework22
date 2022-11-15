package model;

import exception.ElementAlreadyExistsException;
import exception.NoSuchElementException;
import exception.NotFieldOutCompletelyException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Recipe {
    private Map<Product, Integer> productsWithCount;
    private float totalAmount;
    private String nameRecipe;

    public Recipe(String nameRecipe) {
        productsWithCount = new HashMap<>();
        if (nameRecipe == null && nameRecipe.isBlank()) {
            throw new NotFieldOutCompletelyException("Укажите корректное название");
        }
        this.nameRecipe = nameRecipe;
    }


    public void addNewProduct(Product product) {
        addNewProduct(product, 1);
    }

    public void addNewProduct(Product product, int count) {
        if (productsWithCount.containsKey(product)) {
            throw new ElementAlreadyExistsException("Продукт уже существует");
        }
        productsWithCount.put(product, count);
    }

    public void updateProduct(Product product, int count) {
        if (!productsWithCount.containsKey(product)) {
            throw new NoSuchElementException();
        } else {
            if (productsWithCount.get(product) == count) {
                throw new ElementAlreadyExistsException();
            }
        }
        productsWithCount.put(product, count);
    }

    public Product getProduct(String name) {
        for (Product product : productsWithCount.keySet()) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        throw new NoSuchElementException("Не найдено продукта с таким именем");
    }


    public float getTotalAmount() {
        totalAmount = 0;
        Set<Product> products = productsWithCount.keySet();
        for (Product product : products) {
            totalAmount += product.getCost() * productsWithCount.get(product);
        }
        return totalAmount;
    }

    public String getNameRecipe() {
        return nameRecipe;
    }

    public void setNameRecipe(String nameRecipe) {
        this.nameRecipe = nameRecipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;

        Recipe recipe = (Recipe) o;

        return nameRecipe.equals(recipe.nameRecipe);
    }

    @Override
    public int hashCode() {
        return nameRecipe.hashCode();
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "products=" + productsWithCount +
                ", totalAmount=" + totalAmount +
                ", nameRecipe='" + nameRecipe + '\'' +
                '}';
    }
}
