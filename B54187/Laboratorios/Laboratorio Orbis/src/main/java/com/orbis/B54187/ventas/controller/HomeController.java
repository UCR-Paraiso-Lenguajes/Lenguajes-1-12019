package com.orbis.B54187.ventas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value="/home")
		public String iniciar() {
			return "homepage";
		}
	}
