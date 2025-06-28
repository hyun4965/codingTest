package lab.apiu;

import java.io.OutputStream;
import java.io.IOException;

public class HTMLHelper {

    public HTMLHelper(OutputStream o) throws IOException {
	    if(o ==null){
		    throw new IOException();
        }
    }

    public void startHTMLDoc() throws IOException {}

    public void appendSimpleHTMLPara(String str) throws APIException {
	    if(str == null){
		    throw new APIException();
	    }
    }

    public void endHTMLDoc() throws IOException {}
}