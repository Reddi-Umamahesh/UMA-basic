//package DSA;

public class oops {

public static void main(String[] args) {
   Pen p1 = new Pen();
   p1.setcolour("blue");
   p1.colour = "red";
  // System.out.println(p1.colour);

   Bankaccount Myacc = new Bankaccount();
   Myacc.username = "umamahesh";
   Myacc.setpassword("Umamahesh@123");   

//    Student s1 = new Student();
//    Student s2 = new Student();
//   s2.marks[0] = 99;
//   s2.marks[1] = 90;
//   s2.marks[2] = 100;
//   System.out.println(s2.marks[2]);
//   Student s1 = new Student(s2);
//   System.out.println(s1.name);
//   s2.marks[1]=100;
//   for(int i=0;i<3;i++){
//     System.out.print(s1.marks[i]);
//   }
 

//   fish f1 = new fish();
//   f1.legs = 5;
//   f1.breathe();
//   System.out.println(f1.legs);


//tucker t1 = new tucker();
 //t1.linda();

  Queen q1 = new Queen();
  q1.moves();

  
}
}

class Pen{
    String colour;
    int tip_size;
    void setcolour(String newcolour){
        colour = newcolour;
    }
    void settip(int newtip){
        tip_size = newtip;
    }
}

class Bankaccount{
    public String username;
     String password; // use private String passsword
    public void setpassword(String pwd){
      this.password= pwd;
    }

}

class Student{
    public String name;
    int roll_numb;
    int marks[] ;
   Student(){
    System.out.println("constructer is called");
   }
   Student(String name){
    this.name = name;
   }
   Student(Student s2){
    this.name = s2.name;
    this.roll_numb = s2.roll_numb;
    for(int i=0;i<3;i++){
    this.marks[i] = s2.marks[i];
    }
   }
}

//inheritance
class animal{
    String colour;
    int legs;
    void eat(){
   System.out.println("eats");
    }
    void breathe(){
        System.out.println("breaths");
    }
}
class fish extends animal{
    void breathe(){
        System.out.println("with fins");
    }
}


abstract class dog{
    void colour(){
        System.out.println("brown");
    }
    dog(){
        System.out.println("dog constructor called ");
    }
}

class golden_retriver extends dog{
    void newcolour(){
        System.out.println("gold");
    }
    golden_retriver(){
        System.out.println("golden retriver constructor is called");
    }
}
class tucker extends golden_retriver{

       void linda(){
        System.out.println("mom");
       }

}

//interface
interface chessplayer{
    void moves();
}

class Queen implements chessplayer{
    public void moves(){
        System.out.println("up,down,left,right,diagonal(all directions)");
    }
}

class King implements chessplayer{
    public void moves(){
        System.out.println("up,down,left,right,diagonal(all directions one move)");
    }
}

interface herbivores{
    void food();
}
interface carnivores{
    void food();
}

class bear implements herbivores,carnivores{
    public void food(){
        System.out.println("eats grass and meat");
    }
} 
