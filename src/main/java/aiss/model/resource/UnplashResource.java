package aiss.model.resource;




import java.util.ArrayList;
import java.util.List;
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
    public List<Urls> getImages() {
    	 log.info(this.access_token);
        ClientResource cr = null;

        List<Urls> images=new ArrayList<>();;
        try {
            cr = new ClientResource(uri + "?access_token=" + access_token);
            log.info(uri + "?access_token=" + access_token);
            String s = cr.get(String.class);
            log.info("--> result" +s);
            //images = cr.get(Urls.class);


//----------------------------------------
            String divisor="\"id\":\"";
            String[] parts=s.split(divisor); 
            Integer numImages=parts.length -1;
            String num=String.valueOf(numImages);
            log.info(num);
            for(int i=1;i<=numImages; i++) {
            	String id=parts[i].substring(0, 11);    
                log.info(id);
                ImagesSearch is=new ImagesSearch();
                is.setId(id);
                divisor="\"small\":\"";
                String urlRaw=parts[i].split(divisor)[1];
                String url=urlRaw.split("\"")[0];
                String urlImg=url.substring(0, url.length()-1);
                log.info(urlImg);
                Urls u=new Urls();
                u.setSmall(url);
                is.setUrls(u);//TODO go on to create a comleted entity for future
                images.add(u);
            }
            
             

        } catch (ResourceException re) {
            log.warning("Error when retrieving all imagess: " + cr.getResponse().getStatus());
        }

        return images;
    }
    }




