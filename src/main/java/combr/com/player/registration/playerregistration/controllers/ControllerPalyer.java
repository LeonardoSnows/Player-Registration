package combr.com.player.registration.playerregistration.controllers;

import combr.com.player.registration.playerregistration.dtos.PlayerDto;
import combr.com.player.registration.playerregistration.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerPalyer {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/register")
    public String nada(Model model) {
        return "home/index";
    }

    @PostMapping("/register/cadastrar")
    public String cadastrar(PlayerDto dados) {
        boolean salvou = playerService.save(dados);
        return salvou ? "redirect:/register" : "redirect:/register/error";
    }

    @GetMapping("/register/error")
    public String notMoreCodinames() {
        return "home/erroPage";
    }

}
