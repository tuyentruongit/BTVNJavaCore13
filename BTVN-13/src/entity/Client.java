package entity;

import statics.TypeClient;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Client  implements Inputtable{
    private static int nextIdClient = 10000;
    private int idClient;
    private String name;
    private String address;
    private int phone;



    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    private TypeClient typeClient;

    public TypeClient getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(TypeClient typeClient) {
        this.typeClient = typeClient;
    }

    public Client() {
        this.idClient=nextIdClient;
        nextIdClient++;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", typeClient=" + typeClient.value+
                '}';
    }

    @Override
    public void infor() {
        System.out.println("Nhập tên của khách hàng ");
        this.setName(new Scanner(System.in).nextLine());
        System.out.println("Nhập địa chỉ của khách hàng ");
        this.setAddress(new Scanner(System.in).nextLine());
        do {
            try {
                System.out.println("Nhập số điên thoại của khách hàng ");
                this.setPhone(new Scanner(System.in).nextInt());
                break;
            } catch (InputMismatchException exception) {
                System.out.println("Số điện thoại ban vừa nhập không hợp lệ, vui lòng nhập lại số điện thoại ");
            }
        } while (true);
        System.out.println("Bạn thuộc kiểu khách hàng nào ?");
        System.out.println("1. Cá nhân");
        System.out.println("2. Đại diện đơn vị hành chính");
        System.out.println("3. Đại diện đơn vị kinh doanh");
        System.out.println("4. Quay lại");
        int typeClient = new Scanner(System.in).nextInt();
        switch (typeClient) {
            case 1:
                this.setTypeClient(TypeClient.CA_NHAN);
                break;
            case 2:
                this.setTypeClient(TypeClient.DAI_DIEN_DON_VI_HANH_CHINH);
                break;
            case 3:
                this.setTypeClient(TypeClient.DAI_DIEN_DON_VI_KINH_DOANH);
                break;
            case 4:
                break;
        }
    }
}
