package LogicHandle;

import entity.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LogicService {


    Service [] services = new Service[100];

    public void inputInforService() {
        System.out.println("Bạn muốn thêm bao nhiêu dịch vụ mới");
        int number = exceptionNumber();
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập thông tin của dịch vụ thứ " +(i+1));
            Service service= new Service();
            service.infor();
            saveService(service);
        }
    }

    private void saveService(Service service) {
        for (int i = 0; i < services.length; i++) {
            if (services[i]==null){
                services[i]=service;
                break;
            }
        }
    }

    private int exceptionNumber() {
        int number;
        do {
            try {
                number = new Scanner(System.in).nextInt();
                validNumber(number);
                break;

            }catch (InvalidNumberException e ){
                System.out.println("Số dịch vụ thêm mới là 1 số nguyên dương , lớn hơn 0 , vui lòng nhập lại");
            }
            catch (InputMismatchException e){
                System.out.println("Nhập sai dữ liệu vui long nhập lại");
            }
        }while (true);

        return number;
    }
    private void validNumber(int number)throws InvalidNumberException {
        if (number<0){
            throw new InvalidNumberException();
        }
    }

    public void printService() {
        for (int i = 0; i < services.length; i++) {
            if (services[i]!=null){
                System.out.println(services[i]);
            }
        }
    }

    public Service searchIdService(int idService) {
        for (int j = 0; j < services.length; j++) {
            if (services[j]!=null && services[j].getIdService()==idService) {
                return services[j];
            }
        }
        return null;
    }
}
