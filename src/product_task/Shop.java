package product_task;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Shop {
    private ArrayList<Category> categories = new ArrayList<>();

    public void add(Category category) {
        categories.add(category);
    }

    private ArrayList<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }


    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

//    public List<Product> getProducts() {
//        return Collections.unmodifiableList(products);
//    }


    public ArrayList<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    public void save() {
        exportToJson("Список_продуктов.txt");
    }

    public void load() {

    }

    public Product findProduct(String code) {
        for (Product p : products) {
            if (p.getCode().equals(code)) {
                return p;
            }
        }
        return null;
    }

    public Product findProductByName(ArrayList<Product> productsCopy, String name) {
        for (Product p : productsCopy) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public Product findProductByPrice(ArrayList<Product> productsCopy, Integer price) {
        for (Product p : productsCopy) {
            if (p.getPrice() == price) {
                return p;
            }
        }
        return null;
    }

    public Product findProductByAmount(ArrayList<Product> productsCopy, Integer amount) {
        for (Product p : productsCopy) {
            if (p.getPrice() == amount) {
                return p;
            }
        }
        return null;
    }

    public Product findProductByDiscount(ArrayList<Product> productsCopy, Integer discount) {
        for (Product p : productsCopy) {
            if (p.getDiscount() == discount) {
                return p;
            }
        }
        return null;
    }

    public Product findProductByCategory(ArrayList<Product> productsCopy, String categoryName) {
        for (Product p : productsCopy) {
            if (p.getCategory().getName().equals(categoryName)) {
                return p;
            }
        }
        return null;
    }


    public boolean removeProduct(String code) {
        Product product = findProduct(code);
        if (product != null) {
            products.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> sort(SortType type) {
//       if (type.equals(SortType.ByName))
//        if (type == SortType.ByName)
        ArrayList<Product> p = new ArrayList<>();
        switch (type) {
            case ByName -> p = sortByName();
            case ByAmount -> p = sortByAmount();
            case ByCode -> p = sortByCode();
            case ByPrice -> p = sortByPrice();
            case ByCategory -> p = sortByCategory();
            case ByDiscount -> p = sortByDiscount();
        }
        return p;
    }

    public ArrayList<Product> sortByCode() {
        ArrayList<Product> products1 = new ArrayList<>(products.stream().sorted(Comparator.comparing(Product::getCode)).toList());
//        ArrayList<String> list = new ArrayList<>();
//        for (Product p : products) {
//            String code = p.getCode();
//            list.add(code);
//        }
//        list.sort(String.CASE_INSENSITIVE_ORDER);
////Формирую новый список, сортированный
//        ArrayList<Product> productsSort = new ArrayList<>();
//        for (String codeProduct : list) {
//            Product product = findProduct(codeProduct);
//            productsSort.add(product);
//        }

        return products1;
    }

    public ArrayList<Product> sortByCategory() {
        ArrayList<Product> products1 = new ArrayList<>(products.stream().sorted(Comparator.comparing(o -> o.getCategory().getName())).toList());

//        ArrayList<String> list = new ArrayList<>();
//        for (Product p : products) {
//            String categoryName = p.getCategory().getName();
//            list.add(categoryName);
//        }
//        list.sort(String.CASE_INSENSITIVE_ORDER);
////Формирую новый список, сортированный
//        ArrayList<Product> productsSort = new ArrayList<>();
//        for (String categoryName : list) {
////Новый список, чтобы удалять от сюда выбранные продукты. Имена ведь не уникальные. Чтобы не добавлять в список несколько одинаковых продуктов, если имена совпадают
//            ArrayList<Product> productsCopy = new ArrayList<>(products);
//            Product product = findProductByCategory(productsCopy, categoryName);
//            productsSort.add(product);
//            productsCopy.remove(product);
//        }
        return products1;
    }

    public ArrayList<Product> sortByName() {
        ArrayList<Product> products1 = new ArrayList<>(products.stream().sorted(Comparator.comparing(Product::getName)).toList());
//        ArrayList<String> list = new ArrayList<>();
//        for (Product p : products) {
//            String name = p.getName();
//            list.add(name);
//        }
//        list.sort(String.CASE_INSENSITIVE_ORDER);
////Формирую новый список, сортированный
//        ArrayList<Product> productsSort = new ArrayList<>();
//        for (String nameProduct : list) {
////Новый список, чтобы удалять от сюда выбранные продукты. Имена ведь не уникальные. Чтобы не добавлять в список несколько одинаковых продуктов, если имена совпадают
//            ArrayList<Product> productsCopy = new ArrayList<>(products);
//            Product product = findProductByName(productsCopy, nameProduct);
//            productsSort.add(product);
//            productsCopy.remove(product);
//        }
        return products1;
    }

    public ArrayList<Product> sortByPrice() {
        ArrayList<Product> products1 = new ArrayList<>(products.stream().sorted(Comparator.comparing(Product::getPrice)).toList());
//        ArrayList<Integer> list = new ArrayList<>();
//        for (Product p : products) {
//            Integer n = p.getPrice();
//            list.add(n);
//        }
//        Collections.sort(list);
//        ArrayList<Product> productsSort = new ArrayList<>();
//        for (Integer price : list) {
//            ArrayList<Product> productsCopy = new ArrayList<>(products);
//            Product product = findProductByPrice(productsCopy, price);
//            productsSort.add(product);
//            productsCopy.remove(product);
//        }
        return products1;

    }

    public ArrayList<Product> sortByAmount() {
        ArrayList<Product> products1 = new ArrayList<>(products.stream().sorted(Comparator.comparing(Product::getAmount)).toList());
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for (Product p : products) {
//            Integer n = p.getAmount();
//            list.add(n);
//        }
//        Collections.sort(list);
//        ArrayList<Product> productsSort = new ArrayList<>();
//        for (Integer amount : list) {
//            ArrayList<Product> productsCopy = new ArrayList<>(products);
//            Product product = findProductByAmount(productsCopy, amount);
//            productsSort.add(product);
//            productsCopy.remove(product);
//        }
        return products1;
    }

    public ArrayList<Product> sortByDiscount() {
        ArrayList<Product> products1 = new ArrayList<>(products.stream().sorted(Comparator.comparing(Product::getDiscount)).toList());
//        ArrayList<Integer> list = new ArrayList<>();
//        for (Product p : products) {
//            Integer n = p.getDiscount();
//            list.add(n);
//        }
//        Collections.sort(list);
//        ArrayList<Product> productsSort = new ArrayList<>();
//        for (Integer discount : list) {
//            ArrayList<Product> productsCopy = new ArrayList<>(products);
//            Product product = findProductByDiscount(productsCopy, discount);
//            productsSort.add(product);
//            productsCopy.remove(product);
//        }
        return products1;
    }

    public HashMap<String, Integer> sumOfCategories() {
        HashMap<String, Integer> map = new HashMap<>();

        for (Product p : products) {
            if (map.containsKey(p.getCategory().getName())) {
                int amountAdd = p.getAmount();
                map.put(p.getCategory().getName(), p.getAmount() + amountAdd);//заменить в словаре уже имеющуюся категорию и сложить количество которое было и которое добавляем
            } else {
                map.put(p.getCategory().getName(), p.getAmount());
            }
        }
        //Ниже выявление самого популярного продукта
//        int topCategoryValue = 0;
//        Category categoryMaxValue = new Category(" ");

        return map;
    }
    public String topCategory(){
        HashMap<String, Integer> map = sumOfCategories();
        Optional<Map.Entry<String, Integer>> entries = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).skip(map.size()-1).findFirst();
        if (entries.isPresent()){
            return entries.get().getKey();
        }
        return "Нет продуктов";
    }

    public void exportToJson(String filename) {
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        String strJson = gson.toJson(products);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(strJson);
            writer.close();
            //Files.writeString(Path.of(URI.create(filename)), strJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void importFromJson(String filename) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {
            String s = Files.readString(Path.of(filename));
            Type typeListProduct = new TypeToken<List<Product>>() {
            }.getType();
            products = gson.fromJson(s, typeListProduct);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
