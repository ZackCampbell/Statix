
package API.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "spell1Id",
    "participantId",
    "timeline",
    "spell2Id",
    "teamId",
    "stats",
    "championId",
    "highestAchievedSeasonTier"
})
@Getter
@ToString
public class ParticipantDTO {

    @JsonProperty("spell1Id")
    private Integer spell1Id;
    @JsonProperty("participantId")
    private Integer participantId;
    @JsonProperty("timeline")
    private TimelineDTO timeline;
    @JsonProperty("spell2Id")
    private Integer spell2Id;
    @JsonProperty("teamId")
    private Integer teamId;
    @JsonProperty("stats")
    private StatsDTO stats;
    @JsonProperty("championId")
    private Integer championId;
    @JsonProperty("highestAchievedSeasonTier")
    private String highestAchievedSeasonTier;

}
