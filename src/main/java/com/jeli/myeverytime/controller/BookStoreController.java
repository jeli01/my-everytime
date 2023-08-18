package com.jeli.myeverytime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book-store")
public class BookStoreController {
    @GetMapping()
    public String bookStore() {
        return "book-store/book-store";
    }

    @GetMapping("/item")
    public String bookStoreItem() {
        return "book-store/item";
    }
}
