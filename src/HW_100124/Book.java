package HW_100124;

import java.util.Objects;

public class Book {
    String name;
    double price;
    boolean isPresent;

    @Override
    public boolean equals(Object o){
        if (this == o) return true; //Равенство ссылок
        if (o == null || !this.getClass().equals(o.getClass())) return false; //Если переданный объект пустой или не принадлежит иеархии нашего класса то false

        Book another = (Book) o;

        return Objects.equals(this.name, another.name)
                && Objects.equals(this.price, another.price)
                && Objects.equals(this.isPresent, another.isPresent);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, price, isPresent);
    }

    public int compareTo(Book another){
        //Сначала по имени
        int nameComparison = this.name.compareTo(another.name);
        if (nameComparison != 0) return nameComparison;

        //Если имена равны то по цене
        int priceComparison = Double.compare(this.price, another.price);
        if (priceComparison != 0) return priceComparison;

        //Если и цены равны то по наличию
        return Boolean.compare(this.isPresent, another.isPresent);
    }
}
