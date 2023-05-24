package ru.gb.java;

import java.util.*;

public class HWLaptop {

    String manufacturer;
    String modelNumber;
    String color;
    double displaySize;
    double capacityRam;
    double capacityRom;
    String processorModel;
    double price;
    String operationSystem;
    String typeVideocard;

    public static void main(String[] args) {
        HWLaptop asusFX506 = new HWLaptop("Asus", "FX506HCB-US51", "silver", 15.0, 8, 512,
                "Intel 11400H", 72999.00, "Win10", "Discred");
        HWLaptop msiGF76 = new HWLaptop("MSI", "GF76", "dark", 17.3, 16, 512,
                "Ryzen 5 3600", 75000.00, "Win11", "Discred");
        HWLaptop msiZ17 = new HWLaptop("MSI", "Z17", "silver", 17.0, 32, 2000,
                "Ryzen 5 3600", 269999.00, "Win11", "Discred");
        HWLaptop msiP7 = new HWLaptop("MSI", "p7", "silver", 15.6, 32, 2000,
                "Ryzen 5 5600", 267999.00, "Win11", "Discred");

        Set<Object> laptopSet = new HashSet<Object>();

        laptopSet.add(asusFX506);
        laptopSet.add(msiGF76);
        laptopSet.add(msiZ17);
        laptopSet.add(msiP7);

        menu(laptopSet);
    }

    HWLaptop(String m, String model, String col, double size, int rom, int ram,
             String processor, double pr, String os, String videocard) {
        manufacturer = m;
        modelNumber = model;
        color = col;
        displaySize = size;
        capacityRom = rom;
        capacityRam = ram;
        processorModel = processor;
        price = pr;
        operationSystem = os;
        typeVideocard = videocard;
    }

    public static void menu(Set<Object> laptopSet) {

        while (true) {
            try {
                System.out.println(
                        "Меню \n 1. Показать весь ассортимент ноутбуков \n 2. Поиск по критериям \n 3. Выход ");
                Scanner scan = new Scanner(System.in);
                int userNum = scan.nextInt();
                if (userNum == 1) {
                    printAll(laptopSet);
                } else if (userNum == 2) {
                    filterSet(laptopSet);
                } else if (userNum == 3) {
                    System.out.println(" \n Выход... \n");
                    System.exit(0);

                } else {
                    System.out.println("\n Ошибка выбора пункта меню. Повторите ввод. \n");
                }

            } catch (Exception e) {
                System.out.println("\n Ошибка ввода. Повторите ввод. \n");
            }
        }

    }

    public static void printAll(Set<Object> laptopSet) {
        for (Object element : laptopSet) {
            HWLaptop laptop = (HWLaptop) element;
            System.out.println("Производитель: " + laptop.manufacturer);
            System.out.println("Модель: " + laptop.modelNumber);
            System.out.println("Цвет: " + laptop.color);
            System.out.println("Размер экрана: " + laptop.displaySize + " дюймов");
            System.out.println("Объем жесткого диска: " + laptop.capacityRom + " GB");
            System.out.println("Объем оперативной памяти: " + laptop.capacityRam + " GB");
            System.out.println("Модель процессора: " + laptop.processorModel);
            System.out.println("Цена: " + laptop.price + " рублей");
            System.out.println("Операционная система: " + laptop.operationSystem);
            System.out.println("Тип видеокарты: " + laptop.typeVideocard);
            System.out.println("------------------------");
        }
    }

