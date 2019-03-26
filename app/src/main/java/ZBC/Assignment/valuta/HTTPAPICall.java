package ZBC.Assignment.valuta;

import java.net.MalformedURLException;
import java.net.URL;

public class HTTPAPICall {

    URL url;

    {
        try {
            url = new URL("http://data.fixer.io/api/latest?access_key=5cb2da029de8cadb36dbab32bde00284");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }



}
