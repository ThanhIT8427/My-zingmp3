package com.example.zingmp3.Model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Likedsong implements Parcelable {

@SerializedName("songid")
@Expose
private String songid;
@SerializedName("albumid")
@Expose
private String albumid;
@SerializedName("categoryid")
@Expose
private String categoryid;
@SerializedName("playlistid")
@Expose
private String playlistid;
@SerializedName("songname")
@Expose
private String songname;
@SerializedName("songimg")
@Expose
private String songimg;
@SerializedName("songsinger")
@Expose
private String songsinger;
@SerializedName("songlike")
@Expose
private String songlike;

    protected Likedsong(Parcel in) {
        songid = in.readString();
        albumid = in.readString();
        categoryid = in.readString();
        playlistid = in.readString();
        songname = in.readString();
        songimg = in.readString();
        songsinger = in.readString();
        songlike = in.readString();
    }

    public Likedsong() {
    }

    public static final Creator<Likedsong> CREATOR = new Creator<Likedsong>() {
        @Override
        public Likedsong createFromParcel(Parcel in) {
            return new Likedsong(in);
        }

        @Override
        public Likedsong[] newArray(int size) {
            return new Likedsong[size];
        }
    };

    public String getSongid() {
return songid;
}

public void setSongid(String songid) {
this.songid = songid;
}

public String getAlbumid() {
return albumid;
}

public void setAlbumid(String albumid) {
this.albumid = albumid;
}

public String getCategoryid() {
return categoryid;
}

public void setCategoryid(String categoryid) {
this.categoryid = categoryid;
}

public String getPlaylistid() {
return playlistid;
}

public void setPlaylistid(String playlistid) {
this.playlistid = playlistid;
}

public String getSongname() {
return songname;
}

public void setSongname(String songname) {
this.songname = songname;
}

public String getSongimg() {
return songimg;
}

public void setSongimg(String songimg) {
this.songimg = songimg;
}

public String getSongsinger() {
return songsinger;
}

public void setSongsinger(String songsinger) {
this.songsinger = songsinger;
}

public String getSonglike() {
return songlike;
}

public void setSonglike(String songlike) {
this.songlike = songlike;
}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(songid);
        parcel.writeString(albumid);
        parcel.writeString(categoryid);
        parcel.writeString(playlistid);
        parcel.writeString(songname);
        parcel.writeString(songimg);
        parcel.writeString(songsinger);
        parcel.writeString(songlike);
    }
}