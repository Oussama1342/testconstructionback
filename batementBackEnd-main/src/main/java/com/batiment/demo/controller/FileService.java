package com.batiment.demo.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class FileService {


	   List<String> files = new ArrayList<String>();
	  // private final Path rootLocation = Paths.get("C:\\Users\\Ilef.InfoService\\Desktop\\Nouveau dossier\\uplodedfile");
	   
	   private static final Logger logger = Logger.getLogger(FileService.class.getName());
	   
	   @PostMapping("/savefile")
	   public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file)throws Exception {
			if (file == null) {
				throw new RuntimeException("You must select the a file for uploading");
			}
			InputStream inputStream = file.getInputStream();
			String originalName = file.getOriginalFilename();
			String name = file.getName();
			String contentType = file.getContentType();
			long size = file.getSize();
			logger.info("inputStream: " + inputStream);
			logger.info("originalName: " + originalName);
			logger.info("name: " + name);
			logger.info("contentType: " + contentType);
			logger.info("size: " + size);
			// Do processing with uploaded file data in Service layer
			return new ResponseEntity<String>(originalName, HttpStatus.OK);
		}
	   
	   @PostMapping("/savemultiplefile")
	   public ResponseEntity multiplfileupload(@RequestParam("file")  MultipartFile [] files){
	   
	   for(int i = 0; i< files.length ; i++ ) {
		   
		   
		   logger.info(String.format("File name '%s' uploaded successfuly. ", files[i].getOriginalFilename())) ;
	   }
	   
	   
	   
			return  ResponseEntity.ok().body("bien uploaded");
		}
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   /*{
	      String message;
	      try {
	         try {
	            Files.copy(file.getInputStream(), this.rootLocation.resolve("file_name.pdf"));
	         } catch (Exception e) {
	            throw new RuntimeException("FAIL!");
	         }
	         files.add(file.getOriginalFilename());

	         message = "Successfully uploaded!";
	         return ResponseEntity.status(HttpStatus.OK).body(message);
	      } catch (Exception e) {
	         message = "Failed to upload!";
	         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	      }
	   }*/
}
