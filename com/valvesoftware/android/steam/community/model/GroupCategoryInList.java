package com.valvesoftware.android.steam.community.model;

import com.valvesoftware.android.steam.community.C0815R;

public enum GroupCategoryInList {
    REQUEST_INVITE,
    PRIVATE,
    PUBLIC,
    OFFICIAL,
    SEARCH_ALL;

    public int getDisplayNumber() {
        switch (this) {
            case REQUEST_INVITE:
                return C0815R.string.Group_Invites;
            case OFFICIAL:
                return C0815R.string.Official_Groups;
            case PRIVATE:
                return C0815R.string.Private_Groups;
            case PUBLIC:
                return C0815R.string.Public_Groups;
            case SEARCH_ALL:
                return C0815R.string.Search;
            default:
                return C0815R.string.Unknown;
        }
    }
}
