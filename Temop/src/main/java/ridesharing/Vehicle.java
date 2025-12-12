package ridesharing;

import java.util.UUID;

public class Vehicle {
    private String id;
    private String name;
    private  String regNumber;
    private Wheeler wheeler;
    private Integer passsenger;


    public Vehicle(String name, String regNumber, Wheeler wheeler, Integer passsenger) {
        this.name = name;
        this.regNumber = regNumber;
        this.wheeler = wheeler;
        this.passsenger = passsenger;
    }

    public Vehicle(VechileBuilder vechileBuilder) {
        this.id = UUID.randomUUID().toString();
        this.name = vechileBuilder.getName();
        this.wheeler = vechileBuilder.getWheeler();
        this.passsenger = vechileBuilder.getPasssenger();
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Wheeler getWheeler() {
        return wheeler;
    }

    public void setWheeler(Wheeler wheeler) {
        this.wheeler = wheeler;
    }

    public Integer getPasssenger() {
        return passsenger;
    }

    public void setPasssenger(Integer passsenger) {
        this.passsenger = passsenger;
    }
    public static class VechileBuilder{
        private String id;
        private String name;
        private  String regNumber;
        private Wheeler wheeler;
        private Integer passsenger;

        public String getRegNumber() {
            return regNumber;
        }

        public String getName() {
            return name;
        }

        public Wheeler getWheeler() {
            return wheeler;
        }

        public Integer getPasssenger() {
            return passsenger;
        }

        public  VechileBuilder setName(String name){
            this.name = name;
            return this;
        }
        public  VechileBuilder setreg(String numb){
            this.regNumber = numb;
            return this;
        }
        public  VechileBuilder setWheeler(Wheeler wheeler){
            this.wheeler = wheeler;
            return this;
        }
        public VechileBuilder setPasssenger(int numb){
            this.passsenger = numb;
            return this;
        }
        public Vehicle build(){
            return new Vehicle(this);
        }

    }
}
