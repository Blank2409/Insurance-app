package com.example.insuranceapp.controller;

import com.example.insuranceapp.model.Insurance;
import com.example.insuranceapp.service.InsuranceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/insurances")
public class InsuranceController {

    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping
    public String listInsurances(Model model) {
        List<Insurance> insurances = insuranceService.getAllInsurances();
        model.addAttribute("insurances", insurances);
        return "insurance_list";
    }

    @GetMapping("/{id}")
    public String viewInsurance(@PathVariable Long id, Model model) {
        Insurance insurance = insuranceService.getInsuranceById(id);
        model.addAttribute("insurance", insurance);
        return "insurance_detail";
    }

    @GetMapping("/add")
    public String showAddInsuranceForm(Model model) {
        model.addAttribute("insurance", new Insurance());
        return "add-insurance"; // The form to add insurance
    }

    @PostMapping("/save")
    public String saveInsurance(@ModelAttribute Insurance insurance) {
        insuranceService.save(insurance);
        return "redirect:/insurances"; // Redirect to list after saving
    }

    @PostMapping("/purchase")
    public String purchaseInsurance(@RequestParam Long id, Model model) {
        Insurance insurance = insuranceService.getInsuranceById(id);
        model.addAttribute("message", "Successfully purchased " + insurance.getName());
        model.addAttribute("insurance", insurance);
        return "purchase_confirmation";
    }

    @GetMapping("/download")
    public String downloadPolicy() {
        return "redirect:/policy.pdf"; // Redirecting to static policy.pdf
    }

    @PostMapping("/delete/{id}")
    public String deleteInsurance(@PathVariable Long id) {
        insuranceService.deleteById(id);
        return "redirect:/insurances"; // Redirect to the insurance list after deletion
    }
}
