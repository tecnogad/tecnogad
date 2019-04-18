package aiss.model.resource;




import java.io.IOException;
import org.apache.commons.*;

import org.apache.http.client.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.google.drive.FileItem;
import aiss.model.unplash.ImagesSearch;
import aiss.model.unplash.UnplashCollection;
import aiss.model.unplash.Urls;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;

public class UnplashResource {

    private static final Logger log = Logger.getLogger(UnplashResource.class.getName());

    private final String access_token;
    private String name;
    private final String uri = "https://api.unsplash.com/";


    public UnplashResource(String access_token, String name) {
        this.access_token = access_token;
        this.name=name;
    }
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
            cr = new ClientResource(uri+"users/"+name+"/photos/" + "?access_token=" + access_token);
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
    
    
    public boolean createCollection(String title, String description) throws IOException {

        ClientResource cr = null;
        log.info("in resource");
        try {
            cr = new ClientResource(uri+"collections" + "?access_token=" + access_token);

           UnplashCollection newc= new UnplashCollection();
           newc.setTitle("ulti");
           
            //String s="{\"title\":\"hola\",\"description\":\"des\"}";
           cr.post(newc);    

            log.info("Create Collection response->" + cr.getResponse().getStatus());
            return true;
        
        } catch (ResourceException re) {
            log.warning("Error when inserting file: " + cr.getResponse().getStatus());
            return false;
        }
      
    }
    public void POSTRequest(String title) throws IOException {
        //final String POST_PARAMS =  "{\n" + "\"title2000\": 101,\"" + "\n}";
    	 String data = "title="+title+"\"";
//        System.out.println(data);
        System.out.println(access_token);
       // URL obj = new URL("https://api.unsplash.com/collections?access_token="+"ac7494081a0483fcbb270238435de2c60bb413fb34c496443c6e93f46eaeaa40");
        URL obj = new URL("https://api.unsplash.com/collections?access_token="+access_token);
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();

        postConnection.setRequestMethod("POST");

        postConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        
  //      postConnection.setRequestProperty("title", "adefgh");
 //       postConnection.setRequestProperty("User-agent", "adefgh");
        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        OutputStreamWriter wr = new OutputStreamWriter(os);
        wr.write(data);
        wr.flush();
        wr.close();
        int responseCode = postConnection.getResponseCode();
        System.out.println("POST Response Code :  " + responseCode);
        System.out.println("POST Response Message : " + postConnection.getResponseMessage());

        if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();
            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("POST NOT WORKED");
        }
    }
    }




