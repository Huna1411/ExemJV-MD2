package ra.run;

import ra.entiny.LaptopType;
import ra.entiny.Laptop;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<LaptopType> laptopTypes = new ArrayList<>();
    private static ArrayList<Laptop> laptops = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("********** LAPTOP-MANAGEMENT **********");
            System.out.println("1. Quản lý loại laptop");
            System.out.println("2. Quản lý laptop");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageLaptopType();
                    break;
                case 2:
                    manageLaptop();
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void manageLaptopType() {
        while (true) {
            System.out.println("********** LAPTOP_TYPE-MENU **********");
            System.out.println("1. Hiển thị danh sách các loại laptop");
            System.out.println("2. Thêm mới loại laptop");
            System.out.println("3. Cập nhật thông tin loại laptop");
            System.out.println("4. Xóa loại Laptop");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayLaptopTypes();
                    break;
                case 2:
                    addLaptopType();
                    break;
                case 3:
                    updateLaptopType();
                    break;
                case 4:
                    deleteLaptopType();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void displayLaptopTypes() {
        System.out.println("Danh sách các loại laptop:");
        for (LaptopType type : laptopTypes) {
            if (!type.isDeleted()) {
                System.out.println("ID: " + type.getTypeId() + ", Tên: " + type.getTypeName() + ", Mô tả: " + type.getDescription());
            }
        }
    }

    private static void addLaptopType() {
        System.out.print("Nhập tên loại laptop: ");
        String typeName = scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();

        for (LaptopType type : laptopTypes) {
            if (type.getTypeName().equalsIgnoreCase(typeName)) {
                System.out.println("Tên loại laptop đã tồn tại.");
                return;
            }
        }

        LaptopType newType = new LaptopType(typeName, description);
        laptopTypes.add(newType);
        System.out.println("Thêm mới loại laptop thành công.");
    }

    private static void updateLaptopType() {
        System.out.print("Nhập ID loại laptop cần cập nhật: ");
        int typeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (LaptopType type : laptopTypes) {
            if (type.getTypeId() == typeId && !type.isDeleted()) {
                System.out.println("1. Cập nhật tên loại laptop");
                System.out.println("2. Cập nhật mô tả");
                System.out.print("Lựa chọn của bạn: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên mới: ");
                        String newName = scanner.nextLine();
                        type.setTypeName(newName);
                        System.out.println("Cập nhật tên thành công.");
                        break;
                    case 2:
                        System.out.print("Nhập mô tả mới: ");
                        String newDescription = scanner.nextLine();
                        type.setDescription(newDescription);
                        System.out.println("Cập nhật mô tả thành công.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy loại laptop với ID đã nhập.");
    }

    private static void deleteLaptopType() {
        System.out.print("Nhập ID loại laptop cần xóa: ");
        int typeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (LaptopType type : laptopTypes) {
            if (type.getTypeId() == typeId && !type.isDeleted()) {
                type.setDeleted(true);
                System.out.println("Xóa loại laptop thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy loại laptop với ID đã nhập.");
    }

    private static void manageLaptop() {
        while (true) {
            System.out.println("********** LAPTOP-MENU **********");
            System.out.println("1. Danh sách Laptop");
            System.out.println("2. Thêm mới Laptop");
            System.out.println("3. Cập nhật thông tin Laptop");
            System.out.println("4. Xóa Laptop");
            System.out.println("5. Thống kê số lượng laptop theo từng loại");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayLaptops();
                    break;
                case 2:
                    addLaptop();
                    break;
                case 3:
                    updateLaptop();
                    break;
                case 4:
                    deleteLaptop();
                    break;
                case 5:
                    statisticsByType();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void displayLaptops() {
        System.out.println("Danh sách các laptop:");
        for (Laptop laptop : laptops) {
            if (!laptop.isDeleted()) {
                System.out.println("ID: " + laptop.getLaptopId() + ", Tên: " + laptop.getLaptopName() + ", Mô tả: " + laptop.getDescription() + ", Địa chỉ: " + laptop.getCustomerAddress() + ", RAM: " + laptop.getRam() + "GB, Cân nặng: " + laptop.getWeight() + "kg, Giá: " + laptop.getLaptopPrice() + "$, Loại ID: " + laptop.getTypeId());
            }
        }
    }

    private static void addLaptop() {
        System.out.print("Nhập mã laptop (L****): ");
        String laptopId = scanner.nextLine();
        System.out.print("Nhập tên laptop: ");
        String laptopName = scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String customerAddress = scanner.nextLine();
        System.out.print("Nhập RAM (GB): ");
        int ram = scanner.nextInt();
        System.out.print("Nhập cân nặng (kg): ");
        double weight = scanner.nextDouble();
        System.out.print("Nhập giá ($): ");
        double laptopPrice = scanner.nextDouble();
        System.out.print("Nhập mã loại laptop: ");
        int typeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Laptop laptop : laptops) {
            if (laptop.getLaptopId().equalsIgnoreCase(laptopId)) {
                System.out.println("Mã laptop đã tồn tại.");
                return;
            }
        }

        Laptop newLaptop = new Laptop(laptopId, laptopName, description, customerAddress, ram, weight, laptopPrice, typeId);
        laptops.add(newLaptop);
        System.out.println("Thêm mới laptop thành công.");
        displayLaptop(newLaptop);
    }

    private static void displayLaptop(Laptop laptop) {
        System.out.println("ID: " + laptop.getLaptopId() + ", Tên: " + laptop.getLaptopName() + ", Mô tả: " + laptop.getDescription() + ", Địa chỉ: " + laptop.getCustomerAddress() + ", RAM: " + laptop.getRam() + "GB, Cân nặng: " + laptop.getWeight() + "kg, Giá: " + laptop.getLaptopPrice() + "$, Loại ID: " + laptop.getTypeId());
    }

    private static void updateLaptop() {
        System.out.print("Nhập mã laptop cần cập nhật: ");
        String laptopId = scanner.nextLine();

        for (Laptop laptop : laptops) {
            if (laptop.getLaptopId().equalsIgnoreCase(laptopId) && !laptop.isDeleted()) {
                System.out.println("1. Cập nhật tên laptop");
                System.out.println("2. Cập nhật mô tả");
                System.out.println("3. Cập nhật địa chỉ khách hàng");
                System.out.println("4. Cập nhật RAM");
                System.out.println("5. Cập nhật cân nặng");
                System.out.println("6. Cập nhật giá");
                System.out.println("7. Cập nhật mã loại laptop");
                System.out.print("Lựa chọn của bạn: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên mới: ");
                        String newName = scanner.nextLine();
                        laptop.setLaptopName(newName);
                        System.out.println("Cập nhật tên thành công.");
                        break;
                    case 2:
                        System.out.print("Nhập mô tả mới: ");
                        String newDescription = scanner.nextLine();
                        laptop.setDescription(newDescription);
                        System.out.println("Cập nhật mô tả thành công.");
                        break;
                    case 3:
                        System.out.print("Nhập địa chỉ mới: ");
                        String newAddress = scanner.nextLine();
                        laptop.setCustomerAddress(newAddress);
                        System.out.println("Cập nhật địa chỉ thành công.");
                        break;
                    case 4:
                        System.out.print("Nhập RAM mới: ");
                        int newRam = scanner.nextInt();
                        laptop.setRam(newRam);
                        System.out.println("Cập nhật RAM thành công.");
                        break;
                    case 5:
                        System.out.print("Nhập cân nặng mới: ");
                        double newWeight = scanner.nextDouble();
                        laptop.setWeight(newWeight);
                        System.out.println("Cập nhật cân nặng thành công.");
                        break;
                    case 6:
                        System.out.print("Nhập giá mới: ");
                        double newPrice = scanner.nextDouble();
                        laptop.setLaptopPrice(newPrice);
                        System.out.println("Cập nhật giá thành công.");
                        break;
                    case 7:
                        System.out.print("Nhập mã loại laptop mới: ");
                        int newTypeId = scanner.nextInt();
                        laptop.setTypeId(newTypeId);
                        System.out.println("Cập nhật mã loại laptop thành công.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy laptop với mã đã nhập.");
    }

    private static void deleteLaptop() {
        System.out.print("Nhập mã laptop cần xóa: ");
        String laptopId = scanner.nextLine();

        for (Laptop laptop : laptops) {
            if (laptop.getLaptopId().equalsIgnoreCase(laptopId) && !laptop.isDeleted()) {
                laptop.setDeleted(true);
                System.out.println("Xóa laptop thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy laptop với mã đã nhập.");
    }

    private static void statisticsByType() {
        System.out.println("Thống kê số lượng laptop theo từng loại:");
        for (LaptopType type : laptopTypes) {
            if (!type.isDeleted()) {
                long count = laptops.stream().filter(l -> l.getTypeId() == type.getTypeId() && !l.isDeleted()).count();
                System.out.println("Tên loại laptop: " + type.getTypeName() + ", Số lượng: " + count);
            }
        }
    }
}







