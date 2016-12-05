import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TC extends Thread{
  
  private InputStream is1;
  private OutputStream os1;
  
  private OutputStream os2;
  
  private InputStream is3;
  
  private ObjectInputStream ois;
  private ObjectOutputStream oos;
  private int id;
  private String name;
  
  
  public TC(String s,int id,OutputStream os1, OutputStream os2, InputStream is3,ObjectOutputStream oos, ObjectInputStream ois) {

    this.is1=is1;
    this.os1=os1;
    this.os2=os2;
    this.is3=is3;
    this.oos=oos;
    this.ois=ois;
    this.id=id;
    this.name=s;
  }
  
  @Override
  public void run() {
    try {
    	//sleep(1000);
      Message m = new Message("object 2",203);
      String[] s = {" from", "TC","to","TA"};
      m.theMessage="HI TA";
      m.someLines=s;
      m.someNumber=15;
      
      
      oos = new ObjectOutputStream(os1);
      //sending to TA message object
      System.out.println(this.name+" "+this.id+" sending object to TA "+m);
      oos.writeObject(m);
      //sending primitive to TB
      System.out.println(this.name+" "+this.id+" sending primitive data to TB: 20");
      os2.write(20);
      //receiving Object from TA
      ois = new ObjectInputStream(is3);
      Message m1 = (Message) ois.readObject();// storing the object into m1
      System.out.println(this.name+" "+this.id+"  Recieving Object from TA:\n "+m1);

     os1.close();
     os2.close();
     oos.close();
     ois.close();
     is3.close();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
