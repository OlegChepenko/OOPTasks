package product_task;

import java.io.Serializable;

public class Product implements Serializable {
    private String code;
    private String name;
    private int cost;
    private int count;
    private Category category;
    private int discount;

    public Product(String code, String name, int cost, int count, Category category, int discount) {
        setName(name);
        setCost(cost);
        setCount(count);
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if (cost < 0)
            throw new IllegalArgumentException("Incorrect cost");
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count < 0)
            throw new IllegalArgumentException("Incorrect count");
        this.count = count;
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