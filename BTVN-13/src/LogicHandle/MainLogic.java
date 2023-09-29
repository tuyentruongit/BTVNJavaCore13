package LogicHandle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainLogic {
    LogicClient logicClient = new LogicClient();
    LogicService logicService = new LogicService();
    LogicInvoice logicInvoice = new LogicInvoice(logicClient,logicService);

    public void run() {
        while (true){
            inputMenu();
            int choicefuntion = choiceNotException();

            switch (choicefuntion){
                case 1:
                    logicClient.inputInforClient();
                    break;
                case 2:
                    logicClient.printClient();
                    break;
                case 3:
                    logicService.inputInforService();
                    break;
                case 4:
                    logicService.printService();
                    break;
                case 5:
                    logicInvoice.inputInvoice();
                    break;
                case 6:
                    logicInvoice.printInvoice();
                    break;
                case 7:
                    chooseSorttype();
                    break;
                case 8:
                    break;
                case 9:
                    return;
            }
        }
    }

    private void chooseSorttype() {
        System.out.println("bạn vui lòng chọn những kiểu sắp xếp dưới đây");
        System.out.println("1. Sắp xếp theo tên");
        System.out.println("2. Sắp xếp theo số lượng sử dụng dịch vụ");
        System.out.println("3. thoát");
        int choose ;
//        do {
//          try  {
//              choose = new Scanner(System.in).nextInt();
//          }catch (InputMismatchException exception){
//              System.out.println("Dữ liệu bạn vừa nhập không đúng vui lòng nhập lại");
//          }
//        }while (true);
        do {
            choose = new Scanner(System.in).nextInt();
            if (choose>0&&choose<4){
                break;
            }
            System.out.println("Chức năng bạn vừa chọn không hợp lệ vui lòng chọn lại");
        }while (true);
        switch (choose){
            case 1:
                logicInvoice.sortName();
                break;
            case 2:
                logicInvoice.sortQuantity();
                break;
            case 3:
                break;
        }
    }



    private int choiceNotException() {
        int choice ;
        do {
            try {
                choice = choicefuntion();
                break;
            }catch (InputMismatchException exception){
                System.out.println("Chức năng bạn vừa chọn không hợp lệ , vui lòng chọn lại chức năng");
            }
        }while (true);
        return choice;
    }


    private int choicefuntion()throws InputMismatchException {
        int funtion;
        do {
            funtion = new Scanner(System.in).nextInt();
            if (funtion>0 && funtion<10){
                break;
            }
            System.out.println("Chưc năng bạn vừa chọn không hợp lệ vui lòng chọn lại ");
        }while (true);
        return funtion;
    }

    private void inputMenu() {
        System.out.println("PHẦN MỀM GÌ ĐẤY ");
        System.out.println("1. Nhập danh sách khác hàng mới ");
        System.out.println("2. In danh sách khác hàng đã có ");
        System.out.println("3. Nhập danh sách dịch vụ mới  ");
        System.out.println("4. In danh sách dịch vụ đã có ");
        System.out.println("5. Nhập hóa đn cho mỗi khách hàng đã có ");
        System.out.println("6. In hóa đn cho mỗi khách hàng đã có ");
        System.out.println("7. Sắp xếp hóa đơn ");
        System.out.println("8. Lập bảng kê số tiền phải trả cho mỗi khách hàng ");
        System.out.println("9. Thoát ứng dụng ");
        System.out.println("Mời bạn  chọn những chức năng trên ");
    }
}
