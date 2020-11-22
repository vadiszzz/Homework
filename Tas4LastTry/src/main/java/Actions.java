import com.yandex.disk.rest.Credentials;
import com.yandex.disk.rest.ProgressListener;
import com.yandex.disk.rest.RestClient;
import com.yandex.disk.rest.exceptions.ServerException;
import com.yandex.disk.rest.exceptions.ServerIOException;
import com.yandex.disk.rest.exceptions.http.UnauthorizedException;
import com.yandex.disk.rest.json.DiskInfo;
import com.yandex.disk.rest.json.Link;

import java.io.File;
import java.io.IOException;

public class Actions {
    public static RestClient restClient;
    public static boolean authorized;
    //  public boolean authorized;

    public Actions(String user, String token) {
        if ((user == null) || (token == null)) {
            throw new NullPointerException("User or token can not be null");
        }
        Credentials credentials = new Credentials(user, token);
        restClient = new RestClient(credentials);
        authorized = true;
        try {
            restClient.getDiskInfo();
        } catch (IOException e) {
        } catch (ServerIOException e) {
            System.out.println("Invalid token, not authorized");
            authorized = false;
        }
    }

    public Actions(RestClient restClient) throws IOException, ServerIOException {
        if (restClient == null) {
            throw new NullPointerException("RestClient can not be null");
        }
        this.restClient = restClient;
        authorized = true;
    }

    static public Link makeFolder(String path) {
        if (path == null) {
            throw new NullPointerException("Path can not be null");
        }
        Link result = null;
        try {
            result = restClient.makeFolder(path);
        } catch (IOException e) {
        } catch (ServerIOException e) {
            authorized = false;
        }
        return result;
    }

    public void downloadFile(final String path, final File saveTo, final ProgressListener progressListener) {
        if (path == null) {
            throw new NullPointerException("Path can not be null");
        }
        if (saveTo == null) {
            throw new NullPointerException("Save directory can not be null");
        }
        try {
            restClient.downloadFile(path, saveTo, progressListener);
        } catch (IOException e) {
        } catch (ServerException e) {
            authorized = false;
        }
    }

    public DiskInfo diskInformation() {
        DiskInfo result = null;
        try {
            result = restClient.getDiskInfo();
        } catch (IOException e) {
        } catch (ServerIOException e) {
            authorized = false;
        }
        return result;
    }

    public Link deleteFile(String path, boolean permanently) {
        if (path == null) {
            throw new NullPointerException("Path can not be null");
        }
        Link result = null;
        try {
            result = restClient.delete(path, permanently);
        } catch (IOException e) {
        } catch (ServerIOException e) {
            authorized = false;
        }
        return result;
    }
}
