package org.demo.core.service;

import org.springframework.stereotype.Service;

@Service
public class HealthService {

    public boolean checkLiveness() {
        return true;
    }

    public boolean checkReadiness() {
        return true;
    }
}
