package com.myspring.pro27.blob;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ImgBlobController {
   
   @Autowired
   private ImgBlobDao dao;
   
   @RequestMapping(value="/formFile")
   public String formFile() {
      return "imgblob/formFile";
   }
   @RequestMapping(value="/saveImage" ,method = RequestMethod.POST)
   public String saveImage(ImgBlobVO vo) {
      try {
         Map<String, Object> hmap = new HashMap();
         hmap.put("img",vo.getImgFile().getBytes());
         System.out.println("컨트롤러:"+hmap);
         dao.saveImage(hmap);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return "redirect:view";
   }
   @RequestMapping(value="/getByteImage")
   public ResponseEntity<byte[]> getByteImage(){
      Map<String, Object> map = dao.getByteImage();
      byte[] imageContent = (byte[])map.get("img");
      final HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.IMAGE_PNG);
      return new ResponseEntity<byte[]>(imageContent,headers, HttpStatus.OK);
   }
   
    @RequestMapping(value = "/view")
       public String view() {
           return "imgblob/view";
       }
   

}