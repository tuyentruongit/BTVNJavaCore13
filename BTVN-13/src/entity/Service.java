package entity;

import statics.TypeService;

import java.util.Scanner;

public class Service implements Inputtable{
    private static int nextIdService = 100;
    private int idService;
    private String nameService;
    private String price ;
    private TypeService typeService;

    public Service() {
        this.idService=nextIdService;
        nextIdService++;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return "Service{" +
                "idService=" + idService +
                ", nameService='" + nameService + '\'' +
                ", price='" + price + '\'' +
                ", typeService=" + typeService.value +
                '}';
    }

    @Override
    public void infor() {
        System.out.println("Nhập tên của dịch vụ ");
        this.setNameService(new Scanner(System.in).nextLine());
        System.out.println("Nhập giá của dịch vụ ");
        this.setPrice(new Scanner(System.in).nextLine());
        System.out.println("Nhập đơn vị tính của dịch vụ ");
        System.out.println("1. lần ");
        System.out.println("2. chiếc ");
        System.out.println("3. cái ");
        int typeService = new Scanner(System.in).nextInt();
        switch (typeService){
            case 1:
                this.setTypeService(TypeService.LAN);
                break;
            case 2:
                this.setTypeService(TypeService.CHIEC);
                break;
            case 3:
                this.setTypeService(TypeService.CAI);
                break;
        }
    }
}
