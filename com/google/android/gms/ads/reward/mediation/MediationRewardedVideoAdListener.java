package com.google.android.gms.ads.reward.mediation;

import com.google.android.gms.ads.reward.RewardItem;

public interface MediationRewardedVideoAdListener {
    void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter);

    void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i);

    void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter);

    void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter);

    void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter);

    void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter);

    void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem);

    void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter);
}
