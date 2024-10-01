package com.spring.upload.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

	@GetMapping(value= {"","/","/index","/home","/default"})
	public ModelAndView homePage() {
		return new ModelAndView("index","message","Welcome to Spring MVC File Upload.");
	}
	
	@PostMapping(value="/uploadFile")
	public String uploadFile(@RequestParam("description") String description, @RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) {
		
		// file handling to upload it in the server path
		if(!file.isEmpty()) {
			try {
				String relativeWebPath="/resources";
				String absoluteFilePath=request.getServletContext().getRealPath(relativeWebPath);
				System.out.println("Location: "+absoluteFilePath);
				byte[] bytes=file.getBytes();
				File dir=new File(absoluteFilePath);
				if(!dir.exists()) {
					dir.mkdirs();
				}
				File uploadFile=new File(dir.getAbsolutePath()+File.separator+file.getOriginalFilename());
				BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(uploadFile));
				outputStream.write(bytes);
				outputStream.close();
				model.addAttribute("uploadMessage","File Uploaded Successfully, file name: "+file.getOriginalFilename()+", Description:  "+description);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "success";
	}
}
