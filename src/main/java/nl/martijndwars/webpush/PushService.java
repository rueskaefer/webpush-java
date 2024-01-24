package nl.martijndwars.webpush;

import org.jose4j.lang.JoseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.util.concurrent.ExecutionException;

public class PushService extends AbstractPushService<PushService> {

    public PushService() {
    }

    public PushService(String gcmApiKey) {
        super(gcmApiKey);
    }

    public PushService(KeyPair keyPair) {
        super(keyPair);
    }

    public PushService(KeyPair keyPair, String subject) {
        super(keyPair, subject);
    }

    public PushService(String publicKey, String privateKey) throws GeneralSecurityException {
        super(publicKey, privateKey);
    }

    public PushService(String publicKey, String privateKey, String subject) throws GeneralSecurityException {
        super(publicKey, privateKey, subject);
    }

    /**
     * Send a notification and wait for the response.
     *
     * @param notification
     * @param encoding
     * @return The http status
     * @throws GeneralSecurityException
     * @throws IOException
     * @throws JoseException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public int send(Notification notification, Encoding encoding) throws GeneralSecurityException, IOException, JoseException, ExecutionException, InterruptedException {
        HttpRequest request = prepareRequest(notification, encoding);
        URL endpoint = new URL(notification.getEndpoint());
        HttpURLConnection con = (HttpURLConnection) endpoint.openConnection();
        con.setDoOutput(true);
        request.getHeaders().forEach(con::addRequestProperty);

        if (request.getBody() != null) {
            con.getOutputStream().write(request.getBody());
        }
        return con.getResponseCode();
    }

    public int send(Notification notification) throws GeneralSecurityException, IOException, JoseException, ExecutionException, InterruptedException {
        return send(notification, Encoding.AESGCM);
    }

}
