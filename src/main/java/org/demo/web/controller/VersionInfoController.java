package org.demo.web.controller;

import org.demo.core.service.VersionInfoService;
import org.demo.web.model.response.VersionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version")
@Slf4j
public class VersionInfoController {

    private VersionInfoService versionInfoService;

    public VersionInfoController(VersionInfoService versionInfoService) {
        this.versionInfoService = versionInfoService;
    }

    @GetMapping
    public VersionResponse getVersionInfo() {
        log.info("VersionInfoController check version ");

        String serverVersion = versionInfoService.getServerVersion();

        VersionResponse versionResponse = new VersionResponse();
        versionResponse.setServerVersion(serverVersion);

        log.info("VersionInfoController <<<< with server version={}", versionResponse);

        return versionResponse;
    }
}
