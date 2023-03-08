package com.ns.naturalapp.Controller;

import com.ns.naturalapp.Config.View;
import com.ns.naturalapp.DTO.EntityDTO;
import com.ns.naturalapp.DTO.GetViewDTO;
import com.ns.naturalapp.DTO.QueryElements;
import com.ns.naturalapp.DTO.QueryServiceInterface;
import com.ns.naturalapp.NaturalAppApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ns.naturalapp.NaturalAppApplication.*;

@org.springframework.stereotype.Controller
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QueryController {

    private final QueryServiceInterface queryService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/views")
    public ResponseEntity<EntityDTO> getEntity(@RequestBody GetViewDTO body) {
        EntityDTO entityDTO = queryService.getView(body.getName(), body.getLimit(),body.getOffset(),body.getRequestConditions());
        return ResponseEntity.ok().body(entityDTO);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/viewNames")
    public ResponseEntity<List<View>> getAllViewNames() {
        List<View> viewList =  new ArrayList<>();
        for(QueryElements queryElements : initMap.values()){
            viewList.add(queryElements.getView());
        }
        return ResponseEntity.ok().body(viewList);
    }
}
