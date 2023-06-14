package ra.busseiness;

import java.util.Scanner;

public class Book {
    private int BookId;
    private String bookname;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book(int bookId, String bookname, String author, String descriptions, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        BookId = bookId;
        this.bookname = bookname;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public Book() {

    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sách:");
        bookname = scanner.nextLine();
        System.out.println("Nhập tác giả:");
        author = scanner.nextLine();
        System.out.println("Nhập mô tả sách ít nhất có 10 ký tự:");
        descriptions = scanner.nextLine();
        while (descriptions.length() < 10){
            System.out.println("Mô tả sách ít nhất có 10 ký tự. Hãy nhập lại");
            descriptions = scanner.nextLine();
        }
        System.out.println("Nhập giá của sách:");
        importPrice = scanner.nextDouble();
        while (importPrice <=0){
            System.out.println("Giá phải lớn hơn 0. Hãy nhập lại");
            importPrice = scanner.nextDouble();
        }
        System.out.println("Nhập giá xuất  (phải lớn hơn 1.2 lần giá nhập)");
        exportPrice = scanner.nextDouble();
        while (exportPrice <= 1.2*importPrice){
            System.out.println("Gía xuất phải lớn hơn 1.2 lần giá nhập. Hãy nhập lại");
            exportPrice = scanner.nextDouble();
        }
        interest = (float) (exportPrice - importPrice);
    }
    public void displayData(){
        System.out.println("mã sách: "+ BookId);
        System.out.println("tên sách: "+ bookname);
        System.out.println("tác giả: " +author);
        System.out.println(" mô tả về sách: "+ descriptions);
        System.out.println("giá nhập: "+ importPrice);
        System.out.println("giá xuất: "+ exportPrice);
        System.out.println("lợi nhuận:"+ interest);
        System.out.println("trạng thái: "+bookStatus);
    }
}
