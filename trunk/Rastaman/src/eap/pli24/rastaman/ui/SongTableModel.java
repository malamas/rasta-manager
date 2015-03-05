/*
 * Copyright (c) 2015 Apostolis Iakovakis, Nikos Karagiannis,
 * Nikos Krommydas & Malamas Malamidis. All rights reserved.
 *
 * This file is part of Rastaman.
 *
 * Rastaman is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Rastaman is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Rastaman.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package eap.pli24.rastaman.ui;

import eap.pli24.rastaman.entities.Song;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public class SongTableModel extends AbstractTableModel {

    private static final int COLUMN_COUNT = 3;
    private List<Song> songList;

    @Override
    public int getRowCount() {
        return ((songList == null) ? 0 : songList.size());
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value;
        Song song = songList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = song.getTitle();
                break;
            case 1:
                value = song.getAlbumId().getPerformerScreenName();
                break;
            case 2:
                value = song.getDuration();
                break;
            default:
                value = null;
                break;
        }
        return value;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

}
