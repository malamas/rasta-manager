-- genres
INSERT INTO MusicGenre VALUES (1, 'Rock');
INSERT INTO MusicGenre VALUES (2, 'Pop');
INSERT INTO MusicGenre VALUES (3, 'Folk');
INSERT INTO MusicGenre VALUES (4, 'World');
INSERT INTO MusicGenre VALUES (5, 'R&B');
INSERT INTO MusicGenre VALUES (6, 'Tango');
INSERT INTO MusicGenre VALUES (7, 'Latin');
INSERT INTO MusicGenre VALUES (8, 'Classical');
INSERT INTO MusicGenre VALUES (9, 'Reggae');
INSERT INTO MusicGenre VALUES (10, 'Blues');
INSERT INTO MusicGenre VALUES (11, 'Hip hop');
ALTER TABLE MusicGenre ALTER COLUMN musicGenreID RESTART WITH 12;

-- labels
INSERT INTO Label VALUES (1, 'Harvest', NULL, NULL);
INSERT INTO Label VALUES (2, 'Swan Song', NULL, NULL);
INSERT INTO Label VALUES (3, 'Atlantic', NULL, NULL);
INSERT INTO Label VALUES (4, 'Sony Music', '550 Madison Ave., New York, NY 10022, USA', NULL);
INSERT INTO Label VALUES (5, 'Universal Music', '2220 Colorado Avenue, Santa Monica, CA 90404, USA', NULL);
INSERT INTO Label VALUES (6, 'Warner Music', '75 Rockefeller Plaza, New York, NY 10019, USA', NULL);
INSERT INTO Label VALUES (7, 'Island Records', NULL, NULL);
ALTER TABLE Label ALTER COLUMN labelID RESTART WITH 8;

-- groups
INSERT INTO MusicGroup VALUES (1, 'Pink Floyd', '1965-01-01');
INSERT INTO MusicGroup VALUES (2, 'Led Zeppelin', '1968-01-01');
ALTER TABLE MusicGroup ALTER COLUMN musicGroupID RESTART WITH 3;

-- artists
INSERT INTO Artist VALUES (1, 'Waters', 'Roger', NULL, 'm', '1943-09-06', 'Great Bookham, Surrey, England, UK', 1);
INSERT INTO Artist VALUES (2, 'Gilmour', 'David', NULL, 'm', '1946-03-06', 'Cambridge, England, UK', 1);
INSERT INTO Artist VALUES (3, 'Mason', 'Nick', NULL, 'm', '1944-01-27', 'Edgbaston, Birmingham, England, UK', 1);
INSERT INTO Artist VALUES (4, 'Wright', 'Richard', NULL, 'm', '1943-07-28', 'Hatch End, Middlesex, England, UK', 1);
INSERT INTO Artist VALUES (5, 'Barrett', 'Syd', NULL, 'm', '1946-01-06', 'Cambridge, England, UK', 1);
INSERT INTO Artist VALUES (6, 'Page', 'Jimmy', NULL, 'm', '1944-01-09', 'Heston, Middlesex, England, UK', 1);
INSERT INTO Artist VALUES (7, 'Plant', 'Robert', NULL, 'm', '1948-08-20', 'West Bromwich, Staffordshire, England, UK', 1);
INSERT INTO Artist VALUES (8, 'Bonham', 'John', NULL, 'm', '1948-05-31', 'Redditch, Worcestershire, England, UK', 1);
INSERT INTO Artist VALUES (9, 'Jones', 'John Paul', NULL, 'm', '1946-01-03', 'Sidcup, Kent, England, UK', 1);
INSERT INTO Artist VALUES (10, 'Χατζηδάκις', 'Μάνος', NULL, 'm', '1925-10-23', 'Ξάνθη, Ελλάδα', 4);
INSERT INTO Artist VALUES (11, NULL, NULL, 'Eminem', 'm', '1972-10-17', 'Detroit, Michigan, USA', 11);
INSERT INTO Artist VALUES (12, 'Marley', 'Robert Nesta', 'Bob Marley', 'm', '1945-02-06', 'Nine Mile, Saint Ann, Jamaica', 9);
ALTER TABLE Artist ALTER COLUMN ArtistID RESTART WITH 13;

-- group artists
-- Pink Floyd members
INSERT INTO Artist_MusicGroup VALUES (1, 1);
INSERT INTO Artist_MusicGroup VALUES (2, 1);
INSERT INTO Artist_MusicGroup VALUES (3, 1);
INSERT INTO Artist_MusicGroup VALUES (4, 1);
INSERT INTO Artist_MusicGroup VALUES (5, 1);

