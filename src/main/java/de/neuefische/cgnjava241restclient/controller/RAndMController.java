package de.neuefische.cgnjava241restclient.controller;

import de.neuefische.cgnjava241restclient.model.RAndMChar;
import de.neuefische.cgnjava241restclient.service.RAndMService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rick")
@RequiredArgsConstructor
public class RAndMController {

    private final RAndMService service;

    @GetMapping
    public List<RAndMChar> getAllRickAndMortyChars(){
        return service.getAllRickAndMortyChars();
    }

    @GetMapping("/{id}")
    public RAndMChar getAllRickAndMortyChars(@PathVariable int id){
        return service.getRickAndMortyCharById(id);
    }
}
