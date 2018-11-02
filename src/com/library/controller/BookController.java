package com.library.controller;

import com.library.entity.Book;
import com.library.entity.BookDetail;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/menu")
    public String bookMenu(Model theModel){

        List<Book> theBooks = bookService.getBooks();

        theModel.addAttribute("books", theBooks);
        return "book-menu";
    }

    @GetMapping("/detail")
    public String bookDetail(@RequestParam("bookId") int theId, Model theModel){

        Book theBook = bookService.getBooks(theId);

        theModel.addAttribute("book", theBook);

            return "book-detail";
    }



    @GetMapping("/withdraw")
    public String withdrawBook(@RequestParam("bookId") int theId, Model theModel){

       Book theBook = bookService.withdrawBook(theId);

       theModel.addAttribute("books", theBook);

        return "redirect:/book/menu";
    }

    @GetMapping("deposit")
    public String depositBook(@RequestParam("bookId") int theId, Model theModel){

        Book theBook = bookService.depositBook(theId);

        theModel.addAttribute("books", theBook);

        return "redirect:/book/menu";
    }

    @PostMapping("/search")
    public String searchBook(@RequestParam("theSearchName")
                             String theSearchName, Model theModel){
        List<Book> theBooks = bookService.searchBook(theSearchName);

        theModel.addAttribute("books", theBooks);

        return "search-book";
    }



}
