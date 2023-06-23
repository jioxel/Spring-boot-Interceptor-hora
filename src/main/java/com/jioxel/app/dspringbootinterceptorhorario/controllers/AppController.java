package com.jioxel.app.dspringbootinterceptorhorario.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

      @Value("${config.horario.apertura}")
     private Integer apertura;
     @Value("${config.horario.cierre}")
     private Integer cierre;

     @GetMapping({"/index","","/"})
     public String index(Model model){
          model.addAttribute("title", "Welcome to time for listen clients");
          return "index";
     }


     @GetMapping("/cerrado")
     public String cerrado(Model model){
          StringBuilder mensaje = new StringBuilder("Close, pleace come back at ");
          mensaje.append(apertura);
          mensaje.append("hrs. ");
          mensaje.append(" - ");
          mensaje.append(cierre);
          mensaje.append("hrs. ");
          model.addAttribute("title", "fuera de horario");
          model.addAttribute("mensaje", mensaje.toString());
          return "cerrado";
     }
}
