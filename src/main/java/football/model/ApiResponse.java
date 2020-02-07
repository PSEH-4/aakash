package football.model;

public class ApiResponse {
    private String countryName;
    private String countryId;
    private String teamName;
    private String teamId;
    private String leagueName;
    private String leagueId;
    private String overAllLeaguePosition;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getOverAllLeaguePosition() {
        return overAllLeaguePosition;
    }

    public void setOverAllLeaguePosition(String overAllLeaguePosition) {
        this.overAllLeaguePosition = overAllLeaguePosition;
    }
}
