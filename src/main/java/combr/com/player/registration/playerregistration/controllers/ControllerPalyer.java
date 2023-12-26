package combr.com.player.registration.playerregistration.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import combr.com.player.registration.playerregistration.dtos.VingadoresDto;
import combr.com.player.registration.playerregistration.models.Player;
import combr.com.player.registration.playerregistration.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;

@Controller
public class ControllerPalyer {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/register")
    public String nada(Model model) {
        return "home/index";
    }

    @PostMapping("/register/cadastrar")
    public String cadastrar(Player player) {

        return "redirect:/register";
    }

}
