package by.pivovar.sportsman.progress.controller.sportsman;

import by.pivovar.sportsman.progress.model.sportsman.SportsmanEntity;
import by.pivovar.sportsman.progress.service.sportsman.SportsmanService;
import by.pivovar.sportsman.progress.service.sportsman.creation.SportsmanCreationRequest;
import by.pivovar.sportsman.progress.service.sportsman.update.SportsmanUpdateRequest;
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
        return sportsmanDtoConverter.convertModelToDto(sportsman);
    }

    @PostMapping("/sportsmans")
    SportsmanDto createSportsman(@RequestBody SportsmanCreationDto sportsmanCreationDto){
        SportsmanCreationRequest sportsmanCreationRequest = sportsmanDtoConverter.convertDtoToSportsmanForCreation(sportsmanCreationDto);
        SportsmanEntity sportsmanEntity = sportsmanService.createSportsman(sportsmanCreationRequest);
        return sportsmanDtoConverter.convertModelToDto(sportsmanEntity);
    }

    @PutMapping("/sportsmans/{id}")
    SportsmanDto updateSportsmanById(@PathVariable Long id, @RequestBody SportsmanUpdateDto sportsmanUpdateDto){
        SportsmanUpdateRequest sportsmanUpdateRequest = sportsmanDtoConverter.convertDtoToModelForUpdate(id, sportsmanUpdateDto);
        SportsmanEntity sportsman = sportsmanService.updateSportsman(sportsmanUpdateRequest);
        return sportsmanDtoConverter.convertModelToDto(sportsman);
    }

    @DeleteMapping("/sportsmans/{id}")
    SportsmanDeleteDto deleteSportsman(@PathVariable Long id){
        SportsmanDeleteDto sportsmanDeleteDto = new SportsmanDeleteDto();
        sportsmanService.deleteById(id);
        SportsmanEntity sportsman = sportsmanService.findById(id);
        sportsmanDeleteDto.setId(sportsman.getId());
       return sportsmanDeleteDto;
    }

}

