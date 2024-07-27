package com.TRA.tra24Springboot.Services;


import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Repositories.ProductRepository;
import lombok.SneakyThrows;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    private ProductRepository productRepository;
    private String pathToReports;


    @SneakyThrows
    public String generalReport() throws FileNotFoundException {
        List<Product> productList = productRepository.findAll();


        File file = ResourceUtils.getFile("classpath:Product_report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatesBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\products.pdf");
        return "Report generated : " + pathToReports+"\\products.pdf";

    }




}
