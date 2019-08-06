import com.tavisca.workshops.practiceHttpServer.*;
import org.junit.Assert;
import org.junit.Test;

public class RequestedFileExtensionTest {

    @Test
    public void getContentTypeFromExtensionTest() {
        Assert.assertEquals("text/plain", RequestedFileExtension.extensionMap.get("txt"));
        Assert.assertEquals("text/html", RequestedFileExtension.extensionMap.get("html"));
        Assert.assertEquals("image/jpg", RequestedFileExtension.extensionMap.get("jpg"));
        Assert.assertEquals("image/jpeg", RequestedFileExtension.extensionMap.get("jpeg"));
        Assert.assertEquals("image/png", RequestedFileExtension.extensionMap.get("png"));

    }

    @Test
    public void getContentTypeFromFilenameTest() {

        Assert.assertEquals("text/html", RequestedFileExtension.getContentType("index.html"));
        Assert.assertEquals("image/png", RequestedFileExtension.getContentType("welcome.png"));

    }
}
