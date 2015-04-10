package groovy
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpGet
/**
 *
 * @author Sebastian MA
 */

try {

    URI uri = new URI("http://www.eggcharge.com/web");

    HttpGet method = new HttpGet(uri);
    HttpResponse response = httpClient.execute(method);

    response.r
    log.info("Response from BusinessApi: {}", result);

} catch(IOException e) {
    log.error("IOException: ", e);
} catch(URISyntaxException e) {
    log.error("URISyntaxException: {}", e.getMessage());
}
