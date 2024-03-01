
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import  java.util.Properties;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("ReadDataFromConfig!");

        try{
            new Main().ReadDataFromConfig();
        }
        catch (Exception e ) {
            e.printStackTrace();
        }

    }

    public void ReadDataFromConfig () throws IOException {
        InputStream ipSteam = InputStream.nullInputStream();
        try {
            Properties prop = new Properties();
            String fileProbName = "conf\\config.properties";
            String AbsolutePath = new File("").getAbsolutePath();

            System.out.println("path: " + AbsolutePath + "\\" + fileProbName);

            ipSteam = new FileInputStream(new File(AbsolutePath + "\\" + fileProbName) );
            if (ipSteam != null) {
                prop.load(ipSteam);
                System.out.println("can load");
            }
            else
                System.out.println("property file '" + fileProbName + "' not found in the classpath");


            prop.forEach((k, v) -> System.out.println("Key:" + k + "\nValue:" + v ) );

//            String employee = prop.getProperty("ws_url_service_employee");
//            String organization = prop.getProperty("ws_url_service_organization");
//            String token = prop.getProperty("ws_url_service_token");
//            String serviceCode = prop.getProperty("service_code");
//
//            System.out.println("employee:" + employee);
//            System.out.println("organization:" + organization);
//            System.out.println("token:" + token);
//            System.out.println("serviceCode:" + serviceCode);

        }

        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            ipSteam.close();
        }

    }
}