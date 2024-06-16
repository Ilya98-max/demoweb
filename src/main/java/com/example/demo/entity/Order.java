
package com.example.demo.entity;

import java.util.Objects;

public class Order {
    private String coffeeType;
    private int coffeeQuantity;
    private String dessertType;
    private int dessertQuantity;
    private Integer userId;

    private String userName;

    public Order() {

    }

    public Order(String coffeeType, int coffeeQuantity, String dessertType, int dessertQuantity, Integer userId, String userName) {
        this.coffeeType = coffeeType;
        this.coffeeQuantity = coffeeQuantity;
        this.dessertType = dessertType;
        this.dessertQuantity = dessertQuantity;
        this.userId = userId;
        this.userName = userName;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return coffeeQuantity == order.coffeeQuantity &&
                dessertQuantity == order.dessertQuantity &&
                Objects.equals(coffeeType, order.coffeeType) &&
                Objects.equals(dessertType, order.dessertType) &&
                Objects.equals(userId, order.userId) &&
                Objects.equals(userName,order.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeType, coffeeQuantity, dessertType, dessertQuantity, userId,userName);
    }

    @Override
    public String toString() {
        return "Order{" +
                "coffeeType='" + coffeeType + '\'' +
                ", coffeeQuantity=" + coffeeQuantity +
                ", dessertType='" + dessertType + '\'' +
                ", dessertQuantity=" + dessertQuantity +
                ", userId=" + userId +
                ", userName=" + userName +
                '}';
    }
}

