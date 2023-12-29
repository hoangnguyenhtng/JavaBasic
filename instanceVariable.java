
    public class instanceVariable {
        //Bien instace ten co kieu String, co gia tri mac dinh la null
        public String ten;
        //Bien instace tuoi kieu Integer, co gia tri mac dinh la 0
        private int tuoi;
        //Su dung bien ten trong mot constructor
        public instanceVariable(String ten){
            this.ten = ten;
        }
        //Su dung bien tuoi trong phuong thuc setTuoi
        public void setTuoi(int tuoi){
            this.tuoi = tuoi;
        }
        public void showStudent(){
            System.out.println("Ten : " + ten );
            System.out.println("Tuoi : " + tuoi);
        }

        public static void main(String args[]) {
            instanceVariable sv = new instanceVariable("Nguyen Van A");
            sv.setTuoi(21);
            sv.showStudent();
        }
    }

