public class CircularDoublyLinkedList {
    private class Node {
        String song;
        Node next;
        Node prev;

        Node(String song) {
            this.song = song;
        }
    }

    private Node head;
    private Node tail;
    private Node current;

    // Add a song to the playlist
    public void addSong(String song) {
        Node newNode = new Node(song);
        if (head == null) {
            initializePlaylist(newNode);
        } else {
            appendToPlaylist(newNode);
        }
        System.out.println("Added song: " + song);
    }

    private void initializePlaylist(Node newNode) {
        head = newNode;
        tail = newNode;
        head.next = head;
        head.prev = head;
        current = head;
    }

    private void appendToPlaylist(Node newNode) {
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
        tail = newNode;
    }

    // Remove a song from the playlist
    public void removeSong(String song) {
        if (head == null) {
            System.out.println("Playlist is empty. Cannot remove song.");
            return;
        }

        Node temp = head;
        do {
            if (temp.song.equals(song)) {
                removeNode(temp);
                System.out.println("Removed song: " + song);
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Song not found: " + song);
    }

    private void removeNode(Node temp) {
        if (temp == head && temp == tail) {
            head = null;
            tail = null;
            current = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;

            if (temp == head) {
                head = temp.next;
            }
            if (temp == tail) {
                tail = temp.prev;
            }
            if (temp == current) {
                current = temp.next;
            }
        }
    }

    // Move to the next song
    public void nextSong() {
        if (current == null) {
            System.out.println("Playlist is empty.");
        } else {
            current = current.next;
            System.out.println("Now playing: " + current.song);
        }
    }

    // Move to the previous song
    public void previousSong() {
        if (current == null) {
            System.out.println("Playlist is empty.");
        } else {
            current = current.prev;
            System.out.println("Now playing: " + current.song);
        }
    }

    // Display the current song
    public void displayCurrentSong() {
        if (current == null) {
            System.out.println("No song is playing.");
        } else {
            System.out.println("Currently playing: " + current.song);
        }
    }

    // Display all songs in the playlist
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("Playlist:");
        Node temp = head;
        do {
            System.out.println("- " + temp.song);
            temp = temp.next;
        } while (temp != head);
    }

    // Main method for testing
    public static void main(String[] args) {
        CircularDoublyLinkedList playlist = new CircularDoublyLinkedList();

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
        playlist.removeSong("SWim");
        playlist.displayPlaylist();
    }
}
