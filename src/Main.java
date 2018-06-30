import java.io.IOException;
import java.util.Scanner;

import cameraControl.CameraController;
import cameraControl.tcpActions.TCPController;

import cameraControl.jsonActions.JSONActionController;
import ui.MainMenu;

/**
 *
 */

/**
 * @author mathieu
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {

        String addr = "192.168.42.1"
        Integer json_port = 7878
        Integer tcp_port = 8787
        // String addr = "10.15.12.1";
        // Integer json_port = 111;
        // Integer tcp_port = 111;


        JSONActionController JSONcontroller = new JSONActionController(addr, json_port);
        TCPController TCPcontroller = new TCPController(addr, tcp_port);

        CameraController cameraController = new CameraController(JSONcontroller, TCPcontroller);
        cameraController.initialise();

        MainMenu menu = new MainMenu(cameraController, new Scanner(System.in));

        menu.executeView();
        cameraController.clearRessources();
    }

}
