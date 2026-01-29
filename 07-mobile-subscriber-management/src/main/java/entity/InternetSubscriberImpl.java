package entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InternetSubscriberImpl extends Subscriber implements InternetSubscriber {
    /**
     * Подкласс интернет-абонента.
     * Добавлены функции установки статического IP и запроса доп.трафика.
     */

    private static final Logger logger = LogManager.getLogger(InternetSubscriberImpl.class);

    private String staticIP;

    public InternetSubscriberImpl(String fullName, String GetgetPhoneNumber, String operator, String tariffPlan) {
        super(fullName, GetgetPhoneNumber, operator, tariffPlan);
        this.staticIP = null;
    }

    @Override
    public void requestAdditionalDataPackage(int gb) {
        logger.info("Internet package of " + gb + " GB requested for subscriber: " + getPhoneNumber());
    }

    @Override
    public void setStaticIP(String ipAddress) {
        this.staticIP = ipAddress;
        logger.info("Static IP " + ipAddress + " set for subscriber: " + getPhoneNumber());
    }

    public String getStaticIP() {
        return staticIP;
    }
}
