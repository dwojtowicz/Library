package com.library.controller;

import com.library.entity.Book;
import com.library.entity.BookDetail;
import com.library.entity.User;
import com.library.service.BookService;
import com.library.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("/register")
    private String registerUser(Model theModel ){

        User theUser = new User();

        theModel.addAttribute("user", theUser);

        return "register-form";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User theUser){

        userService.saveUser(theUser);

        return "redirect:/menu";
    }

    @GetMapping("/login")
    public String login(){
        return "login-form";
    }

    @GetMapping("/menu")
    public String bookMenu(Model theModel){

        List<Book> theBooks = bookService.getBooks();

        theModel.addAttribute("books", theBooks);

        return "book-menu";
    }

    @GetMapping("/addBook")
    public String addBook(Model theModel){

        Book theBook = new Book();

        theModel.addAttribute("book", theBook);

        return "add-book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book){

        bookService.saveBook(book);

        return "redirect:/book/menu";
    }

    @GetMapping("/detail")
    public String bookDetail(@RequestParam("bookId") int theId, Model theModel){

        Book theBook = bookService.getBooks(theId);

        theModel.addAttribute("book", theBook);



        if (theBook.getBookDetail() == null){
            BookDetail bookDetail = new BookDetail();
            theModel.addAttribute("bookDetail", bookDetail);
            theBook.setBookDetail(bookDetail);
        return "add-detail";}
        else {
            return "book-detail";}
    }

    @PostMapping("/saveDetail")
    public String saveDetail(@ModelAttribute ("bookDetail") BookDetail bookDetail){

        bookService.saveDetail(bookDetail);

        return "redirect:/book/menu";
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
