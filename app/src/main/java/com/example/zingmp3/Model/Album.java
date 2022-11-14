package com.example.zingmp3.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Album {

@SerializedName("albumid")
@Expose
private String albumid;
@SerializedName("albumname")
@Expose
private String albumname;
@SerializedName("albumsingername")
@Expose
private String albumsingername;
@SerializedName("albumimg")
@Expose
private String albumimg;

public String getAlbumid() {
return albumid;
}

public void setAlbumid(String albumid) {
this.albumid = albumid;
}

public String getAlbumname() {
return albumname;
}

public void setAlbumname(String albumname) {
this.albumname = albumname;
}

public String getAlbumsingername() {
return albumsingername;
}

public void setAlbumsingername(String albumsingername) {
this.albumsingername = albumsingername;
}

public String getAlbumimg() {
return albumimg;
}

public void setAlbumimg(String albumimg) {
this.albumimg = albumimg;
}

}