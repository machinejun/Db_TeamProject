package teamProject.client;

import java.util.List;

public interface ClientInterface {

	void loadListMoive(String jsonn);
	void loadListActor(String json);
	void loadRecentMovie(String json);
	void SearchMovieInfo(String json);
	void SearchActorInfo(String json);
	void sentMsg(String msg);
}
