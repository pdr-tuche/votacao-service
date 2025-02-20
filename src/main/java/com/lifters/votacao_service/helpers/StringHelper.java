package com.lifters.votacao_service.helpers;

import org.springframework.stereotype.Service;

@Service
public class StringHelper {
    public String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
