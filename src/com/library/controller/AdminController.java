package com.library.controller;

import com.library.entity.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BookService bookService;


    @GetMapping("/menu")
    public String admin (Model theModel){

        List<Book> theBooks = bookService.getBooks();

        theModel.addAttribute("books", theBooks);

        return "admin";
    }

    @PostMapping("/search")
    public String searchBook(@RequestParam("theSearchName")
                                     String theSearchName, Model theModel){
        List<Book> theBooks = bookService.searchBook(theSearchName);

        theModel.addAttribute("books", theBooks);

        return "admin";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("bookId") int theId){
        bookService.deleteBook(theId);
        return "redirect:/admin/menu";
    }

}
