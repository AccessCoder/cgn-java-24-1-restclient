package de.neuefische.cgnjava241restclient.controller;

import de.neuefische.cgnjava241restclient.exceptions.InvalidIdException;
import de.neuefische.cgnjava241restclient.model.RAndMChar;
import de.neuefische.cgnjava241restclient.service.RAndMService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<RAndMChar> getAllRickAndMortyChars(@PathVariable int id) throws InvalidIdException {
        RAndMChar x = service.getRickAndMortyCharById(id);
        return new ResponseEntity<>(x, HttpStatus.CREATED);
    }


}
