package teamProject.server;

public interface ServerInterface {
	void broadCast();
	String loadListMoive();
	String loadListActor();
	String loadRecentMovie();
	String searchMovieInfo(String movieName);
	String searchActorInfo(String actorName);
	
	
}