-- Led Zeppelin members
INSERT INTO Artist_MusicGroup VALUES (6, 2);
INSERT INTO Artist_MusicGroup VALUES (7, 2);
INSERT INTO Artist_MusicGroup VALUES (8, 2);
INSERT INTO Artist_MusicGroup VALUES (9, 2);
--

-- albums
INSERT INTO Album VALUES (1, 'The Dark Side Of The Moon', 1, '1973-03-01', 'lp', 1, NULL, 1);
INSERT INTO Album VALUES (2, 'Celebration Day', 2, '2012-11-16', 'lp', 1, NULL, 2);
INSERT INTO Album VALUES (3, 'Celebration Day', 2, '2012-11-16', 'lp', 2, NULL, 2);
INSERT INTO Album VALUES (4, 'Reflections', 3, '1970-01-01', 'lp', 1, 10, NULL);
INSERT INTO Album VALUES (5, 'Rastaman Vibration', 7, '1976-04-30', 'lp', 1, 12, NULL);
ALTER TABLE Album ALTER COLUMN albumID RESTART WITH 6;

-- songs
INSERT INTO SONG VALUES (1, 'Speak To Me', 90, 1, 1);
INSERT INTO SONG VALUES (2, 'Breathe', 163, 2, 1);
INSERT INTO SONG VALUES (3, 'On The Run', 210, 3, 1);
INSERT INTO SONG VALUES (4, 'Time', 413, 4, 1);
INSERT INTO SONG VALUES (5, 'The Great Gig In The Sky', 255, 5, 1);
INSERT INTO SONG VALUES (6, 'Money', 390, 6, 1);
INSERT INTO SONG VALUES (7, 'Us And Them', 454, 7, 1);
INSERT INTO SONG VALUES (8, 'Any Colour You Like', 204, 8, 1);
INSERT INTO SONG VALUES (9, 'Brain Damage', 230, 9, 1);
INSERT INTO SONG VALUES (10, 'Eclipse', 105, 10, 1);
INSERT INTO SONG VALUES (11, 'Good Times Bad Times', 190, 1, 2);
INSERT INTO SONG VALUES (12, 'Ramble On', 337, 2, 2);
INSERT INTO SONG VALUES (13, 'Black Dog', 318, 3, 2);
INSERT INTO SONG VALUES (14, 'In My Time Of Dying', 661, 4, 2);
INSERT INTO SONG VALUES (15, 'For Your Life', 368, 5, 2);
INSERT INTO SONG VALUES (16, 'Trampled Under Foot', 362, 6, 2);
INSERT INTO SONG VALUES (17, 'Nobody''s Fault But Mine', 384, 7, 2);
INSERT INTO SONG VALUES (18, 'No Quarter', 540, 8, 2);
INSERT INTO SONG VALUES (19, 'Since I''ve Been Loving You', 455, 1, 3);
INSERT INTO SONG VALUES (20, 'Dazed And Confused', 679, 2, 3);
INSERT INTO SONG VALUES (21, 'Stairway To Heaven', 508, 3, 3);
INSERT INTO SONG VALUES (22, 'The Song Remains The Same', 335, 4, 3);
INSERT INTO SONG VALUES (23, 'Misty Mountain Hop', 288, 5, 3);
INSERT INTO SONG VALUES (24, 'Kashmir', 528, 6, 3);
INSERT INTO SONG VALUES (25, 'Whole Lotta Love', 409, 7, 3);
INSERT INTO SONG VALUES (26, 'Rock And Roll', 259, 8, 3);
INSERT INTO SONG VALUES (27, 'Orpheus', 151, 1, 4);
INSERT INTO SONG VALUES (28, 'The Day', 220, 2, 4);
INSERT INTO SONG VALUES (29, 'Love Her', 257, 3, 4);
INSERT INTO SONG VALUES (30, 'Dance Of The Dogs', 178, 4, 4);
INSERT INTO SONG VALUES (31, 'Kemal', 241, 5, 4);
INSERT INTO SONG VALUES (32, 'Dedication', 167, 6, 4);
INSERT INTO SONG VALUES (33, 'The Three Answers', 228, 7, 4);
INSERT INTO SONG VALUES (34, 'Street Song', 206, 8, 4);
INSERT INTO SONG VALUES (35, 'Bitter Way', 255, 9, 4);
INSERT INTO SONG VALUES (36, 'Noble Dame', 191, 10, 4);
INSERT INTO SONG VALUES (37, 'Positive Vibration', 214, 1, 5);
INSERT INTO SONG VALUES (38, 'Roots, Rock, Reggae', 218, 2, 5);
INSERT INTO SONG VALUES (39, 'Johnny Was', 228, 3, 5);
INSERT INTO SONG VALUES (40, 'Cry to Me', 156, 4, 5);
INSERT INTO SONG VALUES (41, 'Want More', 254, 5, 5);
INSERT INTO SONG VALUES (42, 'Crazy Baldhead', 192, 6, 5);
INSERT INTO SONG VALUES (43, 'Who the Cap Fit', 283, 7, 5);
INSERT INTO SONG VALUES (44, 'Night Shift', 190, 8, 5);
INSERT INTO SONG VALUES (45, 'War', 216, 9, 5);
INSERT INTO SONG VALUES (46, 'Rat Race', 170, 10, 5);
ALTER TABLE SONG ALTER COLUMN SONG_ID RESTART WITH 47;

