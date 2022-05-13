package teamProject.client;

import java.util.List;

public interface ClientInterface {

	void loadListMoive(List<Dto> movielist);
	void loadListActor(List<Dto> acotrlist);
	void loadRecentMovie(List<Dto> movielist);
	void SearchMovieInfo(String movieName);
	void SearchActorInfo(String actorName);
	void sentMsg(String msg);
}
