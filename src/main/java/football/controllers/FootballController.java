package football.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/match")
public class FootballController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @Value("${base.url}")
    private String baseUrl;

    @GetMapping("/countries")
    public List<Object> getCountries(@RequestParam String action) {
        Object[] objects = restTemplate.getForObject(getCountryUrl(action), Object[].class);
        return Arrays.asList(objects);
    }

    @GetMapping("/league")
    public List<Object> getLeague(@RequestParam String action, @RequestParam(required = false) Integer countryId) {
        Object[] objects = restTemplate.getForObject(getLeagueUrl(action, countryId), Object[].class);
        return Arrays.asList(objects);
    }

    @GetMapping("/teams")
    public List<Object> getTeams(@RequestParam String action, @RequestParam Integer leagueId) {
        String url = baseUrl + action + "&league_id=" + leagueId + "&APIkey=" + apiKey;
        Object[] objects = restTemplate.getForObject(getTeamUrl(action, leagueId), Object[].class);
        return Arrays.asList(objects);
    }

    @GetMapping
    public List<Object> getOverallPostion(@RequestParam String action, @RequestParam Integer leagueId) {
        Object[] objects = restTemplate.getForObject(getStandingsUrl(action, leagueId), Object[].class);
        return Arrays.asList(objects);
    }

    private String getCountryUrl(String action) {
        return baseUrl + action + "&country_id=" + "&APIkey=" + apiKey;
    }

    private String getTeamUrl(String action, Integer id) {
        return baseUrl + action + "&league_id=" + id + "&APIkey=" + apiKey;
    }

    private String getLeagueUrl(String action, Integer id) {
        return baseUrl + action + "&country_id=" + id + "&APIkey=" + apiKey;
    }

    private String getStandingsUrl(String action, Integer id) {
        return baseUrl + action + "&league_id=" + id + "&APIkey=" + apiKey;
    }
}
