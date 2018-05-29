package com.valvesoftware.android.steam.community.model;

import com.valvesoftware.android.steam.community.C0815R;

public enum PersonaStateCategoryInList {
    REQUEST_INCOMING,
    CHATS,
    INGAME,
    ONLINE,
    OFFLINE,
    REQUEST_SENT,
    SEARCH_ALL;

    public int GetDisplayString() {
        switch (this) {
            case REQUEST_INCOMING:
                return C0815R.string.Friend_Requests;
            case CHATS:
                return C0815R.string.Chats;
            case INGAME:
                return C0815R.string.In_Game;
            case ONLINE:
                return C0815R.string.Online;
            case REQUEST_SENT:
            case OFFLINE:
                return C0815R.string.Offline;
            case SEARCH_ALL:
                return C0815R.string.Search;
            default:
                return C0815R.string.Unknown;
        }
    }
}
