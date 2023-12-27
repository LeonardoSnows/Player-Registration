package br.com.player.registration.playerregistration.controllers;

import br.com.player.registration.playerregistration.models.Player;
import br.com.player.registration.playerregistration.dtos.PlayerDto;
import br.com.player.registration.playerregistration.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ControllerPlayer {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/register")
    public String nada(RedirectAttributes redirectAttributes) {
        return "home/index";
    }

    @PostMapping("/register/cadastrar")
    public String cadastrar(PlayerDto dados, RedirectAttributes redirectAttributes) throws InterruptedException {
        boolean salvou = playerService.save(dados);
        if (salvou) {
            redirectAttributes.addFlashAttribute("success", "Seus dados foram salvos no banco de dados !");
        } else {
            redirectAttributes.addFlashAttribute("error", "Codinomes não estão mais disponíveis neste grupo !");
        }
        return "redirect:/register";
    }

    @GetMapping("/register/error")
    public String notMoreCodinames() {
        return "errors/fullGroups";
    }

    @GetMapping("/list/players")
    public String listPlayer(Model model) {
        List<Player> jogadores = playerService.findAll();
        model.addAttribute("jogadores", jogadores);
        return "home/listPlayers";
    }

}
