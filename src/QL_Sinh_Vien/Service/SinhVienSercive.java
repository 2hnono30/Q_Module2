package QL_Sinh_Vien.Service;
//
//import QL_Sinh_Vien.SinhVien.SinhVien;
//
//import java.io.FileOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.*;
//import java.util.function.Predicate;
//
//import static QL_Sinh_Vien.SinhVien.SinhVien.sinhViens;

//public class SinhVienSercive {
//
//
//    public void add() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhập Thông Tin Sinh Viên  :");
//        try {
//            System.out.println("Nhập SinhVienId :");
//            int SinhVienId = scanner.nextInt();
//            scanner.nextLine();
//            System.out.println("Nhập FullName :");
//            String fullName = scanner.nextLine();
//
//            System.out.println("Nhập Age :");
//            int Age = scanner.nextInt();
//            scanner.nextLine();
//            System.out.println("input GioiTinh :");
//            String GioiTinh = scanner.nextLine();
//            System.out.println("Input Address : ");
//            String Address = scanner.nextLine();
//            System.out.println("Input MediumScore : ");
//            float MediumScore = scanner.nextFloat();
//            SinhVien sinhVien = new SinhVien(SinhVienId,fullName,Age,GioiTinh,Address,MediumScore);
//            sinhViens.add(sinhVien);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void show (){
//        System.out.println("                        || Thông Tin Sinh Viên ||                    ");
//        for (int i = 0; i < sinhViens.size(); i++) {
//            System.out.println(sinhViens.get(i));
//        }
//    }
//    public void update() {
//        Scanner scanner = new Scanner(System.in);
//        try {
//            System.out.println("Nhập Sinh Viên Id : ");
//            int SinhvienId = scanner.nextInt();
//            SinhVien sinhVien = null;
//
//            for (SinhVien p : sinhViens) {
//                if (Objects.equals(p.getSinhVienId(), SinhvienId)) {
//                    sinhVien = p;
//                    break;
//                }
//            }
//
//            if (sinhVien == null) {
//                System.out.println("Id không tồn tại. Xin vui long nhập lại!");
//            }
//            System.out.println("Thông tin sinh viên :");
//            String row = String.format("%d%30s%15d%30s%30s%15s", sinhVien.getSinhVienId(), sinhVien.getFullName(), sinhVien.getAge(),
//                    sinhVien.getGioiTinh(), sinhVien.getAddress(),sinhVien.getMediumScore());
//            System.out.println(row);
//            for (int i = 0; i<sinhViens.size(); i++)
//                if (Objects.equals(SinhvienId, sinhViens.get(i).getSinhVienId())) {
//
//                    scanner.nextLine();
//
//                    System.out.println("Tên: ");
//                    String FullName = scanner.nextLine();
//
//                    System.out.println("Age : ");
//                    int Age = scanner.nextInt();
//
//                    scanner.nextLine();
//
//                    System.out.println("Giới Tính :");
//                    String GioiTinh = scanner.nextLine();
//
//                    System.out.println("Address :");
//                    String Address = scanner.nextLine();
//
//                    System.out.println(("Medium Score :"));
//                    float MediumScore = scanner.nextFloat();
//                    sinhViens.get(i).setFullName(FullName);
//                    sinhViens.get(i).setAge(Age);
//                    sinhViens.get(i).setGioiTinh(GioiTinh);
//                    sinhViens.get(i).setAddress(Address);
//                    sinhViens.get(i).setMediumScore(MediumScore);
//
//                }
//        }catch (Exception e){e.printStackTrace();}
//    }
//    public void sortByName() {
//        Collections.sort(sinhViens, new Comparator<SinhVien>() {
//            @Override
//            public int compare(SinhVien o1, SinhVien o2) {
//                return o1.getFullName().compareToIgnoreCase(o2.getFullName());
//            }
//            // Z-A (A-Z : dấu - ở trước);
//        });
//    }
//
//
//    public void delete() {
//        Scanner in = new Scanner(System.in);
//        int id = in.nextInt();
//
//        sinhViens.removeIf(new Predicate<SinhVien>() {
//            @Override
//            public boolean test(SinhVien sinhVien) {
//                return sinhVien.getSinhVienId()== id;
//            }
//        });
//    }
//    public SinhVien getById(int SinhVienId) {
//        SinhVien sinhVien = new SinhVien();
//
//        for (SinhVien p : sinhViens) {
//            if (Objects.equals(p.getSinhVienId(), SinhVienId)) {
//                sinhVien = p;
//                break;
//            }
//        }
//        return sinhVien;
//    }
//    public static ArrayList<SinhVien> writeToFile(){
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream("G:\\QuizModule2\\QuizModule2\\untitled\\src\\QL_Sinh_Vien\\Data\\SinhVien.csv");
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            for (int i = 0; i < sinhViens.size(); i++) {
//                objectOutputStream.writeObject(sinhViens);
//            }
//            objectOutputStream.close();
//            fileOutputStream.close();
//        }catch (Exception e ){e.printStackTrace();}return sinhViens;
//    }
//}
