/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mirea.kt.example.main;

/**
 *
 * @author arrri
 */
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("1.12 Селянкина  Арина Николаевна РИБО-01-22 Вариант 5 \n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файлу для десериализации:");
        String filePath = "";
        try {
            filePath = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Product product = (Product) inputStream.readObject();
            System.out.println("Код: " + product.getCode());
            System.out.println("Название: " + product.getName());
            System.out.println("Тип: " + product.getType());
            System.out.println("Скидка: " + product.isDiscount());
            System.out.println("Ингредиенты:");
            for (String ingredient : product.getIngredients()) {
                System.out.println("\t" + ingredient);
            }
            System.out.println("Цена: " + product.getPrice());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class Product implements Serializable {
    private static final long serialVersionUID = -3536693998646060163L;
    private long code;
    private String name;
    private String type;
    private boolean isDiscount;
    private ArrayList<String> ingredients;
    private double price;
    public Product(long code, String name, String type, boolean isDiscount, ArrayList<String> ingredients, double price) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.isDiscount = isDiscount;
        this.ingredients = ingredients;
        this.price = price;
    }
    public long getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public boolean isDiscount() {
        return isDiscount;
    }
    public ArrayList<String> getIngredients() {
        return ingredients;
    }
    public double getPrice() {
        return price;
    }
}

