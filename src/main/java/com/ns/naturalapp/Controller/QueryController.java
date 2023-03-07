package com.ns.naturalapp.Controller;

import com.ns.naturalapp.DTO.EntityDTO;
import com.ns.naturalapp.DTO.GetViewDTO;
import com.ns.naturalapp.DTO.QueryServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QueryController {

    private final QueryServiceInterface queryService;
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/views")
    public ResponseEntity<EntityDTO> getEntity(@RequestBody GetViewDTO body) {
        String[] stringConditions = queryService.parseConditions(body.getRequestConditions());
        EntityDTO entityDTO = queryService.getView(body.getName(), body.getLimit(),body.getOffset(),stringConditions);

        return ResponseEntity.ok().body(entityDTO);
    }



}
