package OOPs.Encapsulation;

public class Student {
    private int msv;
    private String hoVaTen;
    public int sdt;

    public String getHoVaTen() {
        return hoVaTen;
    }
    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }
    public int getMsv() {
        return msv;
    }
    public void setMsv(int msv) {
        this.msv = msv;
    }

    public void diHoc(){
        System.out.println("Hom nay di hoc");
    }
}
