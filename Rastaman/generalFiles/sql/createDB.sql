DROP TABLE PLAYLIST_SONG;
DROP TABLE PLAYLIST;
DROP TABLE SONG;
DROP TABLE Album;
DROP TABLE Artist_MusicGroup;
DROP TABLE Artist;
DROP TABLE MusicGroup;
DROP TABLE LABEL;
DROP TABLE GENRE;

CREATE TABLE GENRE (
    ID              BIGINT GENERATED BY DEFAULT AS IDENTITY, 
    NAME            VARCHAR(50) NOT NULL, 
    PRIMARY KEY (ID)
);

CREATE TABLE LABEL (
    ID              BIGINT GENERATED BY DEFAULT AS IDENTITY, 
    NAME            VARCHAR(100) NOT NULL, 
    ADDRESS         VARCHAR(100), 
    TELEPHONE_NO    VARCHAR(20), 
    PRIMARY KEY (ID)
);

CREATE TABLE MusicGroup (
  musicGroupID  bigint GENERATED BY DEFAULT AS IDENTITY, 
  name          varchar(50) NOT NULL, 
  formationDate date, 
  PRIMARY KEY (musicGroupID)
);

CREATE TABLE Artist (
  ArtistID     bigint GENERATED BY DEFAULT AS IDENTITY, 
  lastName     varchar(50), 
  firstName    varchar(50), 
  artisticName varchar(50), 
  sex          varchar(1) NOT NULL, 
  birthDay     date, 
  birthPlace   varchar(100), 
  musciGenreID BIGINT NOT NULL, 
  PRIMARY KEY (ArtistID),
  FOREIGN KEY (musciGenreID) REFERENCES GENRE (ID) ON DELETE Restrict
);

CREATE TABLE Artist_MusicGroup (
  ArtistArtistID         bigint NOT NULL, 
  MusicGroupmusicGroupID bigint NOT NULL, 
  PRIMARY KEY (ArtistArtistID, MusicGroupmusicGroupID),
  FOREIGN KEY (MusicGroupmusicGroupID) REFERENCES MusicGroup (musicGroupID) ON DELETE Cascade,
  FOREIGN KEY (ArtistArtistID) REFERENCES Artist (ArtistID) ON DELETE Restrict
);

CREATE TABLE Album (
  albumID                bigint GENERATED BY DEFAULT AS IDENTITY, 
  title                  varchar(100) NOT NULL, 
  labelID                bigint NOT NULL, 
  releaseDate            date, 
  type                   varchar(2) NOT NULL, 
  diskNumber             integer DEFAULT 1 NOT NULL, 
  ArtistArtistID         bigint, 
  MusicGroupmusicGroupID bigint, 
  PRIMARY KEY (albumID),
  FOREIGN KEY (MusicGroupmusicGroupID) REFERENCES MusicGroup (musicGroupID) ON DELETE Restrict,
  FOREIGN KEY (ArtistArtistID) REFERENCES Artist (ArtistID) ON DELETE Restrict,
  FOREIGN KEY (labelID) REFERENCES LABEL (ID) ON DELETE Restrict
);

CREATE TABLE SONG (
    ID              BIGINT GENERATED BY DEFAULT AS IDENTITY, 
    TITLE           VARCHAR(100) NOT NULL, 
    DURATION        INTEGER NOT NULL, 
    TRACK_NO        INTEGER NOT NULL, 
    ALBUM_ID        BIGINT NOT NULL, 
    PRIMARY KEY (ID),
    FOREIGN KEY (ALBUM_ID) REFERENCES Album (albumID) ON DELETE CASCADE
);

CREATE TABLE PLAYLIST (
    ID              BIGINT GENERATED BY DEFAULT AS IDENTITY, 
    NAME            VARCHAR(100) NOT NULL, 
    CREATION_DATE   DATE NOT NULL, 
    PRIMARY KEY (ID)
);

CREATE TABLE PLAYLIST_SONG (
    ID              BIGINT GENERATED BY DEFAULT AS IDENTITY,
    PLAYLIST_ID     BIGINT NOT NULL,
    SLOT            INTEGER NOT NULL,    
    SONG_ID         BIGINT NOT NULL, 
    PRIMARY KEY (ID),
    FOREIGN KEY (SONG_ID) REFERENCES SONG (ID) ON DELETE RESTRICT,
    FOREIGN KEY (PLAYLIST_ID) REFERENCES PLAYLIST (ID) ON DELETE CASCADE
);
