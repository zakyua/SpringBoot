package com.atguigu.springboot.mvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author ChenCheng
 * @create 2022-05-27 9:44
 */
@Controller
public class FromController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }


    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {




        if(!headerImg.isEmpty()){
            String filename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\cache\\"+filename));
        }
        if(photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\cache\\" + originalFilename));
                }
            }
        }

        return "main";
    }


}
