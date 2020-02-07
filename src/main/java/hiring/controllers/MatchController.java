package hiring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @Value("${base.url}")
    private String baseUrl;

    @GetMapping("/countries")
    public List<Object> getCountries(@RequestParam String action) {
        String url = baseUrl + action + "&APIkey=" + apiKey;
        Object[] objects = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(objects);
    }

    @GetMapping("/league")
    public List<Object> getLeague(@RequestParam String action, @RequestParam(required = false) Integer countryId) {
        String url = baseUrl + action + "&country_id=" + countryId + "&APIkey=" + apiKey;
        Object[] objects = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(objects);
    }

    @GetMapping("/teams")
    public List<Object> getTeams(@RequestParam String action, @RequestParam Integer leagueId) {
        String url = baseUrl + action + "&league_id=" + leagueId + "&APIkey=" + apiKey;
        Object[] objects = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(objects);
    }

    @GetMapping
    public List<Object> getOverallPostion(@PathVariable(required = false) String path, @RequestParam String action, @RequestParam Integer leagueId) {
        String url = baseUrl + action + "&league_id=" + leagueId + "&APIkey=" + apiKey;
        Object[] objects = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(objects);
    }
}
