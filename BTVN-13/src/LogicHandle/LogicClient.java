package LogicHandle;

import entity.Client;
import statics.TypeClient;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LogicClient {
    public Client[] clients = new Client[100];

    public void inputInforClient() throws ArithmeticException , InputMismatchException {
        System.out.println("Bạn muốn thêm bao nhiêu khách hàng mới ");
        int number = exceptionNumber();
        for (int i = 0; i <number ; i++) {
            System.out.println("Nhập thông tin của khách hàng thứ  "+(i+1));
            Client client = new Client();
            client.infor();
            saveClient(client);
        }
    }

    private void saveClient(Client client) {
        for (int i = 0; i <clients.length ; i++) {
            if (clients[i]==null){
                clients[i]=client;
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
                System.out.println("Số khách hàng thêm mới là 1 số nguyên dương , lớn hơn không , vui lòng nhập lại");
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

    public void printClient() {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i]!=null){
                System.out.println(clients[i]);
            }
        }
    }

    public Client searchIdService(int idClient) {
        for (int j = 0; j < clients.length; j++) {
            if (clients[j]!=null && clients[j].getIdClient()==idClient) {
                return clients[j];
            }
        }
        return null;

    }
}
