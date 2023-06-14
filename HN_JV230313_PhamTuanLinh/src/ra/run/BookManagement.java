package ra.run;

import ra.busseiness.Book;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

public class BookManagement {
    private static final int BookList = 100;
    private static Book[] books = new Book[BookList];
    private static int BookCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách ");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả ");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addBooks(scanner);
                    break;
                case 2:
                    displayAllBook();
                    break;
                case 3:
                    sortBooksByprofit();
                    break;
                case 4:
                    deleteBookById(scanner);
                    break;
                case 5:
                    searchBook(scanner);
                    break;
                case 6:
                    updateBookById(scanner);
                    break;
                case 7:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không đúng. Hãy chọn lại");
                    break;
            }
        } while (choice != 7);
    }

    private static void addBooks(Scanner scanner) {
        System.out.println("nhập só lượng cần thêm");
        int count = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin cho cuốn sách thứ:" + (i + 1));
            Book book = new Book();
            book.inputData();
            books[BookCount++] = book;
            System.out.println("Đã thêm thành công");
        }
    }

    private static void displayAllBook() {
        if (BookCount == 0) {
            System.out.println("Không có sách nào trong thư viện");
        } else {
            for (int i = 0; i < BookCount; i++) {
                System.out.println("Thông tin sách thứ" + (i + 1));
                books[i].displayData();
                System.out.println();
            }
        }
    }

    private static void sortBooksByprofit() {
        if (BookCount == 0) {
            System.out.println("Không có sách nào trong thư viện");
        } else {
            Arrays.sort(books, 0, BookCount, Comparator.comparingDouble(Book::getInterest));
            System.out.println("Đã sắp xếp theo lợi nhuận tăng");
            for (int i = 0; i < BookCount; i++) {
                System.out.println("Lợi nhuận của sách thứ" + (i + 1) + ":" + books[i].getInterest());
            }
        }
    }

    private static void deleteBookById(Scanner scanner) {
        System.out.println("Nhập Id sách cần xóa:");
        int BookId = scanner.nextInt();
        scanner.nextLine();
        int index = findBookIndexById(BookId);
        if (index == -1) {
            System.out.println("Không tìm thấy mã sách:" + BookId);
        } else {
            for (int i = index; i < BookCount; i++) {
                books[i] = books[i + 1];
            }
            BookCount--;
            System.out.println("Xóa thành công");
        }

    }
    private static void searchBook(Scanner scanner){
        System.out.println("Nhập sách cần tìm:");
        String keyword = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < BookCount; i++) {
            Book book = books[i];
            if (book.getBookname().contains(keyword) || book.getDescriptions().contains(keyword)){
                if(!found){
                    found=true;
                }
                book.displayData();
                System.out.println();
            }
        }
        if (!found){
            System.out.println("Không tìm thấy sách");
        }
    }
    private static void updateBookById(Scanner scanner){
        System.out.println("Nhập id sách cần thay đổi:");
        int BookId =scanner.nextInt();
        int index = findBookIndexById(BookId);
        if (index == -1 ){
            System.out.println("Không tìm thấy sách");
        }else {
            Book book =books[index];
            System.out.println("Nhập thông tin mới" + BookId);
            book.inputData();
            System.out.println("Đã thay đổi thông tin");
        }
    }

    private static int findBookIndexById(int BookId) {
        for (int i = 0; i < BookCount; i++) {
            if (books[i].getBookId() == BookId) {
                return i;
            }
        }
        return -1;
    }


}
