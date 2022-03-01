
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import mp3.Album;
import mp3.Song;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("ablum1", "AC/DC");

        album.addSong("TNT", 4.5);
        album.addSong("ABC", 3.5);
        album.addSong("DEF", 7.6);

        albums.add(album);

        album = new Album("album2", "test");

        album.addSong("rap god", 4.5);
        album.addSong("test", 5.3);
        album.addSong("alo", 3.5);

        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("TNT", playList);
        albums.get(0).addToPlayList("ABC", playList);
        albums.get(1).addToPlayList("test", playList);
        albums.get(1).addToPlayList("rap god", playList);

        play(playList);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("This playlist have no song");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = Integer.parseInt(sc.nextLine());
            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing" + listIterator.next().toString());
                    } else {
                        System.out.println("No song available, reached to the end of the list ");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasNext()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are first song");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        System.out.println("We have reached to the end of list");
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                    case 5:
                    printMenu();
                    break;
                    case 6:
                    if(playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing "+listIterator.next().toString());
                            forward = true;
                        }else{
                            if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            }
                        }
                    }
                default:
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available options\n press:");
        System.out.println("0 - quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list on all list\n" +
                "5 - print all available options\n" +
                "6 - delete current song");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("------------------");
    }
}
