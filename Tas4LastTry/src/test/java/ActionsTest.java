

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
    public void InvalidToken() {
        String user = "vadiszzz";
        String token = "AgAAAAAyz5SlAADLW0WIDd2ZYkI1oMPA8eq3ud5";
        Actions actions = new Actions(user, token);
        Assertions.assertFalse(actions.authorized);
    }

    @Test
    public void CorrectToken() {
        String user = "vadiszzz";
        String token = "AgAAAAAyz5SlAADLW0WIDd2ZYkI1oMPA8eq3ud4";
        Actions actions = new Actions(user, token);
        Assertions.assertTrue(actions.authorized);
    }

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

    @Test
    public void testMakeFolderCorrect() throws IOException, ServerIOException {
        String path = "NewFolder1";
        String user = "vadiszzz";
        String token = "AgAAAAAyz5SlAADLW0WIDd2ZYkI1oMPA8eq3ud4";
        Actions yandexDisk = new Actions(user, token);
        System.out.println(yandexDisk.diskInformation());
        Assertions.assertDoesNotThrow(() -> yandexDisk.makeFolder(path));
    }

    @Test
    public void testMakeFolderNull() throws IOException, ServerIOException {
        String path = null;
        String user = "vadiszzz";
        String token = "AgAAAAAyz5SlAADLW0WIDd2ZYkI1oMPA8eq3ud4";
        Actions yandexDisk = new Actions(user, token);
        Assertions.assertThrows(NullPointerException.class, () -> yandexDisk.makeFolder(path));
    }

    @Test
    public void testCredentialsNull() {
        String user = null;
        String token = "AgAAAAAyz5SlAADLW0WIDd2ZYkI1oMPA8eq3ud4";
        Assertions.assertThrows(NullPointerException.class, () -> new Actions(user, token));
    }

    @Test
    public void testDownloadFilePathIsNull() throws IOException, ServerIOException {
        String path = null;
        String user = "vadiszzz";
        String token = "AgAAAAAyz5SlAADLW0WIDd2ZYkI1oMPA8eq3ud4";
        Actions yandexDisk = new Actions(user, token);
        ProgressListener progressListener = null;
        File saveTo = new File("C://someFolder");
        Assertions.assertThrows(NullPointerException.class, () -> yandexDisk.downloadFile(path, saveTo, progressListener));
    }

    @Test
    public void testDownloadFileSaveToIsNull() throws IOException, ServerIOException {
        String path = "path";
        String user = "vadiszzz";
        String token = "AgAAAAAyz5SlAADLW0WIDd2ZYkI1oMPA8eq3ud4";
        Actions yandexDisk = new Actions(user, token);
        ProgressListener progressListener = null;
        File saveTo = null;
        Assertions.assertThrows(NullPointerException.class, () -> yandexDisk.downloadFile(path, saveTo, progressListener));
    }

    @Test
    public void testDownloadNormal() throws IOException, ServerException {
        String path = "path";
        String user = "vadiszzz";
        String token = "AgAAAAAyz5SlAADLW0WIDd2ZYkI1oMPA8eq3ud4";
        Actions yandexDisk = new Actions(user, token);
        ProgressListener progressListener = null;
        File saveTo = new File("C://someFolder");
        Assertions.assertDoesNotThrow(() -> yandexDisk.downloadFile(path, saveTo, progressListener));
    }

    @Test
    public void testDeleteNullPath() throws IOException, ServerIOException {
        String path = null;
        String user = "vadiszzz";
        String token = "AgAAAAAyz5SlAADLW0WIDd2ZYkI1oMPA8eq3ud4";
        Actions yandexDisk = new Actions(user, token);
        Assertions.assertThrows(NullPointerException.class, () -> yandexDisk.deleteFile(path, true));
    }


}
