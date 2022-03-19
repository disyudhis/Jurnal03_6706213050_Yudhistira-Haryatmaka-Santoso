package com.example;

import java.util.Scanner;


public class main {

    public static void main(String[] args) {
        SinglyLinkedList<pegawai> linkedList = new SinglyLinkedList<>("Pegawai");
        linkedList.insertAtFront(new pegawai("123", "Yana", "HRD"));
        linkedList.insertAtFront(new pegawai("345", "Eki", "IT"));

        Scanner scan = new Scanner(System.in);
        boolean kondisi = true;
        while (kondisi){
            menu();
            int input = scan.nextInt();
            switch (input) {
                case 1:
                    String nip = scan.next();
                    String nama = scan.next();
                    String divisi = scan.next();
                    System.out.println("Tambahkan data diawal list? (y/n)");
                    if (scan.next().equals("y")) {
                        linkedList.insertAtFront(new pegawai(nip, nama, divisi));
                    } else {
                        linkedList.insertAtBack(new pegawai(nip, nama, divisi));
                    }
                    break;
                case 2:
                    System.out.println("Hapus data diawal list? (y/n)");
                    if (scan.next().equals("y")) {
                        linkedList.removeFromBack();
                    } else {
                        linkedList.removeFromFront();
                    }
                    break;
                case 3:
                    linkedList.print();
                    break;
                default:
                    kondisi = false;
                    break;
            }
        }
    }

    public static void menu(){
        System.out.println("Pilihlah menu:");
        System.out.println("1. Input data");
        System.out.println("2. Hapus data");
        System.out.println("3. Cetak list pegawai");
        System.out.println("4. Keluar");
    }
}
