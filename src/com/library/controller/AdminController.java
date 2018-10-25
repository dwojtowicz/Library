package com.library.controller;

import com.library.entity.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/addBook")
    public String addBook(Model theModel){

        Book theBook = new Book();

        theModel.addAttribute("book", theBook);

        return "add-book";
    }

    @GetMapping("/update")
    public String update(@RequestParam("bookId") int theId, Model theModel){

        Book theBook = bookService.getBooks(theId);
        theModel.addAttribute("book", theBook);
        return "add-book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book theBook){

        bookService.saveBook(theBook);

        return "redirect:/admin/menu";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("bookId") int theId){
        bookService.deleteBook(theId);
        return "redirect:/admin/menu";
    }

    @GetMapping("/detail")
    public String bookDetail(@RequestParam("bookId") int theId, Model theModel){

        Book theBook = bookService.getBooks(theId);

        theModel.addAttribute("book", theBook);

        return "book-detail";
    }

}
