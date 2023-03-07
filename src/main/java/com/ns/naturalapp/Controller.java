package com.ns.naturalapp;

import com.ns.naturalapp.Config.View;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/views")
    public ResponseEntity<List<View>> getAllViews() {
        List<View> views = service.getAllViews();
        return ResponseEntity.ok().body(views);
    }
}
