package com.zcb.controller;

import com.zcb.pojo.Books;
import com.zcb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    /*public List<Books> test(){
        return bookService.queryAllBook();
    }*/


    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }
    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }


    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book",books );
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        System.out.println("要查询的书籍:"+queryBookName);
//如果查询的数据存在空格，则优化
        Books books =
                bookService.queryBookByName(queryBookName.trim());
        List<Books> list = new ArrayList<Books>();
        list.add(books);
//如果没有查出来书籍，则返回全部书籍列表
        if (books==null){
            list = bookService.queryAllBook();
            model.addAttribute("error", "没有找到本书！");
        }
        model.addAttribute("list", list);
        return "allBook";
    }
}
