package br.com.flyernetwork.core.flyercore.resource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Optional;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFTableStyleInfo;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin("*")
@RequestMapping("/sheet")
@RestController
public class SheetResource {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @GetMapping("/read")
    public ResponseEntity<?> readSheet() throws Exception {

        RestTemplate restTemplate = this.restTemplateBuilder.build();
        byte[] response = restTemplate.getForObject("https://tulio-buck01.s3-sa-east-1.amazonaws.com/text.xlsx",
                byte[].class);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(response);

        try (XSSFWorkbook wb = new XSSFWorkbook(inputStream)) {
            XSSFSheet sheet = wb.getSheet("Sheet0");
            XSSFCellStyle blocked = wb.createCellStyle();
            blocked.setLocked(false);

            // Iterator it = sheet.getRow(sheet.getFirstRowNum()).cellIterator();
            // while (it.hasNext()) {
            //     XSSFCell c = (XSSFCell) it.next();
            //     c.setCellStyle(blocked);
            // }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            wb.write(out);

            Optional<?> generatedSheet = Optional.ofNullable(new ByteArrayInputStream(out.toByteArray()));
            out.close();

            if (generatedSheet.isPresent()) {
                HttpHeaders header = new HttpHeaders();
                header.setContentType(new MediaType("application", "vnd.ms-excel"));
                header.set("Content-Disposition", "attachment; filename=text.xlsx");
                return new ResponseEntity<>(new InputStreamResource((InputStream) generatedSheet.get()), header,
                        HttpStatus.OK);
            }

        }

        return null;
    }

    @GetMapping()
    public ResponseEntity<?> generateSheet() throws IOException {

        try (XSSFWorkbook wb = new XSSFWorkbook()) {
            XSSFSheet sheet = wb.createSheet();

            // Set which area the table should be placed in
            AreaReference reference = wb.getCreationHelper().createAreaReference(new CellReference(0, 0),
                    new CellReference(2, 2));

            // Create
            XSSFTable table = sheet.createTable();
            table.setName("Test");
            table.setDisplayName("Test_Table");

            // For now, create the initial style in a low-level way
            table.getCTTable().addNewTableStyleInfo();
            table.getCTTable().getTableStyleInfo().setName("TableStyleMedium2");

            // Style the table
            XSSFTableStyleInfo style = (XSSFTableStyleInfo) table.getStyle();
            style.setName("TableStyleMedium2");
            style.setShowColumnStripes(false);
            style.setShowRowStripes(true);
            style.setFirstColumn(false);
            style.setLastColumn(false);
            style.setShowRowStripes(true);
            style.setShowColumnStripes(true);

            sheet.protectSheet("asdasd");
            XSSFCellStyle unlockedNumericStyle = wb.createCellStyle();
            unlockedNumericStyle.setLocked(false);

            XSSFRow row;
            XSSFCell cell;
            for (int i = 0; i < 3; i++) {
                // Create row
                row = sheet.createRow(i);
                for (int j = 0; j < 3; j++) {
                    // Create cell
                    cell = row.createCell(j);
                    if (i == 0) {
                        // XSSFCellStyle lockedNumericStyle = wb.createCellStyle();
                        // lockedNumericStyle.setLocked(true);
                        cell.setCellValue("Column" + (j + 1));
                        // cell.setCellStyle(lockedNumericStyle);

                    } else {
                        cell.setCellValue((i + 1.0) * (j + 1.0));
                        cell.setCellStyle(unlockedNumericStyle);
                    }
                }
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            wb.write(out);

            Optional<?> generatedSheet = Optional.ofNullable(new ByteArrayInputStream(out.toByteArray()));

            out.close();
            wb.close();

            if (generatedSheet.isPresent()) {
                HttpHeaders header = new HttpHeaders();
                header.setContentType(new MediaType("application", "vnd.ms-excel"));
                header.set("Content-Disposition", "attachment; filename=text.xlsx");
                return new ResponseEntity<>(new InputStreamResource((InputStream) generatedSheet.get()), header,
                        HttpStatus.OK);

            }

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
