package Demo_set_Array;

import java.util.ArrayList;
public class HashSet {
    public static void main(String[] argv) throws Exception
    {
        try {

            // Tạo đối tượng ArrayList <Integer>
            ArrayList<Integer>
                    arrlist = new ArrayList<Integer>();

            // Populating arrlist1
            arrlist.add(1);
            arrlist.add(2);
            arrlist.add(3);
            arrlist.add(4);
            arrlist.add(5);

            // print arrlist
            System.out.println("Before operation: "
                    + arrlist);

            // Thay thế phần tử ở chỉ số 3 bằng 30
            // sử dụng phương thức set ()
            int i = arrlist.set(3, 30);

            // In danh sách arrlist đã sửa đổi
            System.out.println("After operation: "
                    + arrlist);

            // In phần tử đã thay thế
            System.out.println("Replaced element: "
                    + i);
        }

        catch (IndexOutOfBoundsException e) {
            System.out.println("Exception thrown: "
                    + e);
        }
    }
}
