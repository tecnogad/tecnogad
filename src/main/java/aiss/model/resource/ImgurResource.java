package aiss.model.resource;

import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;
import aiss.model.imgur.Image;

import java.util.Map;
import java.util.logging.Logger;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class ImgurResource {

    private static final Logger log = Logger.getLogger(ImgurResource.class.getName());

    private final String access_token;
    private final String uri = "https://api.imgur.com/3/account/me/images";


    public ImgurResource(String access_token) {
        this.access_token = access_token;
    }

    /**
     *
     * @return Files
     */
    public Image getImages() {
        ClientResource cr = null;
//        Image image= null;
        try {
//            cr = new ClientResource(uri + "?access_token=" + access_token);
//            String result = cr.get(String.class);
//            image = cr.get(Image.class);

        } catch (ResourceException re) {
            log.warning("Error when retrieving all imagess: " + cr.getResponse().getStatus());
        }

        return null;
    }
    }




