package entity;

import java.util.Arrays;

public class Invoice {
    private Client client;
    private ManagementService[] managementService;

    public Invoice(Client client, ManagementService[] managementService) {
        this.client = client;
        this.managementService = managementService;
    }

    public ManagementService[] getManagementService() {
        return managementService;
    }

    public void setManagementService(ManagementService[] managementService) {
        this.managementService = managementService;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "client=" + client +
                ", managementService=" + Arrays.toString(managementService) +
                '}';
    }
}
