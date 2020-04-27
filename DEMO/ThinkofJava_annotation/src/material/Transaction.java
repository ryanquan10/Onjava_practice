package material;



import java.util.Arrays;
import java.util.List;

public class Transaction{
    public Transaction() {
    }

    Trader trade;
    Integer year;
    Double turnover;

    public Transaction(Trader trade, Integer year, Double turnover) {
        this.trade = trade;
        this.year = year;
        this.turnover = turnover;
    }

    public Trader getTrade() {
        return trade;
    }

    public void setTrade(Trader trade) {
        this.trade = trade;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }


    public void tset26(){
        List<String> list = Arrays.asList("I", "love", "you", "too");
        list.stream().sorted((e1,e2)->{return e1.compareTo(e2);}).forEach(System.out::println);
    }
}