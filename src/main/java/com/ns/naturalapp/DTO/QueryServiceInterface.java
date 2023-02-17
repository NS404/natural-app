package com.ns.naturalapp.DTO;

import java.util.Optional;

public interface QueryServiceInterface {
    EntityDTO getView(String name, String limit, String offset, String[] stringConditions);
    String[] parseConditions(String requestConditions);
}
