package by.pivovar.sportsman.progress.controller.sportsman;

import java.util.ArrayList;
import java.util.List;

public class SportsmanListDto {

    List<SportsmanDto> sportsmans = new ArrayList<>();

    public List<SportsmanDto> getSportsmans() {
        return sportsmans;
    }

    public void setSportsmans(List<SportsmanDto> sportsmans) {
        this.sportsmans = sportsmans;
    }
}
