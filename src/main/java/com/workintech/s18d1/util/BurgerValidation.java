package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {

    public static void validateId(Long id) {
        if (id == null || id <= 0) {
            throw new BurgerException("ID değer 0 ve negatif olamaz. ID: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void validatePrice(double price) {
        if (price <= 0) {
            throw new BurgerException("Price değeri 0 ve negatif olamaz. Price: " + price, HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateContent(String content) {
        if (content == null || content.isBlank()) {
            throw new BurgerException("Content boş olamaz.", HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateBreadType(Object breadType) {
        if (breadType == null) {
            throw new BurgerException("BreadType boş olamaz.", HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateBurger(Burger burger) {
        if (burger == null) {
            throw new BurgerException("Burger body boş olamaz.", HttpStatus.BAD_REQUEST);
        }
        if (burger.getName() == null || burger.getName().isBlank()) {
            throw new BurgerException("Name boş olamaz.", HttpStatus.BAD_REQUEST);
        }
        if (burger.getPrice() == null || burger.getPrice() <= 0) {
            throw new BurgerException("Price değeri 0 ve negatif olamaz. Price: " + burger.getPrice(), HttpStatus.BAD_REQUEST);
        }
        if (burger.getBreadType() == null) {
            throw new BurgerException("BreadType boş olamaz.", HttpStatus.BAD_REQUEST);
        }
        if (burger.getContents() == null || burger.getContents().isBlank()) {
            throw new BurgerException("Contents boş olamaz.", HttpStatus.BAD_REQUEST);
        }

    }
}
