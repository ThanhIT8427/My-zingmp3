package com.example.zingmp3.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Playlistcurrentday implements Serializable {

@SerializedName("playlistid")
@Expose
private String playlistid;
@SerializedName("playlistname")
@Expose
private String playlistname;
@SerializedName("playlistbg")
@Expose
private String playlistbg;
@SerializedName("playlistimg")
@Expose
private String playlistimg;

public String getPlaylistid() {
return playlistid;
}

public void setPlaylistid(String playlistid) {
this.playlistid = playlistid;
}

public String getPlaylistname() {
return playlistname;
}

public void setPlaylistname(String playlistname) {
this.playlistname = playlistname;
}

public String getPlaylistbg() {
return playlistbg;
}

public void setPlaylistbg(String playlistbg) {
this.playlistbg = playlistbg;
}

public String getPlaylistimg() {
return playlistimg;
}

public void setPlaylistimg(String playlistimg) {
this.playlistimg = playlistimg;
}

}