package br.com.flyernetwork.core.flyercore.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/healthCheck")
public class HealthCheckResource {

    @GetMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public String getHealth(){
        return "OK";
    } 
    
}
