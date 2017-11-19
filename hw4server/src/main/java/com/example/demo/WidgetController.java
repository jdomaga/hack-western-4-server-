package com.example.demo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.concurrent.atomic.AtomicLong;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api")
@RestController
public class WidgetController {

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String index(@RequestParam("myimage") MultipartFile file) throws IOException {
        VisualRecognition service = new VisualRecognition(
                VisualRecognition.VERSION_DATE_2016_05_20
        );
        service.setApiKey("8d7aced8efa9ce11cca985d203dce5989cc20148");

        InputStream imagesStream =  new BufferedInputStream(file.getInputStream());
        //InputStream imagesStream = new FileInputStream("C:/Users/paul_/Desktop/hw4/xx.jpg");

        ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
                .imagesFile(imagesStream)
                .imagesFilename("xx.jpg")
                .parameters("{\"classifier_ids\":\"food\"}")
//                .parameters("{\"classifier_ids\":[\"food\",\"default\"]}")
                .build();
        ClassifiedImages result = service.classify(classifyOptions).execute();
        System.out.println(result);
            /*
        String attachmentName = "file";
        //String attachmentFileName = file_name_with_ext;
        String crlf = "\r\n";
        String twoHyphens = "--";
        String boundary =  "*****";

        //File fi = new File("C:\\Users\\paul_\\Desktop\\hw4\\xx.jpg");
       //byte[] fileContent = Files.readAllBytes(fi.toPath());

        //String urlParameters  = "param1=a&param2=b&param3=c";
        //byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );

        URL url = new URL("https://gateway-a.watsonplatform.net/visual-recognition/api/v3/classify?api_key=8d7aced8efa9ce11cca985d203dce5989cc20148&version=2016-05-20");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        //con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        //con.setRequestProperty("Content-Length", String.valueOf(postData.length));
        //con.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

        con.setDoOutput(true);
        try( DataOutputStream request = new DataOutputStream( con.getOutputStream())) {

            request.writeBytes(twoHyphens + boundary + crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"" +
                    attachmentName + "\";filename=\"" +
                    ".jpg" + "\"" + crlf); // replace jpg with file_extention
            request.writeBytes(crlf);
            request.write(file.getBytes());
            request.writeBytes(crlf);
            request.writeBytes(twoHyphens + boundary +
                    twoHyphens + crlf);
            //request.write( postData );
            request.flush();
            request.close();
        }

        Reader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        String ibmResponse = "";
        for (int c; (c = in.read()) >= 0;)
            ibmResponse += ((char)c);
        */
        return result.toString();
    }
}