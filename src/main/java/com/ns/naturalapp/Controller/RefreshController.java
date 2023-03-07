package com.ns.naturalapp.Controller;

import com.ns.naturalapp.DTO.QueryElements;
import com.ns.naturalapp.Service.RefreshService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@org.springframework.stereotype.Controller
@RestController
@RequiredArgsConstructor

public class RefreshController {
    private final RefreshService refreshService;

    @GetMapping("/refreshData")
    public Map<String, QueryElements> getRefreshData(){
        System.out.println(Arrays.asList(refreshService.refreshData()));
        return refreshService.refreshData();
    }
}
