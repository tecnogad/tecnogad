package aiss.model.resource;




import java.util.Map;
import java.util.logging.Logger;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.unplash.ImagesSearch;
import aiss.model.unplash.Urls;

public class UnplashResource {

    private static final Logger log = Logger.getLogger(UnplashResource.class.getName());

    private final String access_token;
    private final String uri = "https://api.unsplash.com/users/tecnogad/photos/";//TODO


    public UnplashResource(String access_token) {
        this.access_token = access_token;
    }

    /**
     *
     * @return Files
     */
    public Urls getImages() {
    	 log.info(this.access_token);
        ClientResource cr = null;

        Urls images=null;
        try {
            cr = new ClientResource(uri + "?access_token=" + access_token);
            log.info(uri + "?access_token=" + access_token);
            String result = cr.get(String.class);
            log.info("--> result" + result);
            //images = cr.get(Urls.class);

        } catch (ResourceException re) {
            log.warning("Error when retrieving all imagess: " + cr.getResponse().getStatus());
        }

        return images;
    }
    }




