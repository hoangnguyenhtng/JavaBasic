package OOPs.QuanLyDongVat;

public class cat extends animal{
    @Override
    public void keu() {
        System.out.println("meo meo");;
    }
    @Override
    public String getLoai() {
        return "meo";
    }
    
}
