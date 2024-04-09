package de.neuefische.cgnjava241restclient.service;

import de.neuefische.cgnjava241restclient.exceptions.InvalidIdException;
import de.neuefische.cgnjava241restclient.model.RAndMChar;
import de.neuefische.cgnjava241restclient.model.RAndMResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RAndMService {

    private final RestClient currywurst;

    public RAndMService(@Value("${RICK_URL}") String baseUrl){
        currywurst = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public List<RAndMChar> getAllRickAndMortyChars() {
       return currywurst.get()
                .uri("/character")
                .retrieve()
                .body(RAndMResponse.class)
               .getResults();
    }

    public RAndMChar getRickAndMortyCharById(int id) throws InvalidIdException {
        if (id <= 826){
            return currywurst.get()
                    .uri("/character/"+id)
                    .retrieve()
                    .body(RAndMChar.class);
        }else throw new InvalidIdException("No Char found with id: " + id);

    }
}
