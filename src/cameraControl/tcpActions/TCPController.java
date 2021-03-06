package cameraControl.tcpActions;

import java.io.IOException;

import cameraControl.client.RawDataClient;

// import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
// import java.text.ParseException;

public class TCPController {
	public TCPController(String addr,int port) throws IOException {
		mRawDataClient = new RawDataClient(addr, port);

	}

	public void executeAction(AbstractRawTCPAction a)
	{
		try {
			a.execute(mRawDataClient);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initialize() throws IOException
	{
		mRawDataClient.connect();
	}

	public void clearRessources()
	{
		try {
			mRawDataClient.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private RawDataClient mRawDataClient;
}
