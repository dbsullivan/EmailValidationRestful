package MadJavaBeta;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.mail.internet.InternetAddress;
import javax.xml.ws.Endpoint;
import java.lang.Object;

/**
 * Created by Student on 10/25/2015.
 * @author  Sullivan,Albee,Gundrum
 * @param
 */
@WebService()
public class EmailValidationBeta {
    @WebMethod
    public boolean isEmailValid(String email) {
        boolean valid = true;

        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();

        } catch (Exception e) {
            valid = false;
        }
        return valid;

    }

    @WebMethod
    public boolean isEmailValid2(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Matcher m = null;
        try {

            java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
            m = p.matcher(email);
            return m.matches();

        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] argv) {
        Object implementor = new EmailValidationBeta();
        String address = "http://localhost:9012/EmailValidationBeta";
        Endpoint.publish(address, implementor);
    }
}

