import gnu.io.*;
import java.io.*;
import java.util.*;

/**
 * Created by Brandon on 2016-12-28.
 */
public class SerialCommunicator {
    static Enumeration<CommPortIdentifier> portList;
    static CommPortIdentifier portID;
    static SerialPort serialPort;
    static OutputStream output;

    public static void setUp() {
        portList = CommPortIdentifier.getPortIdentifiers();
        while(portList.hasMoreElements()) {
            portID = portList.nextElement();
            if(portID.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                if(portID.getName().equals("COM3")) {
                    try {
                        serialPort = (SerialPort) portID.open("SIMPLE COMMUNICATOR PORT", 2000);
                        Thread.sleep(4000);
                        output = serialPort.getOutputStream();
                        serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
                    }
                    catch(PortInUseException e) { System.out.println("eer1"); }
                    catch(InterruptedException e) { System.out.println("eer2"); }
                    catch(IOException e) { System.out.println("eer3"); }
                    catch(UnsupportedCommOperationException e) { System.out.println("eer4"); }
                }
            }
        }
    }
}
