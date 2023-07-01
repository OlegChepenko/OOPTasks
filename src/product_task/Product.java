package product_task;

import java.io.Serializable;

public class Product implements Serializable {
    private String code;
    private String name;
    private int price;
    private int amount;
    private Category category;
    private int discount;

    public Product(String code, String name, int price, int amount, Category category, int discount) {
        setName(name);
        setPrice(price);
        setAmount(amount);
        this.code = code;
        setCategory(category);
        setDiscount(discount);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Empty name");
        }
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0)
            throw new IllegalArgumentException("Incorrect cost");
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Incorrect count");
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        if (code == null || code.isEmpty())
            throw new IllegalArgumentException("Incorrect code");
        this.code = code;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if (category.getName() == null || category.getName().isEmpty()){
            throw new IllegalArgumentException("Incorrect code");
        }
        this.category = category;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        if (discount < 0)
            throw new IllegalArgumentException("Incorrect count");
        this.discount = discount;
    }
}


//добавить категория продукта и скидка