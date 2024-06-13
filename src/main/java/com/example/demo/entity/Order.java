
package com.example.demo.entity;

import java.util.Objects;

public class Order {
    private String coffeeType;
    private int coffeeQuantity;
    private String dessertType;
    private int dessertQuantity;
    public Order() {

    }


    public Order(String coffeeType, int coffeeQuantity, String dessertType, int dessertQuantity) {
        this.coffeeType = coffeeType;
        this.coffeeQuantity = coffeeQuantity;
        this.dessertType = dessertType;
        this.dessertQuantity = dessertQuantity;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public int getCoffeeQuantity() {
        return coffeeQuantity;
    }

    public void setCoffeeQuantity(int coffeeQuantity) {
        this.coffeeQuantity = coffeeQuantity;
    }

    public String getDessertType() {
        return dessertType;
    }

    public void setDessertType(String dessertType) {
        this.dessertType = dessertType;
    }

    public int getDessertQuantity() {
        return dessertQuantity;
    }

    public void setDessertQuantity(int dessertQuantity) {
        this.dessertQuantity = dessertQuantity;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return coffeeQuantity == order.coffeeQuantity && dessertQuantity == order.dessertQuantity && Objects.equals(coffeeType, order.coffeeType) && Objects.equals(dessertType, order.dessertType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeType, coffeeQuantity, dessertType, dessertQuantity);
    }

    @Override
    public String toString() {
        return "Order{" +
                "coffeeType='" + coffeeType + '\'' +
                ", coffeeQuantity=" + coffeeQuantity +
                ", dessertType='" + dessertType + '\'' +
                ", dessertQuantity=" + dessertQuantity +
                '}';
    }
}

