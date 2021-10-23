package com.example.cmpt276as3.model;

public class MineLogic {
    private boolean minePresent = false;
    private boolean mineHidden = true;
    private boolean mineScanned = false;
    private int numScan = 0;
    private boolean mineClicked = false;

    public MineLogic(boolean minePresent) {
        this.minePresent = minePresent;
    }

    public boolean isMinePresent() {
        return minePresent;
    }

    public boolean isMineHidden() {
        return mineHidden;
    }

    public boolean isMineVisible() {
        boolean visible = (minePresent && !mineHidden);
        return visible;
    }

    public boolean isMineClicked() {
        return mineClicked;
    }


    public boolean isMineScanned() {
        return mineScanned;
    }

    public void setMinePresent(boolean minePresent) {
        this.minePresent = minePresent;
    }

    public void setMineClicked(boolean pressed) {
        mineClicked = pressed;
    }

    public void setMineHidden(boolean mineHidden) {
        this.mineHidden = mineHidden;
    }

    public void setMineScanned(boolean mineScanned) {
        this.mineScanned = mineScanned;
    }

    public void setScan() {
        if (isMineVisible() == true) {
            mineScanned = true;
        }
        else {
            mineScanned = true;
        }
    }
}
