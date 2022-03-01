package com.test.apinfomedia;

import com.test.apinfomedia.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

@RestController
public class APIController {

    public static String URL_IP2GEO = "https://ws.cdyne.com/ip2geo/ip2geo.asmx/ResolveIP";

    @GetMapping("/date")
    public ResponseEntity<Object> dateFormat(@RequestParam String textDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate requestDate = LocalDate.parse(textDate, dtf);
            long daysBetween = ChronoUnit.DAYS.between(requestDate, LocalDate.now());
            return ResponseHandler.generateResponse("La cantidad de días entre la fecha ingresada y la actual es: " + daysBetween, HttpStatus.OK, daysBetween);
        } catch (DateTimeParseException e) {
            return ResponseHandler.generateResponse("Formato de fecha incorrecto", HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping("/geoip")
    public ResponseEntity<Object> geoip(@RequestParam String ipAddress, @RequestParam String licenseKey) {
        RestTemplate restTemplate = new RestTemplate();
        String geoipUrl = URL_IP2GEO + "?ipAddress=" + ipAddress + "&licenseKey=" + licenseKey;
        String stringXmlResult = restTemplate.getForObject(geoipUrl, String.class);
        try {
            Document doc = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().parse(new InputSource(new StringReader(stringXmlResult)));
            HashMap<String, String> hashMap = xmlToHashMap(doc);
            return ResponseHandler.generateResponse("Consulta realizada", HttpStatus.OK, hashMap);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE, null);
        }
    }

    private static HashMap<String, String> xmlToHashMap(Document xmlDocument) {
        Element root = xmlDocument.getDocumentElement();
        HashMap<String, String> hashMap = new HashMap<>();
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                hashMap.put(node.getNodeName(), node.getTextContent());
            }
        }
        return hashMap;
    }
}
