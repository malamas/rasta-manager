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
ALTER TABLE Label ALTER COLUMN labelID RESTART WITH 7;

-- groups
INSERT INTO MusicGroup VALUES (1, 'Pink Floyd', '1965-01-01');
INSERT INTO MusicGroup VALUES (2, 'Led Zeppelin', '1968-01-01');
ALTER TABLE MusicGroup ALTER COLUMN musicGroupID RESTART WITH 3;

-- artists
INSERT INTO Artist VALUES (1, 'Waters', 'Roger', NULL, 'm', NULL, NULL, 1);
INSERT INTO Artist VALUES (2, 'Gilmour', 'David', NULL, 'm', NULL, NULL, 1);
INSERT INTO Artist VALUES (3, 'Mason', 'Nick', NULL, 'm', NULL, NULL, 1);
INSERT INTO Artist VALUES (4, 'Wright', 'Richard', NULL, 'm', NULL, NULL, 1);
INSERT INTO Artist VALUES (5, 'Barrett', 'Syd', NULL, 'm', NULL, NULL, 1);
INSERT INTO Artist VALUES (6, 'Page', 'Jimmy', NULL, 'm', NULL, NULL, 1);
INSERT INTO Artist VALUES (7, 'Plant', 'Robert', NULL, 'm', NULL, NULL, 1);
INSERT INTO Artist VALUES (8, 'Bonham', 'John', NULL, 'm', NULL, NULL, 1);
INSERT INTO Artist VALUES (9, 'Jones', 'John Paul', NULL, 'm', NULL, NULL, 1);
INSERT INTO Artist VALUES (10, 'Χατζηδάκις', 'Μάνος', NULL, 'm', NULL, NULL, 4);
INSERT INTO Artist VALUES (11, NULL, NULL, 'Eminem', 'm', NULL, NULL, 11);
ALTER TABLE Artist ALTER COLUMN ArtistID RESTART WITH 12;

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
ALTER TABLE Album ALTER COLUMN albumID RESTART WITH 5;

-- songs
INSERT INTO Song VALUES (1, 'Speak To Me', 90, 1, 1);
INSERT INTO Song VALUES (2, 'Breathe', 163, 2, 1);
INSERT INTO Song VALUES (3, 'On The Run', 210, 3, 1);
INSERT INTO Song VALUES (4, 'Time', 413, 4, 1);
INSERT INTO Song VALUES (5, 'The Great Gig In The Sky', 255, 5, 1);
INSERT INTO Song VALUES (6, 'Money', 390, 6, 1);
INSERT INTO Song VALUES (7, 'Us And Them', 454, 7, 1);
INSERT INTO Song VALUES (8, 'Any Colour You Like', 204, 8, 1);
INSERT INTO Song VALUES (9, 'Brain Damage', 230, 9, 1);
INSERT INTO Song VALUES (10, 'Eclipse', 105, 10, 1);
INSERT INTO Song VALUES (11, 'Good Times Bad Times', 190, 1, 2);
INSERT INTO Song VALUES (12, 'Ramble On', 337, 2, 2);
INSERT INTO Song VALUES (13, 'Black Dog', 318, 3, 2);
INSERT INTO Song VALUES (14, 'In My Time Of Dying', 661, 4, 2);
INSERT INTO Song VALUES (15, 'For Your Life', 368, 5, 2);
INSERT INTO Song VALUES (16, 'Trampled Under Foot', 362, 6, 2);
INSERT INTO Song VALUES (17, 'Nobody''s Fault But Mine', 384, 7, 2);
INSERT INTO Song VALUES (18, 'No Quarter', 540, 8, 2);
INSERT INTO Song VALUES (19, 'Since I''ve Been Loving You', 455, 1, 3);
INSERT INTO Song VALUES (20, 'Dazed And Confused', 679, 2, 3);
INSERT INTO Song VALUES (21, 'Stairway To Heaven', 508, 3, 3);
INSERT INTO Song VALUES (22, 'The Song Remains The Same', 335, 4, 3);
INSERT INTO Song VALUES (23, 'Misty Mountain Hop', 288, 5, 3);
INSERT INTO Song VALUES (24, 'Kashmir', 528, 6, 3);
INSERT INTO Song VALUES (25, 'Whole Lotta Love', 409, 7, 3);
INSERT INTO Song VALUES (26, 'Rock And Roll', 259, 8, 3);
INSERT INTO Song VALUES (27, 'Orpheus', 151, 1, 4);
INSERT INTO Song VALUES (28, 'The Day', 220, 2, 4);
INSERT INTO Song VALUES (29, 'Love Her', 257, 3, 4);
INSERT INTO Song VALUES (30, 'Dance Of The Dogs', 178, 4, 4);
INSERT INTO Song VALUES (31, 'Kemal', 241, 5, 4);
INSERT INTO Song VALUES (32, 'Dedication', 167, 6, 4);
INSERT INTO Song VALUES (33, 'The Three Answers', 228, 7, 4);
INSERT INTO Song VALUES (34, 'Street Song', 206, 8, 4);
INSERT INTO Song VALUES (35, 'Bitter Way', 255, 9, 4);
INSERT INTO Song VALUES (36, 'Noble Dame', 191, 10, 4);
ALTER TABLE Song ALTER COLUMN songID RESTART WITH 37;

-- playlists
INSERT INTO PlayList VALUES (1, 'Afternoon classics', '2015-02-01');
INSERT INTO PlayList VALUES (2, 'Evening energy', '2015-02-02');
INSERT INTO PlayList VALUES (3, 'Midnight mood', '2015-02-03');
ALTER TABLE PlayList ALTER COLUMN playListID RESTART WITH 4;

-- playlist songs
-- playlist #1 contents
INSERT INTO PlayList_Song VALUES (1, 6);
INSERT INTO PlayList_Song VALUES (1, 2);
INSERT INTO PlayList_Song VALUES (1, 18);
INSERT INTO PlayList_Song VALUES (1, 33);
INSERT INTO PlayList_Song VALUES (1, 21);
INSERT INTO PlayList_Song VALUES (1, 12);
INSERT INTO PlayList_Song VALUES (1, 5);
INSERT INTO PlayList_Song VALUES (1, 9);

-- playlist #2 contents
INSERT INTO PlayList_Song VALUES (2, 10);
INSERT INTO PlayList_Song VALUES (2, 1);

-- playlist #3 contents
INSERT INTO PlayList_Song VALUES (3, 8);
INSERT INTO PlayList_Song VALUES (3, 5);
--