package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.util.Pair;
import java.util.*;

public class runMain {
    static Stack<MenhDe> THOA = new Stack<>();
    static List<MenhDe> listV;
    static List<MenhDe> listRes;
    static Map<MenhDe, Pair<MenhDe, MenhDe>> map = new HashMap<>();
    static boolean flag = false;
//    public static List<MenhDe> createMD(){
//        MenhDe md1 = new MenhDe("!A v !B v P");
////        MenhDe md1 = new MenhDe("P");
//        MenhDe md2 = new MenhDe("!C v !D v P");
//        MenhDe md3 = new MenhDe("!E v C");
//        MenhDe md4 = new MenhDe("A");
//        MenhDe md5 = new MenhDe("E");
//        MenhDe md6 = new MenhDe("D");
//        List<MenhDe> list = new ArrayList<>();
//        list.add(md1);
//        list.add(md2);
//        list.add(md3);
//        list.add(md4);
//        list.add(md5);
//        list.add(md6);
//        return list;
//    }
public static List<MenhDe> readFromFile(String filename) {
    List<MenhDe> list = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = br.readLine()) != null) {
            list.add(new MenhDe(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return list;
}

    public static int findIndexMD(MenhDe u, BieuThuc v){
        for (int i = 0; i < u.getMenhDe().size(); i++) {
            if(u.getMenhDe().get(i).getBt().equals(v.getBt()) && u.getMenhDe().get(i).isPhu()!= v.isPhu() )
                return i;
        }
        return -1;
    }
    public static MenhDe delete(MenhDe u, MenhDe v){
        flag = false;
        for (int i = 0; i< v.getMenhDe().size(); i++){
            BieuThuc b = v.getMenhDe().get(i);
            int index = findIndexMD(u,b);
            if( index > -1){
                flag = true;
                u.deleteBT(index);
            }
            else {
                u.getMenhDe().add(b);
            }

        }
        return u;
    }
    public static boolean res(MenhDe u, MenhDe v) {
        Pair<MenhDe, MenhDe> p = new Pair<>(new MenhDe(u), v);
        MenhDe kq = delete(u, v);
        if (kq.getMenhDe().size() == 0) {
            map.put(new MenhDe(), p);
            listV.add(v);
            flag = true; // Đánh dấu là hệ quả của logic
            return true;
        }
        if (flag && map.get(kq) == null) {
            map.put(kq, p);
            THOA.add(kq);
            listV.add(v);
            listRes.add(kq);
        }
        return false;
    }

    public static void main(String[] args) {

        String inputFile = "D:\\Java Basic\\Test\\src\\main\\java\\org\\example\\input.txt";
        String outputFile = "D:\\Java Basic\\Test\\src\\main\\java\\org\\example\\output.txt";

        List<MenhDe> listMD = readFromFile(inputFile);

        BieuThuc MDCM = new BieuThuc("P", false);

        THOA.add(new MenhDe(new BieuThuc(MDCM.getBt(), !MDCM.isPhu())));

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(String.format("%15s%30s%40s%50s\n", "u |", "v |", "res(u,v) |", "THOA |"));
            writer.write(String.format("%15s%30s%40s%50s\n", "|", "|", "|", new BieuThuc(MDCM.getBt(), !MDCM.isPhu()) + " |"));

            while (!THOA.isEmpty()) {
                MenhDe u = THOA.pop();
                listV = new ArrayList<>();
                listRes = new ArrayList<>();
                flag = false;

                System.out.printf("%15s", u+"|");
                writer.write(String.format("%15s", u + "|"));
                for(MenhDe md : listMD){
                    if(res(new MenhDe(u), md)){
                        System.out.printf("%30s%40s%50s\n", printV()+"|",printRes()+ "|", printTHOA()+"|");
                        System.out.println("Mệnh đề "+ MDCM +" là hệ quả của logic");
                        show(u);
                        return;
                    }
                }
                System.out.printf("%30s%40s%50s\n",printV()+"|",printRes()+ "|", printTHOA()+"|");
                writer.write(String.format("%30s%40s%50s\n", printV() + "|", printRes() + "|", printTHOA() + "|"));

                if (flag) {
                    writer.write("Mệnh đề " + MDCM + " là hệ quả của logic\n");
                    show(writer, new MenhDe());
                } else {
                    writer.write("Mệnh đề " + MDCM + " không là hệ quả của logic\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void show(MenhDe u) {
        System.out.print("("+ map.get(new MenhDe()).getKey() +", " + map.get(new MenhDe()).getValue() + ")");
        u = map.get(new MenhDe()).getKey();
        while (map.get(u) != null){
            System.out.print(" <- ");
            System.out.print("("+ map.get(u).getKey() +", " + map.get(u).getValue() + ")");
            u = map.get(u).getKey();
        }
        System.out.println();
    }
    private static void show(FileWriter writer, MenhDe u) throws IOException {
        Pair<MenhDe, MenhDe> pair = map.get(u);
        if (pair != null) {
            writer.write("(" + pair.getKey() + ", " + pair.getValue() + ")");
            u = pair.getKey();
            while (map.get(u) != null) {
                writer.write(" <- ");
                pair = map.get(u);
                writer.write("(" + pair.getKey() + ", " + pair.getValue() + ")");
                u = pair.getKey();
            }
        } else {
            // Xử lý khi không có khóa tương ứng trong Map
            writer.write("Không có kết quả");
        }
        writer.write("\n");
    }

    private static String printV() {
        String s = "";
        for (MenhDe md : listV){
            s += md + ", ";
        }
        return s;
    }
    private static String printRes() {
        String s = "";
        for (MenhDe md : listRes){
            s += md + ", ";
        }
        return s;
    }
    private static String printTHOA(){
        Stack<MenhDe> stack = new Stack<>();
        int i = 0;
        String res = "";
       while (i < THOA.size()){
           i++;
           MenhDe bt = THOA.peek();
           stack.add(THOA.pop());
           res += bt + ", ";
       }
        THOA = stack;
       return res;
    }
}
