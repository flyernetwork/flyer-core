package br.com.flyernetwork.core.flyercore.resource;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flyernetwork.core.flyercore.domain.UserContent;
import br.com.flyernetwork.core.flyercore.repository.UserContentRepository;
import br.com.flyernetwork.core.flyercore.service.impl.UserContentServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/content")
public class ContentResource {

    private final UserContentServiceImpl userContentService;

    @Autowired
    public ContentResource(UserContentServiceImpl userContentService) {
        this.userContentService = userContentService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllUserContent(@PathVariable("userId") String userId){
        List<UserContent> allUserContent = this.userContentService.findAllContent();
        return new ResponseEntity<>(allUserContent,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewUserContent(@RequestBody UserContent contentInfo){
        UserContent newContent = this.userContentService.addNewContent(contentInfo);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Location", newContent.getId().toString());
        return ResponseEntity.ok().headers(headers).build();
    }

    
}
