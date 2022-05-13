package teamProject.server;

public interface ServerInterface {
	void broadCast();
	String loadListMoive();
	String loadListActor();
	String loadRecentMovie();
	String searchMovieInfo(String movieName, int id);
	String searchActorInfo(String actorName, int id);
	
	
}
