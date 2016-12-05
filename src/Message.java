
import java.io.Serializable;

public class Message  implements Serializable{
  public String theMessage;
  public String[] someLines;
  public int someNumber;
  private int id;
  private String name;
  
 public Message (String name, int id){
	  this.name=name;
	  this.id=id;
	 
 }
  @Override
  public String toString() {
    String s = this.name+" \n Message: " + theMessage +"\nwith an array: \n";
    for ( int i = 0 ; i < someLines.length ; i++ ) {
      s += someLines[i] + " ";
    } 

    s += "\nand a magic #: " + someNumber;

    return s;  
  }
  
}
