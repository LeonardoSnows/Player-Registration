package combr.com.player.registration.playerregistration.services;


import combr.com.player.registration.playerregistration.dtos.PlayerDto;
import combr.com.player.registration.playerregistration.models.Player;
import combr.com.player.registration.playerregistration.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Autowired
    private CodinomeService codinomeService;

    public boolean save(PlayerDto dados) {
        Player newPLayer = new Player(dados);
        String codinome = getCodiname(newPLayer.getGrupo());
        if (!codinome.equals("false")) {
            newPLayer.setCodinome(codinome);
            repository.save(newPLayer);
            return true;
        }
        return false;
    }

    private String getCodiname(String grupo) {
        String getFirstCodiname = "false";

        if (grupo.equals("Liga da Justiça") && !codinomeService.getJusticeLeagueCodinameList().isEmpty()) {
            getFirstCodiname = codinomeService.getJusticeLeagueCodinameList().stream().findFirst().get();
            codinomeService.getJusticeLeagueCodinameList().remove(getFirstCodiname);
            return getFirstCodiname;
        } else if (grupo.equals("Os Vingadores") && !codinomeService.getAvangersCodinameList().isEmpty()) {
            getFirstCodiname = codinomeService.getAvangersCodinameList().stream().findFirst().get();
            codinomeService.getAvangersCodinameList().remove(getFirstCodiname);
            return getFirstCodiname;
        }

        return getFirstCodiname;
    }
}
