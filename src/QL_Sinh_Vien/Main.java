package QL_Sinh_Vien;

//import QL_Sinh_Vien.Service.SinhVienSercive;
//import QL_Sinh_Vien.SinhVien.SinhVien;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//    public static void menu() {
//        System.out.println("------------------Danh sách chức năng----------------------------");
//        System.out.println("1. Thêm mới");
//        System.out.println("2. Hiển thị");
//        System.out.println("3. Sửa ");
//        System.out.println("4. Xóa");
//        System.out.println("5. Sắp Xếp");
//        System.out.println("6. Đọc từ file");
//        System.out.println("7. Ghi vào file");
//        System.out.println("8. Thoát.");
//    }
//
//    public static void main(String[] args) {
//        int function = 0;
//
//        do {
//            menu();
//            Scanner inputs = new Scanner(System.in);
//            try {
//                System.out.print("Chọn chức năng: ");
//                function = inputs.nextInt();
//                SinhVienSercive sinhVienSercive = new SinhVienSercive();
//                switch (function) {
//                    case 1:
//                        sinhVienSercive.add();
//                        break;
//                    case 2:
//                        sinhVienSercive.show();
//                        break;
//                    case 3:
//                        sinhVienSercive.update();
//                        break;
//                    case 4:
//                        sinhVienSercive.delete();
//                        break;
//                    case 5:
//                        sinhVienSercive.sortByName();
//                        break;
//                    case 6:
//
//                        break;
//                    case 7:
//                        SinhVienSercive.writeToFile();
//                        break;
//
//                    default:
//                        break;
//                }
//
//            } catch (Exception e) {
//              e.printStackTrace();
//            }
//
//        } while (function != 8);
//    }
//
//
//}
