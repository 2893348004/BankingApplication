package com.Merchant.Merchant.Transactions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;


@Controller
public class TransactionController {


    @Autowired
    private TransactionService transactionService;





    @GetMapping("/")
    public String viewHomePage(Model model){
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);
        return "index";
    }

    @GetMapping("/index")
    public String viewHomePage2(Model model){
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);
        return "index";}






    @PostMapping("/payForGas")
    public String saveCustomer(Transaction transaction, RedirectAttributes redirectAttributes, Model model)  {

       String tryTransact =  transactionService.tryThisTransaction(transaction);
       transactionService.saveTransactionToFile(tryTransact);


        String message = "Look at logs to see if transaction was successful";

            redirectAttributes.addFlashAttribute("message", message);


        return "redirect:/index";
    }





}
