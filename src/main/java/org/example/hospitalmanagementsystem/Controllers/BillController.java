package org.example.hospitalmanagementsystem.Controllers;

import org.example.hospitalmanagementsystem.Service.BillService;
import org.example.hospitalmanagementsystem.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    @Autowired
    private BillService billService;

    // Get all bills
    @GetMapping
    public List<Bill> getAllBills() {
        System.out.println("Get All Bills");
        return billService.getAllBills();
    }

    // Create a new bill
    @PostMapping
    public Bill createBill(@RequestBody Bill bill) {
        System.out.println("Create Bill");
        return billService.addBill(bill);
    }

    // Get a bill by ID
    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id) {
        System.out.println("Get Bill");
        return billService.getBillById(id);
    }

    // Delete a bill by ID
    @DeleteMapping("/{id}")
    public String deleteBillById(@PathVariable Long id) {
        System.out.println("Delete Bill");
        boolean isDeleted = billService.deleteBillById(id);
        return isDeleted ? "Bill deleted successfully" : "Bill not found";
    }

    // Update a bill by ID
    @PutMapping("/{id}")
    public Bill updateBillById(@PathVariable Long id, @RequestBody Bill updatedBill) {
        System.out.println("Update Bill");
        return billService.updateBill(id, updatedBill);
    }
}
