package mp3;

public class Song{
    String title;
    double duration;

    public Song(){

    }
    
    public Song(String title,double duration){
        this.title = title;
        this.duration =duration;
    }

    public String getTitle(){
        return title;
    }

    public double getDuration(){
        return duration;
    }
    @Override
    public String toString(){
        return "Song{"+
                "title='"+title+'\''+
                ", duration="+duration+
                '}';
    }
}