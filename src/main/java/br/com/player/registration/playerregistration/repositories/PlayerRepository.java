package br.com.player.registration.playerregistration.repositories;

import br.com.player.registration.playerregistration.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
