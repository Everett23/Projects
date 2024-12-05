public class CircularPlaylist {
    private static class SongNode {
        String songName;
        SongNode next;
        SongNode prev;

        SongNode(String songName) {
            this.songName = songName;
        }
    }

    private SongNode current;

    // Add a song to the playlist
    public void addSong(String songName) {
        SongNode newSong = new SongNode(songName);

        if (current == null) {
            initializePlaylist(newSong);
        } else {
            insertSong(newSong);
        }

        System.out.println("Added: " + songName);
    }

    private void initializePlaylist(SongNode newSong) {
        current = newSong;
        current.next = current;
        current.prev = current;
    }

    private void insertSong(SongNode newSong) {
        SongNode last = current.prev;
        last.next = newSong;
        newSong.prev = last;
        newSong.next = current;
        current.prev = newSong;
    }

    // Remove a song from the playlist
    public void removeSong(String songName) {
        if (current == null) {
            System.out.println("Playlist is empty. Nothing to remove.");
            return;
        }

        SongNode temp = current;
        do {
            if (temp.songName.equals(songName)) {
                handleSongRemoval(temp);
                System.out.println("Removed: " + songName);
                return;
            }
            temp = temp.next;
        } while (temp != current);

        System.out.println("Song not found: " + songName);
    }

    private void handleSongRemoval(SongNode songToRemove) {
        if (songToRemove.next == songToRemove) {
            current = null; // Only one song in the playlist
        } else {
            songToRemove.prev.next = songToRemove.next;
            songToRemove.next.prev = songToRemove.prev;

            if (songToRemove == current) {
                current = songToRemove.next;
            }
        }
    }

    // Move to the next song
    public void nextSong() {
        if (current == null) {
            System.out.println("Playlist is empty.");
        } else {
            current = current.next;
            System.out.println("Now playing: " + current.songName);
        }
    }

    // Move to the previous song
    public void previousSong() {
        if (current == null) {
            System.out.println("Playlist is empty.");
        } else {
            current = current.prev;
            System.out.println("Now playing: " + current.songName);
        }
    }

    // Display the current song
    public void displayCurrentSong() {
        if (current == null) {
            System.out.println("No song is playing.");
        } else {
            System.out.println("Currently playing: " + current.songName);
        }
    }

    // Display all songs in the playlist
    public void displayPlaylist() {
        if (current == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        SongNode temp = current;
        System.out.println("Playlist:");
        do {
            System.out.println("- " + temp.songName);
            temp = temp.next;
        } while (temp != current);
    }

    // Main method for testing
    public static void main(String[] args) {
        CircularPlaylist playlist = new CircularPlaylist();

        playlist.addSong("Church");
        playlist.addSong("Falling");
        playlist.addSong("Swim");

        playlist.displayPlaylist();
        playlist.displayCurrentSong();

        playlist.nextSong();
        playlist.nextSong();

        playlist.previousSong();

        playlist.removeSong("Falling");
        playlist.displayPlaylist();

        playlist.removeSong("Church");
        playlist.removeSong("Swim");
        playlist.displayPlaylist();
    }
}
