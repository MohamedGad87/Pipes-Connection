import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TA extends Thread{
  

 private OutputStream os2;
 private OutputStream os3;
 private InputStream is1;
 private ObjectInputStream ois;
 private ObjectOutputStream oos;
 private int id;
 private String name;
  
  public TA(String s,int id,OutputStream os2, OutputStream os3,InputStream is1, ObjectOutputStream oos, ObjectInputStream ois) {
	this.os2= os2;
    this.is1=is1;
    this.os3=os3;
    this.ois=ois;
    this.oos=oos;
    this.id=id;
    this.name=s;
  }
  
  @Override
  public void run() {
    
    try {
      
      Message m = new Message("object 1",203);
      String[] s = {this.name+" "+this.id+" from ", "TA","to", "TC"};
      m.theMessage="HI TC";
      m.someLines=s;
      m.someNumber=5;
    //sending Object to TC
      System.out.println(this.name+" "+this.id+"  sending object to TC \n "+m);
      oos = new ObjectOutputStream(os3);// sending to thread C
      oos.writeObject(m);
      // sending data to TB
      
      System.out.println(this.name+" "+this.id+"  sending to TB primitive data: 93 \n");
      os2.write(93);
 
      System.out.println(this.id+"  receiving primitive from TB "+is1.read());
 //System.out.println(is1.read());
      
      //receiving Object from TC
      ois = new ObjectInputStream(is1);
      Message me = (Message) ois.readObject();// saving object to me
      System.out.println(this.name+" "+this.id+"  recieved from TC: " + me);
      //System.out.println("TA send to TB primitive data");
      //sending  primitive to TB
   
      //closing Streaming
      os2.close();
      os3.close();
      oos.close();
      ois.close();
      is1.close();
    } catch (Exception e) {
      // TODO: handle exception
    }
    
  }
  
}
