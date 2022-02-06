package com.user.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.data.CustomerData;
import com.user.facade.UserFacade;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private UserFacade userFacade;

    @PostMapping
    @ResponseBody
    public void registerCustomer(@RequestBody CustomerData userData, HttpServletRequest request, HttpServletResponse response) {
        userFacade.registerCustomer(userData);
        response.setStatus(HttpStatus.CREATED.value());
    }

    @GetMapping("/all")
    @ResponseBody
    public List<CustomerData> getCustomers(Principal principal) {
        System.out.println("get all customers welcome to security " + principal.getName());
        List<CustomerData> customerList = userFacade.getCustomers();
        return customerList;
    }

    @GetMapping
    @ResponseBody
    public CustomerData getCustomer() {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("get  customer by id welcome to security " + id);
        return userFacade.getCustomerById(id);
    }

    @PostMapping("/edit")
    @ResponseBody
    public void editCustomer(@RequestBody CustomerData userData, HttpServletResponse response) {
        userFacade.registerCustomer(userData);
        response.setStatus(HttpStatus.OK.value());
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteCustomer(@PathVariable String id, Model model, HttpServletResponse response) {

        userFacade.deleteCustomerById(id);
        response.setStatus(HttpStatus.OK.value());

    }
}
