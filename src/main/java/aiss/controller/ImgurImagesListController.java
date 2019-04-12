package aiss.controller;



import aiss.model.resource.ImgurResource;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImgurImagesListController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ImgurImagesListController.class.getName());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String accessToken = (String) req.getSession().getAttribute("Imgur-token");

        if (accessToken != null && !"".equals(accessToken)) {
        	;
            ImgurResource gdResource = new ImgurResource(accessToken);
            log.info("gd");
//            Files files = gdResource.getFiles();

//            if (files != null) {
//                req.setAttribute("files", files);
//                req.getRequestDispatcher("/googleDriveFileListing.jsp").forward(req, resp);
//            } else {
//                log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
//                req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req, resp);
//            }
        } else {
            log.info("Trying to access Imgurwithout an access token, redirecting to OAuth servlet");
            req.getRequestDispatcher("/AuthController/Imgur").forward(req, resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }
}
