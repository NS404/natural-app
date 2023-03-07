package com.ns.naturalapp.Controller;

import com.ns.naturalapp.DTO.EntityDTO;
import com.ns.naturalapp.DTO.GetViewDTO;
import com.ns.naturalapp.Service.QueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@org.springframework.stereotype.Controller
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QueryController {

    private final QueryService service;
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/views")
    public ResponseEntity<EntityDTO> getEntity(
            @RequestBody GetViewDTO body,
            @RequestParam(required = false) String limit,
            @RequestParam(required = false) String offset) {
        EntityDTO entityDTO = service.getView(body.getName(), limit, offset);
        return ResponseEntity.ok().body(entityDTO);
    }
}
