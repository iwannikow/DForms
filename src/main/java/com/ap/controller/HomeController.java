package com.ap.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ap.bibliothek.Generator;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    public String index(Model model) throws IOException {
        Generator generator = new Generator();
        String file = generator.generateForm();
        model.addAttribute("a", file);
		return "index";
    }
}
