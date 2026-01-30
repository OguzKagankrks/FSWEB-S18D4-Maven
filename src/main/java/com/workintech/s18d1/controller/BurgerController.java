package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import jakarta.transaction.Transactional;
import lombok.Data;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
@RestController
@RequestMapping("/workintech/burgers")
public class BurgerController {

    private final BurgerDao burgerDao;

    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Burger> getAllBurgers() {
        return burgerDao.findAll();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Burger getBurger(@PathVariable Long id) {
        BurgerValidation.validateId(id);
        return burgerDao.findById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public Burger postBurger(@RequestBody Burger burger) {
        BurgerValidation.validateBurger(burger);
        return burgerDao.save(burger);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public Burger updateBurger(@PathVariable Long id, @RequestBody Burger burger) {
        BurgerValidation.validateId(id);
        BurgerValidation.validateBurger(burger);

        burger.setId(id);
        return burgerDao.update(burger);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public Burger deleteBurger(@PathVariable Long id) {
        BurgerValidation.validateId(id);
        return burgerDao.remove(id);
    }


    @GetMapping("/findByPrice")
    @ResponseStatus(HttpStatus.OK)
    public List<Burger> findByPrice(@RequestBody PriceRequest request) {
        BurgerValidation.validatePrice(request.getPrice());
        return burgerDao.findByPrice(request.getPrice());
    }


    @GetMapping("/findByBreadType")
    @ResponseStatus(HttpStatus.OK)
    public List<Burger> findByBreadType(@RequestBody BreadTypeRequest request) {
        BurgerValidation.validateBreadType(request.getBreadType());
        return burgerDao.findByBreadType(request.getBreadType());
    }


    @GetMapping("/findByContent")
    @ResponseStatus(HttpStatus.OK)
    public List<Burger> findByContent(@RequestBody ContentRequest request) {
        BurgerValidation.validateContent(request.getContent());
        return burgerDao.findByContent(request.getContent());
    }


    @Data
    private static class PriceRequest {
        private double price;
    }

    @Data
    private static class BreadTypeRequest {
        private BreadType breadType;
    }



    @Data
    private static class ContentRequest {
        private String content;
    }
}
