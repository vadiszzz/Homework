import com.yandex.disk.rest.Credentials;
import com.yandex.disk.rest.ProgressListener;
import com.yandex.disk.rest.RestClient;
import com.yandex.disk.rest.exceptions.ServerException;
import com.yandex.disk.rest.exceptions.ServerIOException;
import com.yandex.disk.rest.json.DiskInfo;
import com.yandex.disk.rest.json.Link;

import java.io.File;
import java.io.IOException;

public class Actions {
    Credentials credentials;

    public Actions(Credentials credentials) {
        if (credentials==null){
            throw new NullPointerException("Credentials can not be null");
        }
        this.credentials = credentials;
    }

    public Link MakeFolder(String path) {
        if (path==null){
            throw new NullPointerException("Path can not be null");
        }
        RestClient restClient = new RestClient(credentials);
        Link result = null;
        try {
            result = restClient.makeFolder(path);
        } catch (IOException e) {
        } catch (ServerIOException e) {
        }
        return result;
    }

    public void DownloadFile(final String path, final File saveTo, final ProgressListener progressListener) {
        if (path == null) {
            throw new NullPointerException("Path can not be null");
        }
        if (saveTo == null) {
            throw new NullPointerException("Save directory can not be null");
        }
        RestClient restClient = new RestClient(credentials);
        try {
            restClient.downloadFile(path, saveTo, progressListener);
        } catch (IOException e) {
        } catch (ServerException e) {
        }
    }

    public DiskInfo DiskInformation() {
        RestClient restClient = new RestClient(credentials);
        DiskInfo result = null;
        try {
            result = restClient.getDiskInfo();
        } catch (IOException e) {
        } catch (ServerIOException e) {
        }
        return result;
    }

    public Link DeleteFile(String path, boolean permanently) {
        if (path == null) {
            throw new NullPointerException("Path can not be null");
        }
        RestClient restClient = new RestClient(credentials);
        Link result = null;
        try {
            result = restClient.delete(path, permanently);
        } catch (IOException e) {
        } catch (ServerIOException e) {
        }
        return result;
    }
}
