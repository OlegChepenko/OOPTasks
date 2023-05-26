package product_task;
//д.з. при добавлении продукта, автоматически вызывается функция добавления продукта в JSON и сохраняется

import com.bethecoder.ascii_table.ASCIITable;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();

//        Product p1 = new Product("33", "Молоко деревенское", 100, 10);
//        Product p2 = new Product("56", "Кефир Простоквашино", 70, 15);
//        shop.add(p1);
//        shop.add(p2);
//
//        shop.exportToJson("products.json");
        int n;
        Product product;

        do {
            System.out.println("1.Добавить продукт");
            System.out.println("2.Вывести продукты");
            System.out.println("3.Удалить продукт");
            System.out.println("4.Редактировать продукт");
            System.out.println("5.Сортировка");
            System.out.println("6.Вывести сколько товаров какой категории");
            System.out.println("7.Вывести самую популярную категорию");
            System.out.println("0.Выйти из меню");
            n = scanner.nextInt();
            switch (n) {
                case 0:
                    break;
                case 1:
                    product = fillProduct(shop);
                    shop.add(product);
                    shop.save();
                    break;

                case 2:
                    printShopProducts(shop.getProducts());
                    break;
                case 3:
                    deleteProduct(shop);
                    break;
                case 4:
                    editProduct(shop);
                    break;
                case 5:
                    printShopProducts(shop.sortByName());
                case 6:
                case 7:
                case 8:
            }
        }
        while (n != 0);
    }

    static Product fillProduct(Shop shop) {
        Scanner scanner = new Scanner(System.in);
        String code;
        while (true) {
            System.out.println("Введите код продукта");
            code = scanner.nextLine();
            if (shop.findProduct(code) == null) {
                break;
            } else {
                System.out.println("Такой код уже есть");
            }
        }
        System.out.println("Введите наименование продукта");
        String name = scanner.nextLine();
        System.out.println("Введите цену продукта");
        int cost = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите количество");
        int count = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите скидку");
        int discount = Integer.parseInt(scanner.nextLine());
//Установить категорию
        Category category = new Category(null);
        while (category.getName() == null) {
            if (shop.getCategories().isEmpty()) {
                category = addNewCategory(shop);
            } else {
                System.out.println("Категории товаров: ");
                for (int i = 0; i < shop.getCategories().size(); i++) {
                    System.out.println(shop.getCategories().get(i).getName());
                }
                System.out.println("1. Выбрать категорию ");
                System.out.println("2. Создать новую категорию");
                int n = Integer.parseInt(scanner.nextLine());
                if (n == 2) {
                    category = addNewCategory(shop);
                } else {
                    for (int i = 0; i < shop.getCategories().size(); i++) {
                        System.out.println((i + 1) + "." + shop.getCategories().get(i).getName());
                    }
                    System.out.println("Введите категорию");
                    int k = Integer.parseInt(scanner.nextLine());
                    category = shop.getCategories().get(k - 1);

                }
            }
        }

        return new Product(code, name, cost, count, category, discount);
    }
    static Category addNewCategory(Shop shop){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Создать новую категорию");
        String s = scanner.nextLine();
        Category category = new Category(s);
        shop.add(category);
        return category;
    }


    static void printShopProducts(ArrayList<Product> products) {

        String[] tableHeaders = {"Код", "Наименование", "Цена", "Количество", "Категория"};
        String[][] tableData = new String[products.size()][tableHeaders.length];
        for (int i = 0; i < products.size(); i++) {
            tableData[i][0] = products.get(i).getCode();
            tableData[i][1] = products.get(i).getName();
            tableData[i][2] = String.valueOf(products.get(i).getCost());
            tableData[i][3] = String.valueOf(products.get(i).getCount());
            tableData[i][4] = String.valueOf(products.get(i).getCategory().getName());
        }
        ASCIITable.getInstance().printTable(tableHeaders, tableData);

    }

    static void deleteProduct(Shop shop) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Код продукта, который нужно удалить: ");
        String code = scanner.nextLine();
        if (!shop.remooveProduct(code)) {
            System.out.println("Такой продукт не найден");
        } else {
            System.out.println("Продукт удален");
        }
        printShopProducts(shop.getProducts());
    }

    static void editProduct(Shop shop) {
        ArrayList<Product> products = shop.getProducts();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Код продукта, который нужно редактировать: ");
        String code = scanner.nextLine();
        Product product = shop.findProduct(code);
        if (product != null) {
            System.out.println("Вы хотите изменить продукт: ");
            System.out.println("Код: " + product.getCode() + " Наименование: " + product.getName() + " Цена: " + product.getCost() + " Количество: "
                    + product.getCount());
            System.out.println("1. Изменить наименование");
            System.out.println("2. Изменить цену");
            System.out.println("3. Изменить количество");
            System.out.println("4. Изменить категорию");
            System.out.println("5. Изменить скидку");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n) {
                case 1:
                    System.out.println("Введите наименование продукта");
                    String newName = scanner.nextLine();
                    product.setName(newName);
                    break;
                case 2:
                    System.out.println("Введите новую цену ");
                    int cost = Integer.parseInt(scanner.nextLine());
                    product.setCost(cost);
                    break;
                case 3:
                    System.out.println("Введите новое количество");
                    int count = Integer.parseInt(scanner.nextLine());
                    product.setCount(count);
                case 4:
                    System.out.println("Введите новую категорию");
                    String category = scanner.nextLine();
                    Category category1 = new Category(category);
                    product.setCategory(category1);
                case 5:
                    System.out.println("Введите новую скидку");
                    int discount = Integer.parseInt(scanner.nextLine());
                    product.setDiscount(discount);
            }
        }
    }

    static void sortProduct(Shop shop) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("По какому признаку провести сортировку? ");
        System.out.println("1. По имени");
        System.out.println("2. По коду");
        System.out.println("3. По категории");
        System.out.println("4. По цене");
        System.out.println("5. По количеству");
        System.out.println("6. По скидке");
        int n = Integer.parseInt(scanner.nextLine());
        SortType type = SortType.values()[n];
//        ByName, ByCode, ByCategory, ByCost, ByCount, ByDiscount
    }
}
