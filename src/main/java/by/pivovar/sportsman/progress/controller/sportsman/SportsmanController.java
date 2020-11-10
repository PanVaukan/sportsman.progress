package by.pivovar.sportsman.progress.controller.sportsman;

import by.pivovar.sportsman.progress.model.sportsman.SportsmanEntity;
import by.pivovar.sportsman.progress.service.sportsman.SportsmanService;
import org.springframework.web.bind.annotation.*;

@RestController
public class SportsmanController {

    private final SportsmanService sportsmanService;
    private final SportsmanDtoConverter sportsmanDtoConverter;

    public SportsmanController(SportsmanService sportsmanService, SportsmanDtoConverter sportsmanDtoConverter) {
        this.sportsmanService = sportsmanService;
        this.sportsmanDtoConverter = sportsmanDtoConverter;
    }

    @GetMapping("/sportsmans")
    @ResponseBody
    SportsmanListDto getAll(){
        return sportsmanDtoConverter.getSportsmanListDto();
    }

    @GetMapping("/sportsmans/{id}")
    @ResponseBody
    SportsmanDto findSportsman(@PathVariable Long id){
        SportsmanEntity sportsman = sportsmanService.findById(id);
        return sportsmanDtoConverter.convertSportsmanToDto(sportsman);
    }

    @PostMapping("/sportsmans")
    SportsmanDto createSportsman(@RequestBody SportsmanDto sportsmanDto){
        SportsmanEntity sportsmanEntity = sportsmanDtoConverter.convertDtoToSportsman(sportsmanDto);
        sportsmanEntity = sportsmanService.createSportsman(sportsmanEntity);
        return sportsmanDtoConverter.convertSportsmanToDto(sportsmanEntity);
    }

}
