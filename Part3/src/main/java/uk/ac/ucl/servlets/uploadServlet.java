package uk.ac.ucl.servlets;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Reference:
 * Thoughtscript(2018) javax-servlet tutorial [online]
 * https://github.com/eugenp/tutorials/blob/master/javax-servlets/src/main/java/com/baeldung/servlets/UploadServlet.java
 * (Accessed: 31 Mar 2019)
 */

@WebServlet("/uploadFile")
public class uploadServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "upload";
    private static final long serialVersionUID = 1L;
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3 MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 30; // 30MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //check contains upload file
        if(!ServletFileUpload.isMultipartContent(request)){
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must have upload file");
            writer.flush();
            return;
        }

        //configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        //set upload size
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);

        //build the directory path
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;

        //creates the directory
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()){
            uploadDir.mkdir();
        }

        //extract file data
        try{
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0){
                for(FileItem item : formItems){
                    // process only fields that are not form field
                    if(!item.isFormField()){
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);

                        item.write(storeFile);
                        request.setAttribute("message", "Successfully Uploaded");

                        //update the Patient List
                        ModelFactory.setModel(filePath);
                    }
                }
            }
        }catch (Exception e){
            request.setAttribute("message", "ERROR happened: " + e.getMessage());
        }



        // Invoke JSP
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/uploadResult.jsp");
        dispatcher.forward(request,response);

    }

}
