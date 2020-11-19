package by.pivovar.sportsman.progress.controller.sportsman;

import by.pivovar.sportsman.progress.model.sportsman.SportsmanEntity;
import by.pivovar.sportsman.progress.service.sportsman.SportsmanService;
import by.pivovar.sportsman.progress.service.sportsman.creation.SportsmanCreationRequest;
import by.pivovar.sportsman.progress.service.sportsman.update.SportsmanUpdateRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class SportsmanDtoConverter {

    private final SportsmanService sportsmanService;
    private final ModelMapper modelMapper;

    public SportsmanDtoConverter(SportsmanService sportsmanService, ModelMapper modelMapper) {
        this.sportsmanService = sportsmanService;
        this.modelMapper = modelMapper;
    }

    public SportsmanDto convertModelToDto(SportsmanEntity sportsmanEntity){

        SportsmanDto sportsmanDto = new SportsmanDto();
        sportsmanDto.setFirstName(sportsmanEntity.getFirstName());
        sportsmanDto.setLastName(sportsmanEntity.getLastName());
        sportsmanDto.setBirthday(sportsmanEntity.getBirthday());
        sportsmanDto.setEmail(sportsmanEntity.getEmail());

        return sportsmanDto;

    }

    public SportsmanListDto getSportsmanListDto(){

        SportsmanListDto sportsmanListDto = new SportsmanListDto();
        List<SportsmanEntity> sportsmanList = sportsmanService.findAll();
        Type typeList = new TypeToken<List<SportsmanDto>>(){}.getType();
        List<SportsmanDto> listSportsmanDto = modelMapper.map(sportsmanList,typeList);
        sportsmanListDto.setSportsmans(listSportsmanDto);

        return sportsmanListDto;
    }

    SportsmanCreationRequest convertDtoToSportsmanForCreation(SportsmanCreationDto sportsmanCreationDto) {
        SportsmanCreationRequest sportsmanModel = new SportsmanCreationRequest();
        sportsmanModel.setId(null);
        sportsmanModel.setFirstName(sportsmanCreationDto.getFirstName());
        sportsmanModel.setLastName(sportsmanCreationDto.getLastName());
        sportsmanModel.setBirthday(sportsmanCreationDto.getBirthday());
        sportsmanModel.setEmail(sportsmanCreationDto.getEmail());

        return sportsmanModel;

    }

    public SportsmanEntity convertDtoToSportsmanForUpdate(SportsmanDto dto){

        SportsmanEntity sportsmanEntity = new SportsmanEntity();
        sportsmanEntity.setFirstName(dto.getFirstName());
        sportsmanEntity.setLastName(dto.getLastName());
        sportsmanEntity.setBirthday(dto.getBirthday());
        sportsmanEntity.setEmail(dto.getEmail());

        return sportsmanEntity;

    }

    SportsmanUpdateRequest convertDtoToModelForUpdate(Long id, SportsmanUpdateDto sportsmanUpdateDto){
        SportsmanUpdateRequest sportsmanModel = new SportsmanUpdateRequest();
        sportsmanModel.setId(id);
        sportsmanModel.setFirstName(sportsmanUpdateDto.getFirstName());
        sportsmanModel.setLastName(sportsmanUpdateDto.getLastName());
        sportsmanModel.setBirthday(sportsmanUpdateDto.getBirthday());
        sportsmanModel.setEmail(sportsmanUpdateDto.getEmail());

        return sportsmanModel;

    }



}
