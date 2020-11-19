package by.pivovar.sportsman.progress.controller.run;

import java.util.ArrayList;
import java.util.List;

public class RunListDto {

    List<RunUserDto> runs = new ArrayList<>();

    public List<RunUserDto> getRuns() { return runs; }

    public void setRuns(List<RunUserDto> runs) { this.runs = runs; }

}
