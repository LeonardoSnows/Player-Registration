package combr.com.player.registration.playerregistration.services;


import combr.com.player.registration.playerregistration.PlayerRegistrationApplication;
import combr.com.player.registration.playerregistration.models.Player;
import combr.com.player.registration.playerregistration.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public Player save(Player dados) {
        Player newPLayer = new Player();
        return repository.save(newPLayer);
    }
}
