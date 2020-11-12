
import com.yandex.disk.rest.Credentials;
import com.yandex.disk.rest.ProgressListener;
import com.yandex.disk.rest.RestClient;
import com.yandex.disk.rest.exceptions.ServerException;
import com.yandex.disk.rest.exceptions.ServerIOException;
import com.yandex.disk.rest.json.DiskInfo;
import com.yandex.disk.rest.json.Link;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.IOException;

public class ActionsTest {
    @Test
    public void testMakeFolderCorrect() {
        String path = "NewFolder1";
        Credentials credentials = new Credentials("vadiszzz", "AgAAAAAyz5SlAADLW0WIDd2ZYkI1oMPA8eq3ud4");
        Actions yandexDisk = new Actions(credentials);
        Assertions.assertDoesNotThrow(() -> yandexDisk.MakeFolder(path));
    }
    @Test
    public void testMakeFolderNull(){
        String path = null;
        Credentials credentials = new Credentials("vadiszzz", "AgAAAAAyz5SlAADLW0WIDd2ZYkI1oMPA8eq3ud4");
        Actions yandexDisk = new Actions(credentials);
        Assertions.assertThrows(NullPointerException.class,() ->yandexDisk.MakeFolder(path));
    }
    @Test
    public void testCredentialsNull(){
        Credentials credentials = null;
        Assertions.assertThrows(NullPointerException.class,()-> new Actions(credentials));
    }
    @Test
    public void testDownloadFilePathIsNull(){
        String path = null;
        Credentials credentials = new Credentials("vadiszzz", "AgAAAAAyz5SlAADLW0WIDd2ZYkI1oMPA8eq3ud4");
        Actions yandexDisk = new Actions(credentials);
        ProgressListener progressListener = null;
        File saveTo = new File("C://someFolder");
        Assertions.assertThrows(NullPointerException.class,() ->  yandexDisk.DownloadFile(path,saveTo,progressListener));
    }
    @Test
    public void testDownloadFileSaveToIsNull(){
        String path = "path";
        Credentials credentials = new Credentials("vadiszzz", "AgAAAAAyz5SlAADLW0WIDd2ZYkI1oMPA8eq3ud4");
        Actions yandexDisk = new Actions(credentials);
        ProgressListener progressListener = null;
        File saveTo = null;
        Assertions.assertThrows(NullPointerException.class,() ->  yandexDisk.DownloadFile(path,saveTo,progressListener));
    }
    @Test
    public void testDownloadNormal(){
        String path = "path";
        Credentials credentials = new Credentials("vadiszzz", "AgAAAAAyz5SlAADLW0WIDd2ZYkI1oMPA8eq3ud4");
        Actions yandexDisk = new Actions(credentials);
        ProgressListener progressListener = null;
        File saveTo = new File("C://someFolder");
        Assertions.assertDoesNotThrow(() ->  yandexDisk.DownloadFile(path,saveTo,progressListener));
    }
    @Test
    public void testDeleteNullPath(){
        String path = null;
        Credentials credentials = new Credentials("vadiszzz", "AgAAAAAyz5SlAADLW0WIDd2ZYkI1oMPA8eq3ud4");
        Actions yandexDisk = new Actions(credentials);
        Assertions.assertThrows(NullPointerException.class,() ->yandexDisk.DeleteFile(path,true));
    }


}
