package manager;

import impl.Phone;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneManager{
    ArrayList<Phone> phones=new ArrayList<Phone>();
    Scanner scanner =new Scanner(System.in);

    public void AddPhones(){
        System.out.print("Enter Number Of Phones:");
        int numberOfPhones=scanner.nextInt();
        for(int i = 0 ; i < numberOfPhones; i ++ ){
            Phone phone=new Phone();
            phone.Add();
            this.phones.add(phone);
        }
    }

    public void DisplayAllPhones(){
        int i=0;
        for(Phone phone:this.phones){
            i++;
            System.out.println("Phone: "+ i);
            phone.Show();
        }
    }

    public void DeleteByID(int id){
        this.phones.removeIf(phone -> phone.getId()==id);
    }

    public void searchByPhoneModel(String model) {
        //search = filter
        ArrayList<Phone> result =
                (ArrayList<Phone>)this.phones.stream().filter(student -> {
                    return student.getModel().equalsIgnoreCase(model);
                }).collect(Collectors.toList());
        //show result ?
        if(result.isEmpty()) {
            System.err.println("Cannot find Phone with Model's name : "+model);
        } else {
            System.out.println("We found "+result.size()+" Phones");
            for(Phone phone: result) {
                phone.Show();
            }
        }
    }
    public void updatePhone() {
        System.out.println("Enter student's id to update");
        int id = scanner.nextInt();
        ArrayList<Phone> result =
                (ArrayList<Phone>)this.phones.stream()
                        .filter(phone -> phone.getId() == id)
                        .collect(Collectors.toList());
        if(result.isEmpty()) {
            System.err.println("Cannot find student with id ="+id+" to update");
        } else {
            Phone foundPhone = result.get(0);
            foundPhone.isUpdate = true;
            foundPhone.Add();
        }
    }

}

