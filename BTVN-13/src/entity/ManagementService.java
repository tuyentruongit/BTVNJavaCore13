package entity;

public class ManagementService {
    private Service service;
    private int quantity;

    public ManagementService(Service service, int quantity) {
        this.service = service;
        this.quantity = quantity;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ManagementService{" +
                "service=" + service +
                ", quantity=" + quantity +
                '}';
    }
}
