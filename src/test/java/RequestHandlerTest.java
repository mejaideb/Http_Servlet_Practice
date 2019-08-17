import com.tavisca.workshops.practiceHttpServer.RequestHandler;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class RequestHandlerTest {

    @Test
    public void extractFileNameAndRequestType() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("httprequest.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        RequestHandler requestHandler = new RequestHandler(bufferedInputStream);

        requestHandler.handleRequest();

        assertEquals("index.html", requestHandler.getFileName());
        assertEquals("GET", requestHandler.getMethodName());
        bufferedInputStream.close();
        fileInputStream.close();
    }
}
