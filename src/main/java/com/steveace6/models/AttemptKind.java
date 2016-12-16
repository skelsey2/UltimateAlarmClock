package com.steveace6.models;

public enum AttemptKind {
    FOCUS(3, "Focus time"),
    BREAK(25 * 60, "Break time");

    private int mTotalSeconds;
    private String mDisplayName;

    AttemptKind(int totalSeconds, String displayName) {
        mTotalSeconds = totalSeconds;
        mDisplayName = displayName;
    }

    public int getTotalSeconds() {
        return mTotalSeconds;
    }

    public String getDisplayName() {
        return mDisplayName;
    }
}
