package com.mrk.service.impl;

import com.mrk.service.WebSessionService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "app.feature.new", havingValue = "false", matchIfMissing = true)
public class PostgreSessionService implements WebSessionService {
    @Override
    public String getUserData() {
        return "Data from PostgreSQL Database";
    }
}
