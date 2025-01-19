package org.example.hospitalmanagementsystem.Service;

import org.example.hospitalmanagementsystem.models.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    // Mock database for storing bills
    private static final List<Bill> bills = new ArrayList<>();

    // Get all bills
    public List<Bill> getAllBills() {
        try {
            logger.info("Fetching all bills");
            return bills; // Return the list of bills
        } catch (Exception e) {
            logger.error("Error fetching bills: {}", e.getMessage());
            return null;
        }
    }

    // Get a bill by ID
    public Bill getBillById(Long id) {
        try {
            logger.info("Fetching bill with ID: {}", id);
            return bills.stream()
                    .filter(bill -> bill.getId().equals(id))
                    .findFirst()
                    .orElse(null); // Return the bill if found, otherwise null
        } catch (Exception e) {
            logger.error("Error fetching bill: {}", e.getMessage());
            return null;
        }
    }

    // Add a new bill
    public Bill addBill(Bill bill) {
        try {
            logger.info("Adding new bill: {}", bill);
            bills.add(bill);
            return bill;
        } catch (Exception e) {
            logger.error("Error adding bill: {}", e.getMessage());
            return null;
        }
    }

    // Update an existing bill by ID
    public Bill updateBill(Long id, Bill updatedBill) {
        try {
            logger.info("Updating bill with ID: {}", id);
            for (int i = 0; i < bills.size(); i++) {
                if (bills.get(i).getId().equals(id)) {
                    bills.set(i, updatedBill); // Update the bill
                    return updatedBill;
                }
            }
            return null; // Return null if bill not found
        } catch (Exception e) {
            logger.error("Error updating bill: {}", e.getMessage());
            return null;
        }
    }

    // Delete a bill by ID
    public boolean deleteBillById(Long id) {
        try {
            logger.info("Deleting bill with ID: {}", id);
            return bills.removeIf(bill -> bill.getId().equals(id)); // Remove the bill if found
        } catch (Exception e) {
            logger.error("Error deleting bill: {}", e.getMessage());
            return false;
        }
    }
}
