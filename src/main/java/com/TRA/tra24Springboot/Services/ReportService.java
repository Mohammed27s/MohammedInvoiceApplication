package com.TRA.tra24Springboot.Services;


import com.TRA.tra24Springboot.DTO.ProductDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ReportService {

    @Autowired
    private ProductServices productServices;



    public void createProductReport() throws FileNotFoundException, JRException {
        List<ProductDTO> productDTOList = productServices.getProducts();
        UUID uuid = UUID.randomUUID();

        String pathToSave = "C:\\Users\\TRA\\Desktop\\JasperReport";

        File file = ResourceUtils.getFile("C:\\Users\\TRA\\Desktop\\MohammedInvoiceApplication\\src\\main\\resources\\Product_report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productDTOList);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,new HashMap<>(), dataSource);
        String fileName = pathToSave + uuid+".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint, fileName);
        System.out.print("Report is printed: "+ fileName);


    }




}
