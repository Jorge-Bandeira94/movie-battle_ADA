package br.ada.americanas.moviebattle.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PlayerService {

    private PlayerRepository repository;

    @Autowired
    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public Player add(Player player) {
        return this.repository.save(player);
    }

    public Player update(Player player) {
        return this.repository.save(player);
    }

    public Iterable<Player> list() {
        return this.repository.findAll();
    }

    public Optional<Player> findById(Long id) {
        return this.repository.findById(id);
    }

    public Optional<Player> delete(Long id) {
        Optional<Player> deleted = findById(id);
        this.repository.deleteById(id);
        return deleted;
    }

    public static List<Player> sortDescendingByScore(Iterable<Player> players) {
        return StreamSupport.stream(players.spliterator(), false)
                .sorted(Comparator.comparingDouble(Player::getScore).reversed())
                .collect(Collectors.toList());
    }


}
