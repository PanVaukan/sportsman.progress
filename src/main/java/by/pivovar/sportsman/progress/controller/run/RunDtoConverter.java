package by.pivovar.sportsman.progress.controller.run;

import by.pivovar.sportsman.progress.model.run.RunEntity;
import by.pivovar.sportsman.progress.service.run.RunService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RunDtoConverter {

    private final RunService runService;
    private final ModelMapper modelMapper;

    public RunDtoConverter(RunService runService, ModelMapper modelMapper) {
        this.runService = runService;
        this.modelMapper = modelMapper;
    }

    public RunEntity convertDtoToModel(RunDto dto){

        RunEntity runEntity = new RunEntity();
        runEntity.setStartRun(dto.getStartRun());
        runEntity.setFinishRun(dto.getFinishRun());
        runEntity.setDistance(dto.getDistance());
        runEntity.setSportsmanId(dto.getSportsmanId());
        runEntity.setAverage(runEntity.calculateAverage());
        return runEntity;

    }

    public RunEntity convertDtoToModelForCreation(RunCreationDto dto){

        RunEntity runEntity = new RunEntity();
        runEntity.setStartRun(dto.getStartRun());
        runEntity.setFinishRun(dto.getFinishRun());
        runEntity.setDistance(dto.getDistance());
        runEntity.setSportsmanId(dto.getSportsmanId());
        runEntity.setAverage(runEntity.calculateAverage());
        return runEntity;

    }

    public RunUserDto convertModelToRunDto(RunEntity run, RunUserDto runUserDto) {
        runUserDto.setId(run.getId());
        runUserDto.setStartRun(run.getStartRun());
        runUserDto.setFinishRun(run.getFinishRun());
        runUserDto.setDistance(run.getDistance());
        runUserDto.setSportsmanId(run.getSportsmanId());
        runUserDto.setAverage(run.getAverage());
        return runUserDto;
    }



}
