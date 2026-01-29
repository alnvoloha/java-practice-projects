package entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CorporateSubscriberImpl extends Subscriber implements CorporateSubscriber {
    /**
     * Подкласс корпоративного абонента.
     * Добавлены функции управления номерами сотрудников и генерации счета.
     */

    private static final Logger logger = LogManager.getLogger(CorporateSubscriberImpl.class);

    private List<String> employeeNumbers;

    public CorporateSubscriberImpl(String fullName, String phoneNumber, String operator, String tariffPlan) {
        super(fullName, phoneNumber, operator, tariffPlan);
        this.employeeNumbers = new ArrayList<>();
    }

    @Override
    public void addEmployeeNumber(String phoneNumber) {
        employeeNumbers.add(phoneNumber);
        logger.info("Employee number " + phoneNumber + " added to corporate account.");
    }

    @Override
    public void generateCorporateInvoice() {
        logger.info("Corporate invoice generated for " + employeeNumbers.size() + " employees.");
    }

    public List<String> getEmployeeNumbers() {
        return employeeNumbers;
    }
}
