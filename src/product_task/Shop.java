package product_task;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop {
    private ArrayList<Category> categories = new ArrayList<>();

    public void add(Category category) {
        categories.add(category);
    }

    private ArrayList<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }

    public Product findProduct(String code) {
        for (Product p : products) {
            if (p.getCode().equals(code)) {
                return p;
            }
        }
        return null;
    }
    public Product findProductByName(ArrayList<Product> products1, String name){
        for (Product p : products1) {
            if (p.getName().equals(name)){
                return p;
            }
        }
        return null;
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

    public boolean remooveProduct(String code) {
        Product product = findProduct(code);
        if (product != null) {
            products.remove(product);
            return true;
        }
        return false;
    }
    public ArrayList<Product> sortByName(){
//Чтобы удалять от сюда выбранные продукты. Имена ведь не уникальные. Чтобы не добавлять в список несколько одинаковых продуктов, если имена совпадают
        ArrayList<Product> productsCopy = new ArrayList<>(products);
        ArrayList<String> namesOfProduct = new ArrayList<>();
        for (Product p : productsCopy) {
            String name = p.getName();
            namesOfProduct.add(name);
        }
        namesOfProduct.sort(String.CASE_INSENSITIVE_ORDER);
//Формирую новый список, сортированный
        ArrayList<Product> productsSort = new ArrayList<>();
        for (String nameProduct : namesOfProduct) {
            Product product = findProductByName(productsCopy, nameProduct);
            productsSort.add(product);
            productsCopy.remove(product);
        }

//        String tmp = "";
//        for (int i = 0; i < namesOfProduct.size()-1; i++) {
//         int n = namesOfProduct.get(i).compareTo(namesOfProduct.get(i+1));
//         if (n>0){
//             tmp = namesOfProduct.get(i);
//         }
//        }


        return productsSort;
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
