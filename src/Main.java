import exception.ElementAlreadyExistsException;
import model.Product;
import model.Recipe;
import service.PhonebookService;

import java.util.*;


public class Main {
    public static void main(String[] args) {
//        task1();
        task2();
//        task3();
//        task4();
//        task5();
    }

    private static void task1() {
        PhonebookService phonebookService = new PhonebookService();
        while (phonebookService.getSize() != 20) {
            phonebookService.addNewPhone(phonebookService.getRandomFullName(), phonebookService.getRandomPhone());
        }
        phonebookService.print();
    }

    private static void task2() {
        Product product1 = new Product("Бананы", 1200, 2.1f);
        Product product2 = new Product("Яблоки", 400, 3f);
        Product product3 = new Product("Помидоры", 500, 1.2f);

        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe1 = new Recipe("Фруктовый салат");
        Recipe recipe2 = new Recipe("Овощная нарезка");

        recipe1.addNewProduct(product1, 3);
        recipe1.addNewProduct(product2);

        recipe2.addNewProduct(product3, 10);

        addNewRecipe(recipes, recipe1);
        addNewRecipe(recipes, recipe2);

        System.out.println(recipes);

        System.out.println(recipes);

        recipes.forEach(recipe -> {
            System.out.println("Цена рецепта " + recipe.getNameRecipe() + " " + recipe.getTotalAmount());
        });
    }


    private static void addNewRecipe(Set<Recipe> recipes, Recipe recipe) {
        if (!recipes.add(recipe)) {
            throw new ElementAlreadyExistsException("Нельзя добавлять одинаковые товары");
        }
    }

    private static void task3() {
        Map<String, Integer> map = new HashMap<>();
        try {
            addNewValue("key1", 1, map);
//            addNewValue("key1",1,map);
            addNewValue("key1", 2, map);
            addNewValue("key2", 4, map);
            addNewValue("key3", 5, map);
            addNewValue("key3", 7, map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(map.toString().replace(",", ",\n"));
    }

    private static void task4() {
        Map<String, List<Integer>> mapWithList = new HashMap<>();
        mapWithList.put("key1", getRandomList(3));
        mapWithList.put("key2", getRandomList(3));
        mapWithList.put("key3", getRandomList(3));
        mapWithList.put("key4", getRandomList(3));
        mapWithList.put("key5", getRandomList(3));

        System.out.println(mapWithList.toString().replace("],", "],\n"));

        System.out.println("------- MAP WITH SUM --------");

        Map<String, Integer> mapWithSum = new HashMap<>();
        for (String key : mapWithList.keySet()) {
            mapWithSum.put(key, getSumFromList(mapWithList.get(key)));
        }

        System.out.println(mapWithSum.toString().replace(",", ",\n"));
    }

    private static void task5() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "value1");
        map.put(2, "value2");
        map.put(3, "value3");
        map.put(4, "value4");
        map.put(5, "value5");
        map.put(6, "value6");
        map.put(7, "value7");
        map.put(8, "value8");
        map.put(9, "value9");
        map.put(10, "value10");
        for (Integer key : map.keySet()) {
            System.out.format("{%d:%s}\n", key, map.get(key));
        }
    }

    private static int getSumFromList(List<Integer> list) {
        int res = 0;
        for (Integer el : list) {
            res += el;
        }
        return res;
    }


    private static List<Integer> getRandomList(int size) {
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(1000));
        }
        return list;
    }

    private static void addNewValue(String key, Integer value, Map<String, Integer> map) throws Exception {
        if (map.containsKey(key)) {
            if (map.get(key) == value) {
                throw new Exception("Такой элемент уже существует");
            }
        }
        map.put(key, value);
    }


}