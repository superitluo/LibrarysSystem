package Test;

import com.liberarysystem.frame.MainFrame;
import com.liberarysystem.util.MyRequest;

public class MainFrameTest {
	public static void main(String[] args) {
		MyRequest request = new MyRequest();
		new MainFrame(request);
	}
}
