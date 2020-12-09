

import com.yandex.disk.rest.ProgressListener;
import com.yandex.disk.rest.RestClient;
import com.yandex.disk.rest.exceptions.ServerException;
import com.yandex.disk.rest.exceptions.ServerIOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;

public class ActionsTest {

    @Test
    public void testMakeFolderMock() throws IOException, ServerIOException {
        String path = "NewFolder1";
        RestClient restClient = Mockito.mock(RestClient.class);
        Actions actions = new Actions(restClient);
        actions.makeFolder(path);
        Mockito.verify(restClient, Mockito.times(1)).makeFolder(path);
    }

    @Test
    public void testMakeDownloadFileMock() throws IOException, ServerException {
        String path = "path";
        RestClient restClient = Mockito.mock(RestClient.class);
        Actions actions = new Actions(restClient);
        File saveTo = new File("C://someFolder");
        ProgressListener progressListener = null;
        actions.downloadFile(path, saveTo, progressListener);
        Mockito.verify(restClient, Mockito.times(1)).downloadFile(path, saveTo, progressListener);
    }

    @Test
    public void testDiskInfoMock() throws IOException, ServerIOException {
        RestClient restClient = Mockito.mock(RestClient.class);
        Actions actions = new Actions(restClient);
        actions.diskInformation();
        Mockito.verify(restClient, Mockito.times(1)).getDiskInfo();
    }

    @Test
    public void testDeleteMock() throws IOException, ServerIOException {
        String path = "path";
        RestClient restClient = Mockito.mock(RestClient.class);
        Actions actions = new Actions(restClient);
        actions.deleteFile(path, true);
        Mockito.verify(restClient, Mockito.times(1)).delete(path, true);
    }
    
}
