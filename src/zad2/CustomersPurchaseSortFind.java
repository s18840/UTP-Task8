/**
 *
 *  @author Sroczyński Mikołaj S18840
 *
 */

package zad2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CustomersPurchaseSortFind {

    List<Purchase> list;
    String dane;
    String purchaseID;
    double number;

    public CustomersPurchaseSortFind() {
        list = new LinkedList<>();
    }

    public CustomersPurchaseSortFind(List<Purchase> list, String dane, String purchaseID, double number) {
        this.list = list;
        this.dane = dane;
        this.purchaseID = purchaseID;
        this.number = number;
    }

    public CustomersPurchaseSortFind(List<Purchase> list, String dane) {
        this.list = list;
        this.dane = dane;
    }

    public List<Purchase> getList() {
        return list;
    }

    public void setList(List<Purchase> list) {
        this.list = list;
    }

    public String getDane() {
        return dane;
    }

    public void setDane(String dane) {
        this.dane = dane;
    }

    public String getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(String purchaseID) {
        this.purchaseID = purchaseID;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }



    public void showSortedBy(String s) {
        if(s.equals("Nazwiska")){
            Collections.sort(list, Comparator.comparing(Purchase::getNazwisko));
            System.out.println("Nazwiska");
            for(Purchase p : list){
                System.out.print(p.toString());
                number++;
            }
            System.out.println();
        }else if(s.equals("Koszty")) {
            Collections.sort(list, (col1, col2) -> (int) (col2.getIlosc() * col2.getCena() - col1.getIlosc() * col1.getCena()));
            System.out.println("Koszty");
            for (Purchase p : list) {
                System.out.print(p.toString());
                number++;
            }
            System.out.println();
        }
    }
    public void showPurchaseFor(String id) {
        System.out.println("Klient " + id);
        //System.out.println(dane+purchaseID);
        list.stream().filter(o -> o.getiDTranakcji().equals(id)).forEach(System.out::print);
        System.out.println();
    }

    public void readFile(String s) {
        Scanner scanner;
        scanner= null;
        try {
            scanner = new Scanner(new File(s));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        while(scanner.hasNext()){
            String [] tmp;
            tmp= scanner.nextLine().split(";");
            list.add(new Purchase(tmp[0], tmp[1], tmp[2], Double.parseDouble(tmp[3]), Double.parseDouble(tmp[4])));
        }
    }
}
