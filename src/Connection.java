import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Connection{
  
  static private PipedInputStream pis1_TA;
  static private PipedOutputStream pos1_TA;
  
  static private PipedInputStream pis2_TB;
  static private PipedOutputStream pos2_TB;
  
  static private PipedInputStream pis3_TC;
  static private PipedOutputStream pos3_TC;
  
  static private PipedInputStream pis4_TBC;
  static private PipedOutputStream pos4_TBC;
  
//  static private PipedInputStream pis5_TBA;
//  static private PipedOutputStream pos5_TBA;
  
  static private ObjectOutputStream oos;
  static private ObjectInputStream ois;
  
  public static void main(String[] args) {
    try {
      pos1_TA = new PipedOutputStream();  
      pis1_TA = new PipedInputStream(pos1_TA);
      
      pos2_TB = new PipedOutputStream();    
      pis2_TB = new PipedInputStream(pos2_TB);
      
      pos3_TC = new PipedOutputStream();     
      pis3_TC = new PipedInputStream(pos3_TC);
      
      pos4_TBC= new PipedOutputStream();
      pis4_TBC = new PipedInputStream(pos4_TBC);
//      
//      pos5_TBA= new PipedOutputStream();
//      pis5_TBA = new PipedInputStream(pos5_TBA);
      
      TA ta = new TA("TA",101,pos2_TB,pos3_TC,pis1_TA,oos,ois); 
      TB tb = new TB("TB",202,pos1_TA,pis2_TB,pis4_TBC);
      TC tc = new TC("TC",303,pos1_TA, pos4_TBC, pis3_TC , oos, ois);
      
      
      ta.start();
      tb.start();
      tc.start();
      
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
 
}
