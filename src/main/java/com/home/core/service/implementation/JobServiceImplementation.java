package com.home.core.service.implementation;

import com.home.core.model.Job;
import com.home.core.repository.JobRepository;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class JobServiceImplementation {


    @Autowired
    JobRepository jobRepository;

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

    public void saveJob(Job job){
        jobRepository.save(job);
    }

    String fileName = "Fruit.xlsx";

    String sheetName = "Medidor";

    public ByteArrayInputStream hacerExcel() throws IOException{

        String[] columns = {"id","name","price","description"};
        try(Workbook workbook = new HSSFWorkbook();
            ByteArrayOutputStream out = new ByteArrayOutputStream()){
            CreationHelper creationHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet(sheetName) ;
            Row headerRow = sheet.createRow(0);

            for (int r=0;r <columns.length ; r++ )
            {
                Cell cell = headerRow.createCell(r);
                cell.setCellValue(columns[r]);
            }

            int rowIndex =1;
            List<Job> allJobs = jobRepository.findAll();
            for(Job particularJob: allJobs){
                headerRow = sheet.createRow(rowIndex);
                headerRow.createCell(0).setCellValue(particularJob.getIdJob());
                headerRow.createCell(1).setCellValue(particularJob.getNameJob());
                headerRow.createCell(2).setCellValue(particularJob.getPriceJob());
                headerRow.createCell(3).setCellValue(particularJob.getDescriptionJob());

                rowIndex ++;
            }


            workbook.write(out);
            workbook.close();
            return new ByteArrayInputStream(out.toByteArray());

//            try(FileOutputStream fos = new FileOutputStream(fileName))
//            {
//                wb.write(fos);
//            }
        }

    }

}