-- playlists
INSERT INTO PLAYLIST VALUES (1, 'Afternoon classics', '2015-02-01');
INSERT INTO PLAYLIST VALUES (2, 'Evening energy', '2015-02-02');
INSERT INTO PLAYLIST VALUES (3, 'Midnight mood', '2015-02-03');
ALTER TABLE PLAYLIST ALTER COLUMN PLAYLIST_ID RESTART WITH 4;

-- playlist songs
-- playlist #1 contents
INSERT INTO PLAYLIST_SONG VALUES (1, 1, 1, 6);
INSERT INTO PLAYLIST_SONG VALUES (2, 1, 2, 40);
INSERT INTO PLAYLIST_SONG VALUES (3, 1, 3, 18);
INSERT INTO PLAYLIST_SONG VALUES (4, 1, 4, 33);
INSERT INTO PLAYLIST_SONG VALUES (5, 1, 5, 21);
INSERT INTO PLAYLIST_SONG VALUES (6, 1, 6, 12);
INSERT INTO PLAYLIST_SONG VALUES (7, 1, 7, 39);
INSERT INTO PLAYLIST_SONG VALUES (8, 1, 8, 9);

-- playlist #2 contents
INSERT INTO PLAYLIST_SONG VALUES (9, 2, 1, 10);
INSERT INTO PLAYLIST_SONG VALUES (10, 2, 2, 21);
INSERT INTO PLAYLIST_SONG VALUES (11, 2, 3, 4);
INSERT INTO PLAYLIST_SONG VALUES (12, 2, 4, 18);
INSERT INTO PLAYLIST_SONG VALUES (13, 2, 5, 31);
INSERT INTO PLAYLIST_SONG VALUES (14, 2, 6, 33);
INSERT INTO PLAYLIST_SONG VALUES (15, 2, 7, 15);
INSERT INTO PLAYLIST_SONG VALUES (16, 2, 8, 9);
INSERT INTO PLAYLIST_SONG VALUES (17, 2, 9, 44);

-- playlist #3 contents
INSERT INTO PLAYLIST_SONG VALUES (18, 3, 1, 8);
INSERT INTO PLAYLIST_SONG VALUES (19, 3, 2, 5);
INSERT INTO PLAYLIST_SONG VALUES (20, 3, 3, 11);
INSERT INTO PLAYLIST_SONG VALUES (21, 3, 4, 17);
INSERT INTO PLAYLIST_SONG VALUES (22, 3, 5, 23);
INSERT INTO PLAYLIST_SONG VALUES (23, 3, 6, 3);
INSERT INTO PLAYLIST_SONG VALUES (24, 3, 7, 29);
INSERT INTO PLAYLIST_SONG VALUES (25, 3, 8, 38);
INSERT INTO PLAYLIST_SONG VALUES (26, 3, 9, 14);
INSERT INTO PLAYLIST_SONG VALUES (27, 3, 10, 7);
INSERT INTO PLAYLIST_SONG VALUES (28, 3, 11, 45);
INSERT INTO PLAYLIST_SONG VALUES (29, 3, 12, 32);
INSERT INTO PLAYLIST_SONG VALUES (30, 3, 13, 25);
INSERT INTO PLAYLIST_SONG VALUES (31, 3, 14, 41);
INSERT INTO PLAYLIST_SONG VALUES (32, 3, 15, 6);
--
ALTER TABLE PLAYLIST_SONG ALTER COLUMN PLAYLIST_SONG_ID RESTART WITH 33;