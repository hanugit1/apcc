package org.register.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.register.beans.O2LoginResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import o2.register.formdata.O2LoginFormData;
import o2.register.service.O2LoginService;

@Controller
public class O2LoginController {

	@Autowired
	private O2LoginService loginService;

	@RequestMapping(value = "/o2login", method = RequestMethod.GET)
	public String o2LoginShow() {

		return "O2Login";
	}

	@RequestMapping(value = "/o2Login", method = RequestMethod.POST)
	public String o2Login(@Valid @ModelAttribute O2LoginFormData loginFormData, BindingResult validResult, Model model,
			HttpServletRequest httpSerReq) {

		HttpSession httpSession = httpSerReq.getSession();
		httpSession.setAttribute("accId", loginFormData.getAccNum());

		O2LoginResp loginResp = loginService.process(loginFormData);

		if (validResult.hasErrors()) {
			System.out.println("*****Validation errors in the form data *****" + validResult.getFieldError() + "  "
					+ model.addAttribute("status", "false"));
			return "Home";

		}
		if (("0000").equals(loginResp.getRespCode())) {
			return "Home";
		} else {
			return "error";
		}

	}
}
