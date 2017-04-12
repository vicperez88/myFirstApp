package controllers;

import javax.inject.Inject;

import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.mvc.Controller;
import utils.Utils;


/**
 * Created by Victor Perez on 16/03/2017.
 */
public class CFE extends Controller {

    @Inject
    WSClient ws;

    WSRequest request = ws.url(Utils.CFE_URL);
    WSRequest complex = request.setHeader("", "").setRequestTimeout(1000).setQueryParameter("paramKey", "paramValue");
}