    public static <K, V> void filterSet(Set<Object> laptopSet) {

        Scanner scan = new Scanner(System.in);
        System.out.println("\n Выбрать критерий для фильтрации: \n 1. Размер дисплея \n 2. Объём оперативной памяти " +
                "\n 3. Объём жесткого диска \n 4. Цена \n 5. Несколько условий");
        int userNumFilter = scan.nextInt();
        if (userNumFilter == 1) {
            System.out.print("Введите значение: ");
            double size = scan.nextDouble();
            for (Object s : laptopSet
            ) {
                HWLaptop laptop = (HWLaptop) s;
                checkFilter(laptop.displaySize, size, laptop);
            }
        } else if (userNumFilter == 2) {
            System.out.print("Введите значение: ");
            double size = scan.nextDouble();
            for (Object s : laptopSet
            ) {
                HWLaptop laptop = (HWLaptop) s;
                checkFilter(laptop.capacityRom, size, laptop);
            }
        } else if (userNumFilter == 3) {
            System.out.print("Введите значение: ");
            double size = scan.nextDouble();
            for (Object s : laptopSet
            ) {
                HWLaptop laptop = (HWLaptop) s;
                checkFilter(laptop.capacityRam, size, laptop);
            }
        } else if (userNumFilter == 4) {
            System.out.print("Введите значение: ");
            double size = scan.nextDouble();
            for (Object s : laptopSet
            ) {
                HWLaptop laptop = (HWLaptop) s;
                checkFilter(laptop.price, size, laptop);
            }
        } else if (userNumFilter == 5) {
            Map<Integer, Double> filtredMap = checkList(laptopSet);
            processFilter(laptopSet, filtredMap);
        }
    }

    public static void processFilter(Set<Object> laptopSet, Map<Integer, Double> filter) {
        for (Object s : laptopSet) {
            HWLaptop laptop = (HWLaptop) s;
            boolean flag = true;

            for (int i = 1; i <= 4; i++) {
                if (filter.get(i) == null || filter.get(i) == 0) {
                    continue;
                }
                if (i == 1) {
                    double size = filter.get(i);
                    if (laptop.displaySize < size) {
                        flag = false;
                        break;
                    }
                }
                if (i == 2) {
                    double size = filter.get(i);
                    if (laptop.capacityRam < size) {
                        flag = false;
                        break;
                    }
                }
                if (i == 3) {
                    double size = filter.get(i);
                    if (laptop.capacityRom < size) {
                        flag = false;
                        break;
                    }
                }
                if (i == 4) {
                    double size = filter.get(i);
                    if (laptop.price < size) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                System.out.println("------------------------");
                System.out.println("Производитель: " + laptop.manufacturer);
                System.out.println("Модель: " + laptop.modelNumber);
                System.out.println("Размер дисплея: " + laptop.displaySize);
                System.out.println("Объем ОЗУ: " + laptop.capacityRom);
                System.out.println("Объем HDD/SDD: " + laptop.capacityRam);
                System.out.println("Цена: " + laptop.price + " руб.");
                System.out.println("------------------------");
            }
        }
    }

    public static void checkFilter(double attr, double userVal, HWLaptop laptop) {
        if (attr >= userVal) {
            System.out.print("Производитель: " + laptop.manufacturer);
            System.out.print(" Модель: " + laptop.modelNumber);
            System.out.println(" Цена: " + laptop.price + " рублей");
            System.out.println("------------------------");
        }
    }

    public static Map<Integer, Double> checkList(Set<Object> laptopSet) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, Double> mapFilter = new HashMap<>();
        for (int i = 1; i < 5; i++) {
            if (i == 1) {
                System.out.print("введите размер дисплея: ");
                double size = scan.nextDouble();
                if (size != 0) {
                    mapFilter.put(i, size);
                }
            }
            if (i == 2) {
                System.out.print("введите объём ОЗУ: ");
                double size = scan.nextDouble();
                if (size != 0) {
                    mapFilter.put(i, size);
                }
            }
            if (i == 3) {
                System.out.print("введите объём диска (ПЗУ): ");
                double size = scan.nextDouble();
                if (size != 0) {
                    mapFilter.put(i, size);
                }
            }
            if (i == 4) {
                System.out.print("введите цену: ");
                double size = scan.nextDouble();
                if (size != 0) {
                    mapFilter.put(i, size);
                }
            }
        }
        return mapFilter;
    }

}