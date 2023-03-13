package br.ada.americanas.moviebattle.player;

import br.ada.americanas.moviebattle.movie.Movie;
import br.ada.americanas.moviebattle.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/app/players")
public class PlayerAppController {

    private PlayerService service;

    @Autowired
    public PlayerAppController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    public String get(Model model) {
        model.addAttribute("players", service.list());
        return "movie/listPlayer";
    }

    @GetMapping("/create/player")
    public String create(Model model) {
        model.addAttribute("player", new Player());
        return "movie/formPlayer";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") Long id,
            Model model
    ) {
        Player player = service.findById(id).get();
        model.addAttribute("player", player);
        return "movie/formPlayer";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") Long id,
            Model model
    ) {
        service.delete(id);
        return "redirect:/app/players";
    }


    @PostMapping
    public String save(@ModelAttribute Player player) {
        service.add(player);
        return "redirect:/app/players";
    }

    @GetMapping("/list/ordered")
    public String listOrdered(Model model) {
        model.addAttribute("players", service.sortDescendingByScore(service.list()));
        return "movie/listPlayerScore";
    }

}
