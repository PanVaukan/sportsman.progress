package by.pivovar.sportsman.progress.controller.run;

import java.time.OffsetDateTime;

public class RunCreationDto {

    private OffsetDateTime startRun;
    private OffsetDateTime finishRun;
    private Double distance;
    private Long sportsmanId;

    public OffsetDateTime getStartRun() {
        return startRun;
    }

    public void setStartRun(OffsetDateTime startRun) {
        this.startRun = startRun;
    }

    public OffsetDateTime getFinishRun() {
        return finishRun;
    }

    public void setFinishRun(OffsetDateTime finishRun) {
        this.finishRun = finishRun;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Long getSportsmanId() {
        return sportsmanId;
    }

    public void setSportsmanId(Long sportsmanId) {
        this.sportsmanId = sportsmanId;
    }
}
