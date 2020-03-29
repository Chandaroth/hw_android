package com.company;

import manager.PhoneManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        PhoneManager phoneManager=new PhoneManager();
        int choiced=0;
        while (choiced!=6){
            System.out.println("1.Add Phone");
            System.out.println("2.Show ALL Phones");
            System.out.println("3.Search Phone By ID");
            System.out.println("4.Delete PHone By Model");
            System.out.println("5.Update PHone By ID");
            System.out.println("6.Exit");
            System.out.println("\nPlease, Choose 1-6: ");
            choiced=new Scanner(System.in).nextInt();

            switch (choiced){
                case 1:
                    phoneManager.AddPhones();
                    break;
                case 2:
                    phoneManager.DisplayAllPhones();
                    break;
                case 3:
                    System.out.println("Enter Model's name to search:");
                    phoneManager.searchByPhoneModel(new Scanner(System.in).next());
                    break;
                case 4:
                    System.out.println("Enter ID to delete: ");
                    phoneManager.DeleteByID(new Scanner(System.in).nextInt());

                    break;
                case 5:
                    System.out.println("Enter ID to Update: ");
                    phoneManager.updatePhone();
                    break;
                case 6:

                    break;
            }

        }
    }
}
