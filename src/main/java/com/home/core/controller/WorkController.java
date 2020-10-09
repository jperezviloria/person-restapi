package com.home.core.controller;

import com.home.core.dto.request.JobRequestDTO;
import com.home.core.dto.response.WorkResponseDTO;
import com.home.core.model.Job;
import com.home.core.model.Work;
import com.home.core.service.implementation.CloudinaryServiceImplementation;
import com.home.core.service.implementation.JobServiceImplementation;
import com.home.core.service.implementation.SmtpMailSenderImplementation;
import com.home.core.service.implementation.WorkServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/work")
public class WorkController {

    @Autowired
    WorkServiceImplementation workServiceImplementation;

    @Autowired
    CloudinaryServiceImplementation cloudinaryServiceImplementation;

    @Autowired
    JobServiceImplementation jobServiceImplementation;

    @Autowired
    SmtpMailSenderImplementation smtpMailSenderImplementation;

    @GetMapping("/job")
    public List<Job> getAllJobs(){
        return jobServiceImplementation.getAllJobs();
    }
//
//    @PostMapping("/job")
//    public Job saveJob (@RequestBody Job job){
//        jobServiceImplementation.saveJob(job);
//        return job;
//    }

    @GetMapping
    public List<Work> getAllWorks(){
        return workServiceImplementation.getAllWorks();
    }

    @PostMapping
    public String saveWork(@RequestBody Work work){
        return workServiceImplementation.saveWork(work);
    }

    @PostMapping("/cloudinary")
    public ResponseEntity<?> uploadWork(@RequestParam MultipartFile multipartFile, @RequestBody Job job) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
        if(bufferedImage == null){
            return new ResponseEntity(new WorkResponseDTO("Invalid Image"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryServiceImplementation.upload(multipartFile);
        //Job job = new Job((String)result.get("original_filename"),(String) result.get("url"), (String)result.get("public_id"));
        //JobRequestDTO jobRequestDTO = new JobRequestDTO(result.get("url"), (String)result.get("public_id"));
        //jobServiceImplementation.saveJob(job.getIdJob(), job.getNameJob(), job.getPriceJob(), job.getDescriptionJob(), job.setImageUrl((String)result.get("url")), job.setImageId((String)result.get("public_id"))
        //JobRequestDTO jobRequestDTO = new JobRequestDTO(job.getIdJob(),job.getNameJob(),(String)result.get("url"), (String)result.get("public_id"),job.getPriceJob(),job.getDescriptionJob());
        //jobServiceImplementation.saveJob(jobRequestDTO);

        job.setImageUrl((String) result.get("url"));
        job.setImageId((String) result.get("public_id"));// = (String)result.get("url");
        //String idImage = (String)result.get("public_id");
        jobServiceImplementation.saveJob(job);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/email")
    public void sendMail() throws MessagingException, UnsupportedEncodingException {
        smtpMailSenderImplementation.send("perezjulioernesto@gmail.com","Este es el subject", "este es el body");
    }

    @GetMapping("/exportar")
    public ResponseEntity<InputStreamResource> exportarExcel() throws IOException {
        ByteArrayInputStream stream = jobServiceImplementation.hacerExcel();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment; filename=person.xls");

        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
    }



}
