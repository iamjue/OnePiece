package com.iamjue.onepiece;

import android.os.Parcel;
import android.os.Parcelable;

public class Onepiece implements Parcelable {
    String name, nickname, bounty, photo, desc;


    protected Onepiece(Parcel in) {
        name = in.readString();
        nickname = in.readString();
        bounty = in.readString();
        photo = in.readString();
        desc = in.readString();
    }

    public static final Creator<Onepiece> CREATOR = new Creator<Onepiece>() {
        @Override
        public Onepiece createFromParcel(Parcel in) {
            return new Onepiece(in);
        }

        @Override
        public Onepiece[] newArray(int size) {
            return new Onepiece[size];
        }
    };

    public Onepiece() {

    }

    public Onepiece(String name, String nickname, String bounty, String photo, String desc) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBounty() {
        return bounty;
    }

    public void setBounty(String bounty) {
        this.bounty = bounty;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeString(nickname);
        dest.writeString(bounty);
        dest.writeString(photo);
        dest.writeString(desc);
    }

}
