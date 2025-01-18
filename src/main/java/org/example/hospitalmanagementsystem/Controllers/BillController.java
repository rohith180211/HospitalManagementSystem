package org.example.hospitalmanagementsystem.Controllers;

import org.example.hospitalmanagementsystem.models.Bill;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    @GetMapping
    public List<Bill> getAllBills() {
        System.out.println("Get All Bills");
        return null;
    }

    @PostMapping
    public Bill createBill(@RequestBody Bill bill) {
        System.out.println("Create Bill");
        return bill;
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id) {
        System.out.println("Get Bill");
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBillById(@PathVariable Long id) {
        System.out.println("Delete Bill");
    }

    @PutMapping("/{id}")
    public void updateBillById(@PathVariable Long id) {
        System.out.println("Update Bill");
    }
}
