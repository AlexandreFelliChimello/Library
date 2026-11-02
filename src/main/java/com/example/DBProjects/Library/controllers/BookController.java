package com.example.DBProjects.Library.controllers;

import com.example.DBProjects.Library.domain.Book;
import com.example.DBProjects.Library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.Serializable;

@Controller
@RequestMapping("/books")
public class BookController implements Serializable {

    @Autowired
    private BookService service;

    @GetMapping("/register")
    public String registerForm(ModelMap model){

        model.addAttribute("book", new Book());
        return "books/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("book") Book book){
        service.insert(book);
        return "redirect:/books/list";
    }

    @GetMapping("/list")
    // Model é o dado que o controller disponibiliza a view
    public String list(ModelMap model){
        // service devolve a lista e ela fica com o nome "books"
            model.addAttribute("books", service.findAll());
            return "books/list";
    }
    @GetMapping("/{id}")
    //PathVariable -> Avisa spring q tem q tirar o valor da URI e passar como argumento do método
    public String findById(@PathVariable Long id, ModelMap model){
        model.addAttribute("book", service.findById(id));
        return "books/details";
    }
    @GetMapping("{id}/edit")
    public String preEdit(@PathVariable Long id, ModelMap model){
        model.addAttribute("book", service.findById(id));
        return "books/edit";
    }
    @PostMapping("{id}/edit")
    public String edit(@PathVariable Long id, @ModelAttribute("book") Book book){
        service.update(id, book);
        return "redirect:/books/list";
    }


}



