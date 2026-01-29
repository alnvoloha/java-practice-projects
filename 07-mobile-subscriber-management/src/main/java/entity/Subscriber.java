package entity;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import exception.NegativeTopUpException;
import exception.InvalidTariffException;
public class Subscriber implements SubscriberActions {
    /**
     * Основной класс абонента.
     * Реализует все базовые функции: просмотр, редактирование, оплата, детализация.
     * Хранит историю операций в виде списка Document.
     */

    private static final Logger logger = LogManager.getLogger(Subscriber.class);

    private String fullName;
    private String phoneNumber;
    private String operator;
    private String tariffPlan;
    private double balance;
    private double trafficInGb;

    public Subscriber(String fullName, String phoneNumber, String operator, String tariffPlan) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.operator = operator;
        this.tariffPlan = tariffPlan;
        this.balance = 0.0;
        this.trafficInGb = 0.0;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setTariffPlan(String tariffPlan) {
        this.tariffPlan = tariffPlan;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTrafficInGb(double trafficInGb) {
        this.trafficInGb = trafficInGb;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getOperator() {
        return operator;
    }

    public String getTariffPlan() {
        return tariffPlan;
    }

    public double getBalance() {
        return balance;
    }

    public double getTrafficInGb() {
        return trafficInGb;
    }

    @Override
    public void openAccount() {
        logger.info("Account opened for " + fullName + ", number: " + phoneNumber);
    }

    @Override
    public void closeAccount() {
        logger.info("Account closed for " + phoneNumber);
    }

    @Override
    public void editAccount() {
        logger.info("Account edited for " + phoneNumber);
    }

    @Override
    public void viewAccountInfo() {
        logger.info("Account info: " + this);
    }

    @Override
    public void checkBalance() {
        logger.info("Balance: " + balance + " BYN");
    }

    @Override
    public void checkTraffic() {
        logger.info("Remaining traffic: " + trafficInGb + " GB");
    }
    @Override
    public void topUpAccount(double amount) {
        if (amount <= 0) {
            throw new NegativeTopUpException("Пополнение невозможно: сумма должна быть положительной.");
        }
        balance += amount;
        logger.info("Top up account: +" + amount + " BYN. New balance: " + balance);
    }




    @Override
    public void viewUsageDetails() {
        logger.info("Viewing usage details for " + phoneNumber);
    }

    @Override
    public void changeTariffPlan(String newTariff) {
        if (newTariff == null || newTariff.isBlank()) {
            throw new InvalidTariffException("Передан пустой тарифный план.");
        }
        logger.info("Changing tariff from " + tariffPlan + " to " + newTariff);
        this.tariffPlan = newTariff;
    }


    @Override
    public void changeOperator(String newOperator) {
        logger.info("Changing operator from " + operator + " to " + newOperator);
        this.operator = newOperator;
    }

    private final List<Document> documents = new ArrayList<>();

    public void addPayment(String type, double amount) {
        if (amount <= 0) return;
        documents.add(new Document(type, amount, LocalDate.now()));
        balance += amount;
        logger.info("Добавлен платёж: " + type + " +" + amount + " BYN");
    }

    public void viewPayments() {
        logger.info("История платежей для абонента: " + fullName);
        for (Document doc : documents) {
            logger.info(doc.toString());
        }
    }

    public List<Document> getDocumentsByType(String type) {
        List<Document> filtered = new ArrayList<>();
        for (Document d : documents) {
            if (d.getType().equalsIgnoreCase(type)) {
                filtered.add(d);
            }
        }
        return filtered;
    }


    @Override
    public String toString() {
        return "Subscriber{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", operator='" + operator + '\'' +
                ", tariffPlan='" + tariffPlan + '\'' +
                ", balance=" + balance +
                ", trafficInGb=" + trafficInGb +
                '}';
    }
}
