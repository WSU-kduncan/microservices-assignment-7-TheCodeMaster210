package com.wsu.workorderproservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import static com.wsu.workorderproservice.utilities.Constants.MESSAGE;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class ServiceController {
    private final SerivceService serivceService;

    @GetMapping
    public ResponseEntity<ServiceResponseDTO> getServices(@RequestParam(required = false) boolean isActive) {
        return new ResponseEntity<>(ServiceResponceDTO.builder().meta(Map.of(MESSAGE, "Products retrieved successfully."))
                .data(serivceService.get(isActive)).build(), HttpStatus.OK);
    }
}
