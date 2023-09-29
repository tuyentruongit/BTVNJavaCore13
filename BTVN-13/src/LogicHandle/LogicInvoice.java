package LogicHandle;

import entity.Client;
import entity.Invoice;
import entity.ManagementService;
import entity.Service;

import javax.sound.midi.MidiFileFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LogicInvoice {
    private LogicClient logicClient;
    private  LogicService logicService;
    public Invoice[] invoices = new Invoice[100];

    public LogicInvoice(LogicClient logicClient, LogicService logicService) {
        this.logicClient = logicClient;
        this.logicService = logicService;
    }

    public void inputInvoice() {
        System.out.println("Bạn muôn in hóa đơn cho bao nhiêu khách hàng ");
        int number  = exceptionNumber();
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập ID của khác hàng thứ "+(i+1));
            Client client = inputClientForInvoice();
            ManagementService[] managementServices = new  ManagementService[number];
            int count=0 ;
            System.out.println("Nhập Id của dịch vụ mà bạn đã sử dụng");
            Service service = inputServiceForInvoice();
            System.out.println("Nhập số lượng sử dụng của bạn");
            int quantityService = new Scanner(System.in).nextInt();
            ManagementService managementService = new ManagementService(service,quantityService);
            managementServices[count]=managementService;
            count++;
            Invoice invoice = new Invoice(client,managementServices);
            saveInvoice(invoice);
        }

    }

    private void saveInvoice(  Invoice invoice) {
        for (int j = 0; j < invoices.length; j++) {
            if (invoices[j]==null){
                invoices[j]=invoice;
                break;
            }
        }
    }

    private Service inputServiceForInvoice() {
        int idService ;
        Service service = null;
        do {
            do {
                try {
                    idService = new Scanner(System.in).nextInt();
                    break;
                }catch (InputMismatchException exception){
                    System.out.println("Dữ nhiệu bạn vừa nhập không đúng, vui lòng nhập lại");
                }
            }while (true);
            service = logicService.searchIdService(idService);
            if (service != null){
                break;
            }
            System.out.println("Id bạn vừa nhập không khớp , Vui lòng nhập lại");
        }while (true);
        return service;
    }

    private Client inputClientForInvoice() {
        int idClient ;
        Client client = null;
        do {
           do {
               try {
                   idClient = new Scanner(System.in).nextInt();
                   break;
               }catch (InputMismatchException exception){
                   System.out.println("Dữ nhiệu bạn vừa nhập không đúng, vui lòng nhập lại");
               }
           }while (true);
            client = logicClient.searchIdService(idClient);
            if (client != null){
                break;
            }
            System.out.println("Id bạn vừa nhập không khớp , Vui lòng nhập lại");
        }while (true);
        return client;
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

    public void printInvoice() {
        for (int i = 0; i < invoices.length; i++) {
            if (invoices[i]!=null){
                System.out.println(invoices[i]);
            }
        }
    }

    public void sortName() {
        for (int i = 0; i <invoices.length-1; i++) {
            for (int j = i+1; j < invoices.length; j++) {
                if ( invoices[i]!=null
                        && invoices[j]!=null
                        && invoices[i].getClient().getName().compareToIgnoreCase(invoices[j].getClient().getName())>0){
                    Invoice temp = invoices[i];
                    invoices[i]=invoices[j];
                    invoices[j]=temp;
                }
            }
        }
        printInvoice();
    }

    public void sortQuantity() {
        for (int i = 0; i <invoices.length-1 ; i++) {
            for (int j = i+1; j <invoices.length ; j++) {
                invoices[i].getManagementService();
                if (invoices[i]!=null&& invoices[j]!=null && invoices[i].getManagementService()[i].getQuantity()>invoices[j].getManagementService()[j].getQuantity()){
                        Invoice temp = invoices[i];
                        invoices[i]=invoices[j];
                        invoices[j]=temp;
                }
            }
        }

    }
}
