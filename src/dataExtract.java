import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class dataExtract {

	public void data() throws IOException {
		
		Properties prop=new Properties();
		
		FileInputStream fileName = new FileInputStream("C:\\eclipse\\Introduction2\\src\\data.properties");
		prop.load(fileName);
		System.out.println(prop.getProperty("browser"));

	}

}
