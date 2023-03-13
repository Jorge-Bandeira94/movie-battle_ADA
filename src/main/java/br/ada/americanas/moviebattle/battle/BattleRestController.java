package br.ada.americanas.moviebattle.battle;

import br.ada.americanas.moviebattle.movie.Movie;
import br.ada.americanas.moviebattle.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/battles")
public class BattleRestController {

        private BattleService service;

        @Autowired
        public BattleRestController(BattleService service) {
            this.service = service;
        }


        @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
        public Iterable<Battle> list() {
            return service.list();
        }


    }

