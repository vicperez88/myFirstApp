package controllers;

import play.libs.ws.WS;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSRequestExecutor;
import play.mvc.*;

import utils.Utils;
import views.html.*;

import javax.inject.Inject;
import java.io.IOException;
import scala.concurrent.ExecutionContext;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController @Inject() (ws: WSClient) extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        cfeService();
        return ok(index.render("Your new application is ready."));
    }

    private void cfeService() {
        WSClient client = new WSClient() {
            @Override
            public Object getUnderlying() {
                return null;
            }

            @Override
            public WSRequest url(String url) {
                return url(url);
            }

            @Override
            public void close() throws IOException {

            }
        };

        WSRequest request = client.url(Utils.CFE_URL);


        Promise<String> promise = WS.url("http://myposttarget.com")
        .setContentType("application/x-www-form-urlencoded")
        .post("key1=value1&key2=value2")
        .map( new Function<WSResponse, String>() {
            public String apply(WSResponse response) {
                String result = response.getBody();
                return result;
            }
        });

    }

}
