package by.pivovar.sportsman.progress.controller.run;

import by.pivovar.sportsman.progress.model.run.RunEntity;
import by.pivovar.sportsman.progress.service.run.RunService;
import by.pivovar.sportsman.progress.service.run.validation.exception.StartGreatThanFinishException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Type;
import java.util.List;

@Controller
public class RunController {

    private final ModelMapper modelMapper;
    private final RunService runService;
    private final RunDtoConverter runDtoConverter;

    public RunController(ModelMapper modelMapper, RunService runService, RunDtoConverter runDtoConverter) {
        this.modelMapper = modelMapper;
        this.runService = runService;
        this.runDtoConverter = runDtoConverter;

    }

    @GetMapping("/runs")
    RunListDto getAllRuns() {
        RunListDto runsListDto = new RunListDto();
        List<RunEntity> runList = runService.findAllRuns();
        Type listType = new TypeToken<List<RunUserDto>>(){}.getType();
        List<RunUserDto> dtoList = modelMapper.map(runList, listType);
        runsListDto.setRuns(dtoList);
        return runsListDto;
    }

    @PostMapping("/runs")
    RunUserDto createRun(@RequestBody RunCreationDto dto) throws StartGreatThanFinishException {
        RunEntity runEntity = runDtoConverter.convertDtoToModel(dto);
        runEntity = runService.createRun(runEntity);
        RunUserDto runUserDto = new RunUserDto();
        runUserDto = runDtoConverter.convertModelToRunDto(runEntity, runUserDto);
        return runUserDto;
    }



}
