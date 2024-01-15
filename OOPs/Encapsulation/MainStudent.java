package OOPs.Encapsulation;

public class MainStudent {
    public static void main(String[] args) {
        Student hocSinh1 = new Student();
        hocSinh1.diHoc();
        hocSinh1.sdt = 4;
        hocSinh1.setHoVaTen("Hoang");
        hocSinh1.setMsv(1);
        System.out.println(hocSinh1.sdt);
        System.out.println(hocSinh1.getHoVaTen());
        
    }
}
