package sh.losti.app.models;

import sh.losti.app.enums.EProfileNetworkType;

public class ProfileNetwork {
    private int profileId;
    private String networkName;
    private EProfileNetworkType networkType;
    private String networkUrl;

    public ProfileNetwork(int profileId, String networkUrl) {
        this.profileId = profileId;
        this.networkUrl = networkUrl;
    }

    public ProfileNetwork(
            int profileId,
            String networkName,
            EProfileNetworkType networkType
    ) {
        this.profileId = profileId;
        this.networkName = networkName;
        this.networkType = networkType;
    }

    public ProfileNetwork(
            int profileId,
            String networkName,
            EProfileNetworkType networkType,
            String networkUrl
    ) {
        this.profileId = profileId;
        this.networkName = networkName;
        this.networkType = networkType;
        this.networkUrl = networkUrl;
    }
}
