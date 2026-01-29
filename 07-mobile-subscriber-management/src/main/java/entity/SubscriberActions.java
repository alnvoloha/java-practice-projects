package entity;

public interface SubscriberActions
/**
 * Интерфейс с базовыми действиями, доступными для любого абонента.
 * Включает методы редактирования, пополнения, просмотра данных и т.п.
 */
{
    void openAccount();
    void closeAccount();
    void editAccount();
    void viewAccountInfo();
    void checkBalance();
    void checkTraffic();
    void viewPayments();
    void viewUsageDetails();
    void changeTariffPlan(String newTariff);
    void changeOperator(String newOperetor);
    void topUpAccount(double amount);


}
