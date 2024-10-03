package kr.co.sist.vo;

public class CarVO {
    //  제조국, 제조사, 모델명, 연식, 가격, 옵션
    // car_country.maker = car_maker.maker
    // car_maker.model = car_model.model
    // country, maker, model, car_year, price, car_option

    private String country, maker, model, car_year, car_option;
    private int price;

    public CarVO() {
    }

    public CarVO(String country, String maker, String model, String car_year,int price, String car_option) {
        this.country = country;
        this.maker = maker;
        this.model = model;
        this.car_year = car_year;
        this.price = price;
        this.car_option = car_option;
    }

    public String getCountry() {
        return country;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public String getCar_year() {
        return car_year;
    }

    public String getCar_option() {
        return car_option;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "CarVO{" +
                "country='" + country + '\'' +
                ", maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", car_year='" + car_year + '\'' +
                ", car_option='" + car_option + '\'' +
                ", price=" + price +
                '}';
    }
}
