package it.euris.academy.webservicerest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationController {

  @ResponseBody
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String isAlive() {

    return "I'm alive!";

  }

}
