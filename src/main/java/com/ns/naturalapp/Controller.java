package com.ns.naturalapp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@org.springframework.stereotype.Controller
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

    private final Service service;


    @GetMapping("/views/{id}")
    public ResponseEntity<EntityDTO> getEntity(@PathVariable String id) {
        EntityDTO entityDTO = service.getView(Long.parseLong(id));
        return ResponseEntity.ok().body(entityDTO);
    }
}
