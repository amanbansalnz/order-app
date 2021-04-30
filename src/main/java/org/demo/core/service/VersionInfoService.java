package org.demo.core.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VersionInfoService {

    @Value("${serverVersion}")
    private String serverVersion;

    public String getServerVersion() {
        return serverVersion;
    }
}
