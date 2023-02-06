package com.ns.naturalapp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

    private final Service service;


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/views/{name}")
    public ResponseEntity<EntityDTO> getEntity(@PathVariable String name) {
        EntityDTO entityDTO = service.getView(name);
        return ResponseEntity.ok().body(entityDTO);
    }
}
