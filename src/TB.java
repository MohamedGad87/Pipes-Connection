import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TB extends Thread{
  
  private InputStream is1;
  private OutputStream os1;
  private InputStream is2;
  private InputStream is3;
  private InputStream os3;
  private int id;
  private String name;
  
  public TB(String s,int id,OutputStream os1, InputStream is2,InputStream is3 ) {
    this.is1=is1;
    this.os1=os1;
    this.is2=is2;
    this.is3=is3;
    this.id=id;
    this.name=s;
  
  }
  
  @Override
  public void run() {

    try {
      //sending primitive to TA
    	//System.out.println("TB receiving from TA : " + is2.read());
      System.out.println(this.name+" "+this.id+" TB sending to TA primitive data: 77 ");
      os1.write(77);
      //receiving primitive from TA
    System.out.println(this.name+" "+this.id+" TB receiving from TA : " + is2.read());
     //receiving primitive from TC
     System.out.println(this.name+" "+this.id+" TB receiving from TC : "+ is3.read());
     
  
     os1.close();
     is2.close();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  
}
